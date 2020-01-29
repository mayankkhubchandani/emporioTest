package com.emporio.pages;

public class ProductDetailPage extends BasePage {
    private String addToCartButton = "add-to-cart-button";
    private String goToCartButton = "cart-nav-text";
    private String addToCartSuccessText = "success-text";

    public void addProductToCart(){
        logger.debug("Tap on Add to cart on product detail page");
        driver.tapOnElementByClassName(addToCartButton);
    }

    public Boolean isAddToCartSuccessPopupDisplayed(){
        logger.debug("Checking for Add to cart successful popup");
        return driver.isElementDisplayedByClassName(addToCartSuccessText);
    }

    public void goToCart() {
        logger.debug("Navigating to cart page");
        driver.tapOnElementByClassName(goToCartButton);
    }
}
