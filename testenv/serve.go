package main

import (
	"log"
	"os"

	_ "github.com/PocketBase4J/PocketBase4J/testenv/migrations"
	"github.com/pocketbase/pocketbase"
)

func main() {
	os.Args = append(os.Args[:1], "serve", "--debug")
	if err := pocketbase.New().Start(); err != nil {
		log.Fatal(err)
	}
}
