package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //Selectors
    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement username;

    //Constructor
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getCurrentUsername() {
        return this.username.getText();
    }


}
