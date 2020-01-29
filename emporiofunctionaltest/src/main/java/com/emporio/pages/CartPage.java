package com.emporio.pages;


public class CartPage extends BasePage {
    private String checkoutButton = "btn-primary";
    private String deliveryRadioButton = "availability-radio-1";

    public void tapOnCheckout() {
        logger.debug("Select on Checkout button");
        driver.tapOnElementByClassName(checkoutButton);
    }
}
