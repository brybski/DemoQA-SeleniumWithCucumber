package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement title;

    public String getPageTitle() {
        return title.getText();
    }
}
