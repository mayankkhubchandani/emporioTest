package com.emporio.pages;


import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends BasePage {
    private String creditCardFormContainer = "credit-card-form";
    private String creditCardNumField = "optimized-cc-card-number";
    private String firstNameField = "payment.billingAddress.firstName";
    private String lastNameField = "payment.billingAddress.lastName";
    private String addressField = "payment.billingAddress.street";
    private String cityField = "payment.billingAddress.city";
    private String zipCodeField = "payment.billingAddress.zipcode";
    private String placeOrderButton = "btn-primary";
    private String hasErrorClass = "help-block";
    private String creditCardExpirationMonthField = "credit-card-expiration-month";
    private String creditCardExpirationYearField = "credit-card-expiration-year";
    private String creditCardExpirationCVVField = "credit-card-form__cvv-wrap";
    private String scriptForErrorClassInId = "document.getElementById('%s').getElementsByClassName('has-error').length";
    private String scriptForErrorClassInClass = "document.getElementsByClassName('%s')[0].getElementsByClassName('has-error').length";
//            String.format("Why, %s Isn't this something?", input);

    public Boolean isPaymentPageDisplayed() {
        logger.debug("Checking if payment page is displayed");
        return driver.isElementDisplayedByClassName(creditCardFormContainer);
    }

    public void enterCreditCardNum(String creditCardNumber){
        logger.debug("Inputting credit card Num value");
        driver.sendKeysById(creditCardNumField, creditCardNumber);
    }

    public void enterUserName(String firstName, String lastName){
        logger.debug("Inputting user name fields");
        driver.sendKeysById(firstNameField, firstName);
        driver.sendKeysById(lastNameField, lastName);
    }

    public void enterUserAddress(String city, String address, String zipCode){
        logger.debug("Inputting user address fields");
        driver.sendKeysById(addressField, address);
        driver.sendKeysById(cityField, city);
        driver.sendKeysById(zipCodeField, zipCode);
    }

    public void placeOrder(){
        logger.debug("Tap on Place Order button");
        driver.tapOnElementByClassName(placeOrderButton);
    }

    private Boolean getElementsByAttributeAndValidateTextContain(String text){
        driver.waitForElementByClassName(hasErrorClass);
        List<WebElement> elements = driver.getElementsByClassNameFromJavaScript(hasErrorClass);
        for (WebElement element : elements) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public Boolean isCreditCardExpirationMonthErrorDisplayed() {
        logger.debug("Check for valid expiration month error message");
        String expirationMonthError = "Please enter expiration month";
        return getElementsByAttributeAndValidateTextContain(expirationMonthError);
    }

    public Boolean isCreditCardExpirationYearErrorDisplayed(){
        logger.debug("Check for valid expiration year error message");
        String expirationYearError = "Please enter expiration year";
        return getElementsByAttributeAndValidateTextContain(expirationYearError);
    }

    public Boolean isCreditCardExpirationCVVErrorDisplayed(){
        logger.debug("Check for valid expiration security code error message");
        String expirationCVVError = "Please enter a valid security code";
        return getElementsByAttributeAndValidateTextContain(expirationCVVError);
    }
}
