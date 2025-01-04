package Piyush.Tests;
import PiyushRaj.pageobjects.LandingPage;
import PiyushRaj.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        String Productname= "ZARA COAT 3";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        ProductCatalogue cata = new ProductCatalogue(driver);
       WebElement DesiredProd =  products.stream().filter(PRODUCT-> PRODUCT.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        DesiredProd.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();

        Thread.sleep(2000);
       // wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
       // wt.until(ExpectedConditions.invisibilityOfElementLocated(By.id(".ng-animating")));

        driver.findElement(By.cssSelector("i[class='fa fa-shopping-cart']")).click();
        Thread.sleep(3000);

        List<WebElement> Orderlist = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean Flag = Orderlist.stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(Productname));
        Assert.assertTrue(Flag);
        //driver.findElement(By.cssSelector(".cart h3")).click();
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"Ind").build().perform();
        Thread.sleep(1000);
        List<WebElement> we = driver.findElements(By.cssSelector(".ta-item"));
        we.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().ifPresent(WebElement::click);
        Thread.sleep(1000);

        WebElement CheckOutbutton = driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));//checkoutClick
        CheckOutbutton.click();
        Thread.sleep(2000);
        WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Boolean flag = Wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".hero-primary")))).isDisplayed();
        System.out.println(flag);
        Thread.sleep(2000);

        driver.quit();
    }
}
