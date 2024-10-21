package com.github.hallgat89;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Locator implementation for ${@link org.openqa.selenium.WebElement} to enable lazy loading and avoid {@link org.openqa.selenium.StaleElementReferenceException}.
 */
public class Locator implements WebElement {

    private final WebDriver driver;
    private final By by;
    private WebElement element = null;

    public Locator(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    /**
     * Returns the encapsulated {@link org.openqa.selenium.WebElement}. Use this method only, when you specifically need {@link org.openqa.selenium.WebElement}.
     *
     * @return {@link org.openqa.selenium.WebElement}
     */
    public WebElement getWebElement() {
        if (this.element == null) {
            this.element = driver.findElement(this.by);
            return this.element;
        } else {
            try {
                element.isEnabled();
                return this.element;
            } catch (StaleElementReferenceException expected) {
                this.element = driver.findElement(this.by);
                return this.element;
            }
        }
    }

    @Override
    public void click() {
        this.getWebElement().click();
    }

    @Override
    public void submit() {
        this.getWebElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this.getWebElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        this.getWebElement().clear();
    }

    @Override
    public String getTagName() {
        return this.getWebElement().getTagName();
    }

    @Override
    public @Nullable String getDomProperty(String name) {
        return this.getWebElement().getDomProperty(name);
    }

    @Override
    public @Nullable String getDomAttribute(String name) {
        return this.getWebElement().getDomAttribute(name);
    }

    @Override
    public @Nullable String getAttribute(String name) {
        return this.getWebElement().getAttribute(name);
    }

    @Override
    public @Nullable String getAriaRole() {
        return this.getWebElement().getAriaRole();
    }

    @Override
    public @Nullable String getAccessibleName() {
        return this.getWebElement().getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return this.getWebElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.getWebElement().isEnabled();
    }

    @Override
    public String getText() {
        return this.getWebElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.getWebElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.getWebElement().findElement(by);
    }

    @Override
    public SearchContext getShadowRoot() {
        return this.getWebElement().getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        return this.getWebElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.getWebElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.getWebElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.getWebElement().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return this.getWebElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.getWebElement().getScreenshotAs(target);
    }
}
