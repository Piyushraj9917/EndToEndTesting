package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LandingPage extends AbstractComponent {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement Email;
    @FindBy(id = "userPassword")
    WebElement pwd;
    @FindBy(id = "login")
    WebElement LoginID;
    @FindBy(css = "[class*='flyInOut']")
    WebElement LoginErrorValidate;
    @FindBy(css = "input[id='firstName']") WebElement FirstName;
    @FindBy(css ="input[id='lastName']") WebElement LastName;
    @FindBy(css = "input[id='userEmail']") WebElement EmailName;
    @FindBy(css = "input[id='id=userMobile']") WebElement MobileNumber;
    @FindBy(css = "input[id='id=userPassword']") WebElement UserPwd;
    @FindBy(css = "input[id='id=confirmPassword']") WebElement ConfirmuserPwd;
    @FindBy(css = "input[class = 'ng-untouched ng-pristine ng-invalid']") WebElement AdultCheckBox;

    public void LaunchWebsite() {
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public ProductCatalogue LoginAtApplication(String EmailValue, String pwdValue) {
        Email.sendKeys(EmailValue);
        pwd.sendKeys(pwdValue);
        LoginID.click();
        ProductCatalogue Productcata = new ProductCatalogue(driver);
        return Productcata;
    }

    public String LoginError() {
        WaitForWebElementToAppear(LoginErrorValidate);
       return LoginErrorValidate.getText();
    }
}
