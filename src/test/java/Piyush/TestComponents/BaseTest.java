package Piyush.TestComponents;

import PiyushRaj.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
     public WebDriver driver;
    public static LandingPage lp;
    public WebDriver InitializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
        prop.load(fis);
        String browse =  System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

        if(browse.contains("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if(browse.contains("headless"))
            {
                options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        }
        else if (browse.contains("Firefox")) {
            System.setProperty("webdriver.gecko.driver","/Users/ahlawat/Downloads/geckodriver");
            driver = new FirefoxDriver();
        } else if (browse.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
    public String TakeScreenShot(String TestCasename, WebDriver driver) throws IOException {

        TakesScreenshot ts =  (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports "+ TestCasename + ".png");
        FileUtils.copyFile(src, file);
        return (System.getProperty("user.dir")+"//reports "+ TestCasename + ".png");
    }


    @BeforeMethod(alwaysRun = true)
    public LandingPage LaunchApplication() throws IOException {
         driver = InitializeDriver();
       lp = new LandingPage(driver);
        lp.LaunchWebsite();
        return lp;
    }
   @AfterMethod(alwaysRun = true)
    public void TearDown()
    {
        driver.close();
    }
}
