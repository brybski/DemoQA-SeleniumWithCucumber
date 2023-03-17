package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void tearDown(Scenario scenario) {
        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        testContext.getDriverManager().closeDriver();
    }
}
