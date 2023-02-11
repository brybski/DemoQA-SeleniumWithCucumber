package Managers;

/*
The only thing which we need to keep in mind is that the manager would expose only two method for now which are getDriver() and closeDriver().
GetDriver method will decide if the driver is already created or needs to be created.
GetDriver method further call the method createDriver(), which will decide that the remote driver is needed or local driver for the execution.
Accordingly, CreateDriver method would make a call let's say to createLocalDriver().
CreateLocalDriver method will further decide which type of driver needs to be created.
 */

import Enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }

}
