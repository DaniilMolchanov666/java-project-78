
.DEFAULT_GOAL := build

clean:
	./gradlew clean

build:
	./gradlew clean build

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

build-run: build

.PHONY: build
