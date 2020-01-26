# Emporio Assignment ReadMe

#### What is the difference between an implicit and explicit wait? What would be the best choice to be used and why?
- Implicit Wait: In this type of wait, the webDriver waits for a fixed amount of time before throwing `NoSuchelementException`.
Implicit wait accepts 2 parameters, viz, timeout as an integer value and the unit of the timeout(for example: seconds, minutes, etc.).
Implicit wait is applied to all the elements of the scripts once declared.
- Explicit Wait: In this type of wait, the webDriver waits for certain condition or the maximum amount of time before throwing `ElementNotVisibleException`
We can use different type of conditions with explicit waits which are defined in class `ExpectedConditions`.
With explicit wait, we have to define condition for every element
- Best choice: Implicit wait is easy to implement but is not ideal for every circumstance.
For ex: dynamic loading of some content which may or may not take more time than what is defined in implicit waits.
Hence, explicit wait is preferred for predictable results

#### How do you handle reactjs wait, ajax wait, JavaScript loads since modern web technologies load pages partially and on demand?
- We can use explicit wait to handle ajax calls since explicit wait can wait until the expected condition on ajax response is satisfied.
- For reactJS, we can use explicit wait's wait.until and have a script condition to be used with that wait.
- For Javascript, we can use wait.until functionality of explicit waits and wait until document.readyState is completed 

#### Consider writing a framework to automate a large project, how would you proceed? What tools and technologies would you choose? How would you organize the folders?
1. First we need to identify required components for the project. This will be based on the requirements and other systems.
For ex: integration with test management will be one component, api client will be another(which can be used for setup, teardown and other verification purposes), test data will be another component as well
2. Tool choice will be depend on factors like: project requirements(like if the application to test is web only or mobile only), team's coding strength, BDD support needed or not, community support for queries and fixes.
Assuming our requirement is for Web automation, we can choose Selenium for automation. Selenium supports multiple language clients so it would be easy for the team to contribute and also Selenium has wide community support.
Assuming team has fair bit on knowledge on Java, I'll choose Java as a technology for the project
3. Folder Structure:
```
emporio-functional-tests
    |config
     ---|staging
     ---|production
     |data
          ---|staging
          ---|production
    |src
     ---|main
        ---|java
            ---|driver
            ---|page
            ---|constant
            ---|backend
            ---|assertion
            ---|wait
            ---|util
     ---|test
        ---|java
            ---|constant
            ---|backend
            ---|wait
            ---|util
            ---|functional
        ---|resources
                |properties
    |screenshots
    
- src/main will hold the core functinal logic & required utilities for the automation suite.
For ex: Page objects, web driver classes and initialisation, assertion clases for pages, backend apis, extra utilities, constants, custom wait and exceptions
- src/test will hold all the testing related classes for the suite like unit tests for utilities & assertions, unit & integration tests for apis and lastly functional UI tests
This folder will have resources folder which will include properties file for logs, maven and test data
- config folder will hold details for an environment based on parameter. Like property file for staging environment will tell tests to use what api hostname while testing.
By this way, tests can be scaled to any new environment at any point of time even for local verification
- data folder will hold data 
- screenshots can have images for different page objects on differrnt browser/mobile platforms. 
    
``` 

#### How do you create a driver and use it as a common entity across pageobjects and helpers without passing it as constructor argument?
This can be done by defining a BasePage class with protected variable `driver` and have all the Page Objects class being inherited from the BasePage class.
This will help us to call setUp function of BasePage class which will initialise the driver and then the same instance can be shared across PageObjects.
This will also help us in defining common functionality across pages in BasePage class instead of duplicating it in individual class, hence reducing maintenance also.


#### How do you handle driver initialization for parallel test run?
Selenium webDriver is attached to a particular port where test client execute the calls and server listens for the calls.
We can have different instances of driver attached to different ports so that multiple driver can be accessed in parallel.
There are multiple ways how these port numbers can be served. For ex: it can be hardcoded or can be read from a separate properties file.
