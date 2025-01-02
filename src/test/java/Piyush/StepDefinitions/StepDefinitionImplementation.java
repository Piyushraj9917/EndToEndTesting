package Piyush.StepDefinitions;

import Piyush.TestComponents.BaseTest;
import PiyushRaj.pageobjects.CheckoutSection;
import PiyushRaj.pageobjects.LandingPage;
import PiyushRaj.pageobjects.MyCart;
import PiyushRaj.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImplementation extends BaseTest {
    List<WebElement> productList;
    public MyCart mc;
    public LandingPage lp;
    public ProductCatalogue Productcata;

    @Given("landed on website")
    public void landed_on_website() throws IOException {
        lp = LaunchApplication();
    }

    @Given("^Logged in the with (.+) and (.+)$")
    public void performlogin(String username, String password) throws IOException {
        Productcata = lp.LoginAtApplication(username, password);
    }

    @When("^add (.+) to the cart$")
    public void addToCart(String productName) {
        List<WebElement> productList = Productcata.GetProductList();
        Productcata.GetProductByName(productName);
        mc = Productcata.AddProductToCart(productName);
        mc.ThatsMyCart();
        mc.CartSection(productName);
    }

    @Then("Checkout and Submit")
    public void checkoutAndSubmit() {
        CheckoutSection checkout = mc.Selectcountry("ind");
        checkout.Checkout();
    }
}
