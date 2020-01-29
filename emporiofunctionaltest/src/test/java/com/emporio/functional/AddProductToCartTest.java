package com.emporio.functional;

import com.emporio.driver.CommonBrowserDriver;
import com.emporio.pages.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AddProductToCartTest {
    Page page;
    CommonBrowserDriver driver;

    @Before
    public void setUp() {
        page = new Page();
        driver = page.getBasePage().getWebDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddProductToCart() {
        String email = "testuser@gmail.com", phone="8768768765";
        String ccNumber = "4242424242424242";
        String userFirstName = "Test", userLastName = "user";
        String city="Singapore", address="Singaporw", zipCode = "12880";

        page.getBasePage().openUrl("https://www.bestbuy.com/");
        if (page.getCountrySelectionPage().isCountrySelectionPageDisplayed())
            page.getCountrySelectionPage().selectUSCountry();
        page.getHomePage().closeDealPopup();
        page.getHomePage().searchProductWithKeyword("adidas");
        page.getSearchResultsPage().applyBrandFacetFilter("adidas");
        assertTrue("Brand Filter is not applied successfully.", page.getSearchResultsPage().isFilterApplied());
        page.getSearchResultsPage().selectProductByIndex(0);
        page.getProductDetailPage().addProductToCart();
        assertTrue("Add to Cart action on Product Detail Page failed", page.getProductDetailPage().isAddToCartSuccessPopupDisplayed());
        page.getProductDetailPage().goToCart();
        page.getCartPage().tapOnCheckout();
        assertTrue("Sign In Page is not displayed as expected", page.getSignInPage().isSignInPageDisplayed());
        page.getSignInPage().checkoutAsGuest();

        //Extra step to input email and phone number when checking out as Guest
        //This is because if product order is changed these values need to be filled
        if (! page.getPaymentPage().isPaymentPageDisplayed()) {
            page.getCheckOutPage().enterUserEmailAndPhone(email, phone);
            page.getCheckOutPage().continueToPaymentButton();
        }
        assertTrue("Payment Page not displayed successfully", page.getPaymentPage().isPaymentPageDisplayed());
        page.getPaymentPage().enterCreditCardNum(ccNumber);
        page.getPaymentPage().enterUserName(userFirstName, userLastName);
        page.getPaymentPage().enterUserAddress(city, address, zipCode);
        page.getPaymentPage().placeOrder();
        assertTrue("Missing Payment Information Validation Unsuccessful",
                page.getPaymentPage().isCreditCardExpirationMonthErrorDisplayed()
                && page.getPaymentPage().isCreditCardExpirationYearErrorDisplayed()
                && page.getPaymentPage().isCreditCardExpirationCVVErrorDisplayed()
        );
    }
}
