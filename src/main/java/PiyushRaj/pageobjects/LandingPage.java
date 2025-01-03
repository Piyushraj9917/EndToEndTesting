package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void LaunchWebsite() {
        driver.get("https://rahulshettyacademy.com/client");
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
