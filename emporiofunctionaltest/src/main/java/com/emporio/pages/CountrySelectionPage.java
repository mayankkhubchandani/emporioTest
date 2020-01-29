package com.emporio.pages;

public class CountrySelectionPage extends BasePage {
    private String usCountryClassName = "us-link";
    private String countrySelectionContainer = "country-selection";

    public CountrySelectionPage() {}

    public void selectUSCountry(){
        logger.debug("Selecting US country to proceed");
        driver.tapOnElementByClassName(usCountryClassName);
    }

    public Boolean isCountrySelectionPageDisplayed(){
        logger.debug("Checking Country Selection Page");
        return driver.isElementDisplayedByClassName(countrySelectionContainer);
    }
}
