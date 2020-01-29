package com.emporio.pages;

import com.emporio.driver.ChromeBrowserDriver;
import com.emporio.driver.CommonBrowserDriver;
import org.apache.log4j.Logger;

public class BasePage {
    protected static CommonBrowserDriver driver = new ChromeBrowserDriver();
    protected static Logger logger = Logger.getLogger(HomePage.class);

    public BasePage() {
    }

    public void openUrl(String url) {
        logger.debug("Opening Url: "+ url);
        driver.get(url);
    }

    public CommonBrowserDriver getWebDriver(){
        return driver;
    }
}
