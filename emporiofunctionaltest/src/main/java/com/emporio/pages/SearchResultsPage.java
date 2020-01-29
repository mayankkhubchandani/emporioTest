package com.emporio.pages;

public class SearchResultsPage extends BasePage {

    private String brandFacetId = "brand_facet-";
    private String filterListContainer = "facet-list";
    private String productImageClass = "product-image";

    public void applyBrandFacetFilter(String brandName){
        logger.debug("Applying brand filter with brand name: " + brandName);
        String brandCheckboxId = "document.getElementById('" + brandFacetId + brandName + "').click()";
        driver.executeScript(brandCheckboxId);
    }

    public Boolean isFilterApplied(){
        logger.debug("Checking if filter is applied");
        return driver.isElementDisplayedByClassName(filterListContainer);
    }

    public void selectProductByIndex(int index){
        logger.debug("Selecting product by index: " + index);
        driver.tapOnElementByIndexOfClassName(productImageClass, index);
    }
}
