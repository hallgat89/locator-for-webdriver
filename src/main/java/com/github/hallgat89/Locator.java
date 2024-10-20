package com.github.hallgat89;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Locator implementation for ${@link org.openqa.selenium.WebElement} to avoid {@link org.openqa.selenium.StaleElementReferenceException}.
 */
public class Locator implements WebElement {

    WebDriver driver;
    By by;
    WebElement element = null;

    public Locator(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    private WebElement getElement() {
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
        this.getElement().click();
    }

    @Override
    public void submit() {
        this.getElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this.getElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        this.getElement().clear();
    }

    @Override
    public String getTagName() {
        return this.getElement().getTagName();
    }

    @Override
    public @Nullable String getDomProperty(String name) {
        return this.getElement().getDomProperty(name);
    }

    @Override
    public @Nullable String getDomAttribute(String name) {
        return this.getElement().getDomAttribute(name);
    }

    @Override
    public @Nullable String getAttribute(String name) {
        return this.getElement().getAttribute(name);
    }

    @Override
    public @Nullable String getAriaRole() {
        return this.getElement().getAriaRole();
    }

    @Override
    public @Nullable String getAccessibleName() {
        return this.getElement().getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return this.getElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.getElement().isEnabled();
    }

    @Override
    public String getText() {
        return this.getElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.getElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.getElement().findElement(by);
    }

    @Override
    public SearchContext getShadowRoot() {
        return this.getElement().getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        return this.getElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.getElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.getElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.getElement().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return this.getElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.getElement().getScreenshotAs(target);
    }
}
