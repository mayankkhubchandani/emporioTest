package com.emporio.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String searchProductFieldClass = "search-input";
    private String dealContainer = "email-submission-modal";

    public void searchProductWithKeyword(String input){
        logger.debug("Searching of a product with keyword: " + input);
        WebElement searchElement  = driver.waitForElementByClassName(searchProductFieldClass);
        searchElement.sendKeys(input);
        searchElement.submit();
    }

    public void closeDealPopup() {
        if (isDealPopupDisplayed())
            logger.debug("Dismissing Deal popup if shown");
            driver.sendKeyboardKeys(Keys.ESCAPE);
    }

    public Boolean isDealPopupDisplayed() {
        logger.debug("Checking if Deal popup is shown or not");
        if (driver.isElementDisplayedByClassName(dealContainer)) {
            logger.info("In check deal popup");
            return true;
        }
        else {
            return driver.isElementDisplayedByClassName(dealContainer);
        }
    }
}
