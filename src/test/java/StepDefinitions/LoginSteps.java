package StepDefinitions;

import Enums.Context;
import PageObjects.LoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    TestContext testContext;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("User is redirected to {string} page")
    public void user_is_redirected_to_login_page(String string) {
        loginPage = testContext.getPageObjectManager().getLoginPage();
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle,string);
    }

    @When("User inputs {string} as a login and {string} as a password and clicks login button")
    public void user_uses_as_a_login_and_as_a_password(String string, String string2) throws InterruptedException {
        testContext.scenarioContext.setContext(Context.LOGIN, string);
        loginPage.fillInLoginForm(string, string2);
        driver = testContext.getDriverManager().getDriver();
        loginPage.clicksLoginButton(driver);
    }

}
