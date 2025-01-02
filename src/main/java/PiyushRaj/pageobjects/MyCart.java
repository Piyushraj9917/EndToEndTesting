package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyCart extends AbstractComponent {
    public WebDriver driver;

    public MyCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".cartSection h3") List<WebElement> OrderList;
    @FindBy(css =".totalRow button") WebElement CheckOut;
    @FindBy(css = ".form-group input") WebElement CountrySelect;
    @FindBy(css = ".ta-item") List<WebElement> Countries;



    public void CartSection(String Productname)
    {
        ThatsMyCart();
        Boolean Flag = OrderList.stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(Productname));
        assert(Flag);
        CheckOut.click();
    }
    public CheckoutSection Selectcountry(String CountryInitialAlpabets)
    {
        CountrySelect.sendKeys(CountryInitialAlpabets);
        List<WebElement> we = Countries;
        we.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().ifPresent(WebElement::click);
        CheckoutSection checkout = new CheckoutSection(driver);
        return checkout;
    }

}
