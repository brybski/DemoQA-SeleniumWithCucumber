package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp() {

        driver = testContext.getDriverManager().getDriver();
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @After
    public void tearDown() {
        testContext.getDriverManager().closeDriver();
    }
}
