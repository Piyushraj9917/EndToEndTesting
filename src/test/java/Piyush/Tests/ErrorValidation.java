package Piyush.Tests;

import Piyush.TestComponents.BaseTest;
import PiyushRaj.pageobjects.CheckoutSection;
import PiyushRaj.pageobjects.MyCart;
import PiyushRaj.pageobjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {
    @Test
    public void SubmitOrder() throws IOException {
        String Productname= "ADIDAS ORIGINAL";
        String IntialAlphabets = "ind";
        ProductCatalogue Productcata =lp.LoginAtApplication("Piyush@yopmail.com","Piyush798@");
        List<WebElement> productList = Productcata.GetProductList();
        Productcata.GetProductByName(Productname);
        MyCart mc = Productcata.AddProductToCart(Productname);
        mc.ThatsMyCart();
        mc.CartSection(Productname);
        CheckoutSection checkout = mc.Selectcountry(IntialAlphabets);
        checkout.Checkout();
    }
}
