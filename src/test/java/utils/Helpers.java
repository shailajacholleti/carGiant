package utils;

import org.openqa.selenium.WebDriver;

public class Helpers extends Base{
    private static WebDriver driver;
    public Helpers(WebDriver driver)
    {
        super(driver);
    }

    public void waitForSecs(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
