package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSection extends AbstractComponent {
    public WebDriver driver;

    public CheckoutSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btnn.action__submit.ng-star-inserted") WebElement checkoutclick;
    @FindBy(css = ".hero-primary") WebElement Thankyou;

    public void Checkout()
    {
        checkoutclick.click();
        WaitforThankyou(Thankyou);
    }

}