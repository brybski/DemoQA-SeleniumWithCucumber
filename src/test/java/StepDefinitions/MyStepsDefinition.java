package StepDefinitions;

import Managers.FileReaderManager;
import Managers.PageObjectManager;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import PageObjects.HomePage;

import java.time.Duration;

public class MyStepsDefinition {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    PageObjectManager pageObjectManager;

    @Given("User navigates to the application")
    public void user_navigates_to() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigFileReader().getTime()));

        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();

        driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        homePage.clickOnLoginButton();
    }
    @Then("User is redirected to {string} page")
    public void user_is_redirected_to_login_page(String string) {
        loginPage = pageObjectManager.getLoginPage();
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle,string);
    }

    @When("User inputs {string} as a login and {string} as a password and clicks login button")
    public void user_uses_as_a_login_and_as_a_password(String string, String string2) throws InterruptedException {
        loginPage.fillInLoginForm(string, string2);
        loginPage.clicksLoginButton(driver);
    }
    @Then("User {string} is successfully logged in")
    public void user_is_successfully_logged_in(String string) {
        String actualUser = homePage.getCurrentUsername();
        Assert.assertEquals(actualUser,string);
    }
    @Then("Quit the session")
    public void quit_the_session() {
        driver.quit();
    }
}
