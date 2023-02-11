package Managers;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    /*
    Why we need this class:
    We notice that we were creating objects of the different pages using the below statement in Cucumber Step Definition files:
    HomePage homePage = new HomePage(driver);
    ProductListingPage productListingPage = new ProductListingPage(driver);

    But what is the problem here. So far we have just one single Cucumber Step Definition file. But in the case of multiple-step definition files, we will be creating an object of Pages again and again. Which is against the coding principle.

    To avoid this situation, we can create a Page Object Manager. The duty of the Page Object Manager is to create the page's object and also to make sure that the same object should not be created again and again. But to use a single object for all the step definition files.
     */

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

}
