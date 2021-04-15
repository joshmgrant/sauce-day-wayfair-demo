# Sauce Day Wayfair - Java Examples

These are some examples used to demo how to run web-based tests on Sauce Labs using Java. 

These examples use

- Java 11 (Java 8+ will work for these tests),
- Junit 4, 
- Maven,
- Selenium Webdriver, and
- [Sauce Bindings](https://opensource.saucelabs.com/sauce_bindings/docs/overview.html), a helpful utility for connecting to Sauce Labs with Selenium.

## Running Tests

To run these tests, you can use IntelliJ directly with tests located in `src/test/java` or using Maven:

```$bash
mvn test
```

## More Java Examples

If you'd like to see more examples using Java  such as using Junit vs TestNG, running against mobile environments or other Sauce Features, please see the [Demo Java repository](https://github.com/saucelabs-training/demo-java)