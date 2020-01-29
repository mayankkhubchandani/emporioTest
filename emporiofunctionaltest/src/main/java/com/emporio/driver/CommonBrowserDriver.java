package com.emporio.driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface CommonBrowserDriver {
    void get(String url);

    void quit();

    void tapOnElementByClassName(String className);
    void tapOnElementByIndexOfClassName(String className, int index);

    void sendKeysById(String id, String keys);
    void sendKeyboardKeys(Keys keys);

    WebElement waitForElementByClassName(String className);

    Object executeScript(String command);

    boolean isElementDisplayedByClassName(String className);


    List<WebElement> getElementsByClassNameFromJavaScript(String className);
    List<WebElement> getElementsByClassName(String className);

}
