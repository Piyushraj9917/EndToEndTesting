package Piyush.TestComponents;

import PiyushRaj.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
     public WebDriver driver;
    public LandingPage lp;
    public WebDriver InitializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
        prop.load(fis);
        String browse = prop.getProperty("browser");

        if(browse.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browse.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browse.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
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
