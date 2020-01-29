package com.emporio.pages;

public class Page {
    BasePage basePage;
    HomePage homePage;
    CountrySelectionPage countrySelectionPage;
    SearchResultsPage searchResultsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    SignInPage signInPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;

    public Page() {
        this.basePage = new BasePage();
        this.homePage = new HomePage();
        this.countrySelectionPage = new CountrySelectionPage();
        this.searchResultsPage = new SearchResultsPage();
        this.productDetailPage = new ProductDetailPage();
        this.cartPage = new CartPage();
        this.signInPage = new SignInPage();
        this.checkOutPage = new CheckOutPage();
        this.paymentPage = new PaymentPage();
    }

    public HomePage getHomePage(){
        return homePage;
    }

    public CountrySelectionPage getCountrySelectionPage() {
        return countrySelectionPage;
    }

    public BasePage getBasePage() {
        return basePage;
    }

    public SearchResultsPage getSearchResultsPage() {
        return searchResultsPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public CheckOutPage getCheckOutPage() {
        return checkOutPage;
    }

    public PaymentPage getPaymentPage() {
        return paymentPage;
    }
}
