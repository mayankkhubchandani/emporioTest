package com.emporio.pages;

public class CheckOutPage extends BasePage {
    private String emailField = "user.emailAddress";
    private String phoneField = "user.phone";
    private String continuePayButton = "btn-secondary";

    public void enterUserEmailAndPhone(String email, String phone){
        logger.debug("Enter user details on Check out page");
        driver.sendKeysById(emailField, email);
        driver.sendKeysById(phoneField, phone);
    }

    public void continueToPaymentButton(){
        logger.debug("Tap on Continue to Payment button");
        driver.tapOnElementByClassName(continuePayButton);
    }
}
