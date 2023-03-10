package StepDefinitions;

import Enums.Context;
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

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        homePage.clickOnLoginButton();
    }

    @Then("User is successfully logged in")
    public void user_is_successfully_logged_in() {
        String actualUser = homePage.getCurrentUsername();
        String expectedUser = testContext.scenarioContext.getContext(Context.LOGIN).toString();
        Assert.assertEquals(actualUser,expectedUser);
    }
}
