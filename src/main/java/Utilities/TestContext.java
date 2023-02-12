package Utilities;

import Managers.DriverManager;
import Managers.PageObjectManager;

/*
TestContext is the parent class and the medium to share the information between the different steps in a test.
Including PageObjectManager and DriverManager object to share between the steps.
 */
public class TestContext {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
