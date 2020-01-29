package com.emporio.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChromeBrowserDriver implements CommonBrowserDriver{
    private WebDriver driver;
    private WebDriverWait wait;

    public ChromeBrowserDriver() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 20);
    }

    public void tapOnElementByClassName(String className) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className))).click();
    }

    public void tapOnElementByIndexOfClassName(String className, int index) {
        List<WebElement> elements = getElementsByClassName(className);
        elements.get(index).click();
    }

    public void sendKeysById(String id, String keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(keys);
    }

    public WebElement waitForElementByClassName(String className) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public Object executeScript(String command) {
        return ((JavascriptExecutor) driver).executeScript(command);
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public boolean isElementDisplayedByClassName(String className) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className))).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void sendKeyboardKeys(Keys keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(keys).build().perform();
    }

    public List<WebElement> getElementsByClassNameFromJavaScript(String className){
        String command = String.format("return document.getElementsByClassName('%s')", className);
        List<WebElement> elements = (List)executeScript(command);
        return elements;
    }

    public List<WebElement> getElementsByClassName(String className){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(className)));
        return elements;
    }
}
