package PiyushRaj.pageobjects;

import PiyushRaj.AbstractComponents.AbstractComponent;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    public WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".mb-3") List<WebElement> productlist;
    By ProductwithBY = (By.cssSelector(".mb-3"));
    By Element = (By.cssSelector("button[class='btn w-10 rounded']"));
    By ToastMessage = (By.id("toast-container"));
    By ToastInvisible = (By.id(".ng-animating"));


    public List<WebElement> GetProductList() {
        WaitForElementToBeAppear(ProductwithBY);
        return productlist;
    }
    public WebElement GetProductByName(String Productname) {
        WebElement DesiredProd = productlist.stream().filter(PRODUCT -> PRODUCT.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
        return DesiredProd;
    }
    public MyCart AddProductToCart(String Productname) {
        WebElement DesiredProd = GetProductByName(Productname).findElement(Element);
        DesiredProd.click();
        WaitForElementToBeAppear(ToastMessage);
        WaitForElementToBeInvisible(ToastInvisible);
        MyCart mc = new MyCart(driver);
        return mc;
    }
}