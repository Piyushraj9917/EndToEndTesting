package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends AbstractComponent {
    public WebDriver driver;

    public OrdersPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "tr td:nth-child(3)") List<WebElement> ProductAtOrders;

    public Boolean MoveToOrders(String ProductName)
    {
       // WaitforOrderbuttonToAppear(OrderHeader);
        MyOrders();
        Boolean  OrderProduct = ProductAtOrders.stream().anyMatch(Product
                ->Product.getText().equalsIgnoreCase(ProductName));
        return OrderProduct;
    }


}
