package PiyushRaj.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponent(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);

    }

    public void WaitForElementToBeAppear(By find)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(find));
    }
    public void WaitForElementToBeInvisible(By findInvisible)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findInvisible));
    }
    public void WaitforThankyou(WebElement Thanks)
    {
        wait.until(ExpectedConditions.visibilityOf(Thanks));
        Thanks.click();
    }
    @FindBy(css = "i[class='fa fa-shopping-cart']") WebElement GoToCartClick;
    public void ThatsMyCart()
    {
        GoToCartClick.click();
    }

    public void TearDown()
    {
        driver.quit();
    }

}
