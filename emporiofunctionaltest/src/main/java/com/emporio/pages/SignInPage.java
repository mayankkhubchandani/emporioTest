package com.emporio.pages;

public class SignInPage extends BasePage {
    private String continueAsGuestButton = "js-cia-guest-button";
    private String userSignIncontainer = "cia-signin-settings-container";

    public Boolean isSignInPageDisplayed() {
        logger.debug("Checking if Sign in page is displayed");
        return driver.isElementDisplayedByClassName(userSignIncontainer);
    }

    public void checkoutAsGuest() {
        logger.debug("Tap on Checkout as Guest button");
        driver.tapOnElementByClassName(continueAsGuestButton);
    }
}
