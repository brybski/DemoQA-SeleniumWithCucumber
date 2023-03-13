package Utilities;

import Managers.DriverManager;
import Managers.PageObjectManager;

/*
TestContext is the parent class and the medium to share the information between the different steps in a test.
Including PageObjectManager and DriverManager object to share between the steps.
For that purposes PicoContainer is used - Dependency Injection Container.
PicoContainer really only has a single feature - it instantiates objects.
Cucumber scans your classes with step definitions in them, passes them to PicoContainer,
then asks it to create new instances for every scenario.
 */
public class TestContext {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() { return scenarioContext; }
}
