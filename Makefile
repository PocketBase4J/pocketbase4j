SHELL:=/bin/bash

PB_VER = 0.7.10
PB_URL = https://github.com/pocketbase/pocketbase/releases/download/v$(PB_VER)/pocketbase_$(PB_VER)_linux_amd64.zip

PB_FLAGS = --debug --dir $(CURDIR)/run/pb_data --publicDir $(CURDIR)/run/pb_public
GRADLE_FLAGS = --console plain --full-stacktrace

.PHONY: help
help: ## Show help message
	@grep -hP '^[\w\-\/\.]*?:.*##.*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "%-32s %s\n", $$1, $$2}'

.PHONY: clean
clean: ## Clean project folder
	./gradlew $(GRADLE_FLAGS) clean
	rm -rf $(CURDIR)/bin $(CURDIR)/build $(CURDIR)/run $(CURDIR)/.gradle

.PHONY: tests
tests: ## Run tests (gradle check task)
	./gradlew $(GRADLE_FLAGS) check

.PHONY: publish
publish: ## Publish to Maven Central Repository
	./gradlew $(GRADLE_FLAGS) publishToSonatype closeAndReleaseStagingRepository

.PHONY: pb-serve
pb-serve: bin/pocketbase run/pb_data/data.db ## Run PocketBase server
	$(CURDIR)/bin/pocketbase migrate $(PB_FLAGS)
	$(CURDIR)/bin/pocketbase serve $(PB_FLAGS)

bin/pocketbase: ## PocketBase binary
	if [[ ! -d "bin" ]]; then mkdir "bin"; fi
	temp_dir="$(shell mktemp -d)" \
		&& curl --silent --location --output "$${temp_dir}/pocketbase.zip" "$(PB_URL)" \
		&& unzip "$${temp_dir}/pocketbase.zip" "pocketbase" -d "bin" \
		&& rm -rf "$${temp_dir}"
		chmod +x "bin/pocketbase"

run/pb_data/data.db: ## Default database
	if [[ ! -d "run/pb_data" ]]; then mkdir -p "run/pb_data"; fi
	cp "src/test/resources/default_data.db" "run/pb_data/data.db"
