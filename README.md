# Examples - Sauce Day Wayfair

Hello! This is a companion code repository for Wayfair Sauce Day, April 15, 2021. 

Ihis resospitory there are examples of using Sauce Labs with

- [Kotlin](./kotlin/README.md)
- [Java](./java/README.md)
- [Cypress](./cypress/README.md)

testing apps against [Swag Labs](www.saucedemo.com).

## Overall Requirements

You will need a Sauce Labs account. Once you get access, you can set your Sauce [username and access key](https://wiki.saucelabs.com/display/DOCS/Viewing+and+Managing+Your+Account+Information), you will need to set them as environment variables on the machine you executing the test from (or CI instance) as 

```
SAUCE_USERNAME='your.username'
SAUCE_ACCESS_KEY=abc-def-ghi-123
```

For the Kotlin/Java examples, Java 8+ is supported and IntelliJ is recommended.

For the Cypress examples, Docker is required and needs to be running via Docker Desktop or otherwise, and NodeJS 12.x is required.

