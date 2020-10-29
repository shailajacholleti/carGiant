package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.log4testng.Logger;
import utils.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    protected static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void openBrowser() throws IOException {
        driver = Base.initializeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void embeddedScreenShot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                logger.info(e.getMessage());
            }

        }
        driver.quit();
        driver = null;
    }
}
