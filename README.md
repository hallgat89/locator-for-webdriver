# locator-for-webdriver

A [Playwright](https://github.com/microsoft/playwright)-inspired Locator implementation for WebDriver.

Instead of directly manipulating a ElementHandle(=WebElement), Playwright suggests the use of Locator, which acts as a reference to a certain element on the page.
Locator handles finding and refreshing the ElementHandle if needed, highly reducing the occurence of stale element problems. 

This library is a (quick and dirty) reference implementation of Locator for WebDriver framework.

## Usage

Simply use Locator instead of WebElement:
```java
By button = By.xpath("//div[text()=\"Click me"]//ancestor::button");

// With WebElement
WebElement acceptButton1 = driver.findElement(acceptButtonLocator);
acceptButton1.isDisplayed();
driver.navigate().refresh(); // WebElement becomes stale
acceptButton1.isDisplayed(); // Throws StaleElement

// With Locator:
Locator acceptButton2 = new Locator(driver, acceptButtonLocator);
acceptButton2.isDisplayed(); // WebElement created the first time
driver.navigate().refresh(); // WebElement becomes stale
acceptButton2.isDisplayed(); // Ok, WebElement is re-fetched
```
