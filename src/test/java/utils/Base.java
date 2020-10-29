package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties properties;

    public Base(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\DownloadProjects\\CarGiantTest\\src\\test\\properties\\config.properties");
        properties.load(fileInputStream);
        String browserName  = properties.getProperty("browser");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\DownloadProjects\\CarGiantTest\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equals("firefox")){
            System.setProperty("webdriver.firefox.driver", "C:\\DownloadProjects\\CarGiantTest\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver", "C:\\DownloadProjects\\CarGiantTest\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    }
    public static String getUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/properties/config.properties");
        prop.load(fis);
        return prop.getProperty("url");
    }
    public static String getUserName() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/properties/config.properties");
        prop.load(fis);
        return prop.getProperty("userName");
    }
    public static String getPassword() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/properties/config.properties");
        prop.load(fis);
        return prop.getProperty("passWord");
    }
}
