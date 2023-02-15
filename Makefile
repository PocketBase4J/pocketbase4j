SHELL:=/bin/bash
GRADLE_FLAGS = --console plain --full-stacktrace

.PHONY: help
help: ## Show help message
	@grep -hP '^[\w\-\/\.]*?:.*##.*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "%-32s %s\n", $$1, $$2}'

.PHONY: clean
clean: ## Clean project folder
	./gradlew $(GRADLE_FLAGS) clean
	rm -rf $(CURDIR)/bin $(CURDIR)/build $(CURDIR)/run $(CURDIR)/.gradle $(CURDIR)/testenv/pb_data

.PHONY: tests
tests: ## Run tests (gradle check task)
	./gradlew $(GRADLE_FLAGS) check

.PHONY: serve
serve: ## Run PocketBase server
	(cd testenv && go run serve.go)

.PHONY: publish
publish: ## Publish to Maven Central Repository
	./gradlew $(GRADLE_FLAGS) publishToSonatype closeAndReleaseStagingRepository
