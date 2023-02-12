package StepDefinitions;

import Managers.DriverManager;
import Managers.FileReaderManager;
import Managers.PageObjectManager;
import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps {

    WebDriver driver;
    HomePage homePage;
    TestContext testContext;

    /*
    WebDriverManager and PageObjectManager are required in every step file. With adding a constructor below and in each step definition class
    with passing TestContext as a parameter solve this problem. TestContext (added with PicoContainer Dependency Injection Containers) allows
    to share state between steps.
     */
    public HomeSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("User navigates to the application")
    public void user_navigates_to() {
        driver = testContext.getDriverManager().getDriver();
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        homePage.clickOnLoginButton();
    }

    @Then("User {string} is successfully logged in")
    public void user_is_successfully_logged_in(String string) {
        String actualUser = homePage.getCurrentUsername();
        Assert.assertEquals(actualUser,string);
    }

    @Then("Quit the session")
    public void quit_the_session() {
        testContext.getDriverManager().closeDriver();
    }

}
