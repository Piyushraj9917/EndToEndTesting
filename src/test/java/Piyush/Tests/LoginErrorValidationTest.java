package Piyush.Tests;

import Piyush.TestComponents.BaseTest;
import PiyushRaj.pageobjects.CheckoutSection;
import PiyushRaj.pageobjects.MyCart;
import PiyushRaj.pageobjects.ProductCatalogue;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginErrorValidationTest extends BaseTest {
    @Test
    public void Errors() throws IOException {
        lp.LoginAtApplication("Piy@yopmail.com","Piyh798@");
        lp.LoginError();
        Assert.assertEquals(lp.LoginError(),"Incorrect email password.");
    }

   @Test(groups = "ErrorValidation",dataProvider = "GetdataforErrorCheck")
    public static void SubmitOrderErrorValidation(HashMap<String,String> input) throws IOException {
        ProductCatalogue Productcata =lp.LoginAtApplication(input.get("Email"),input.get("Password"));
        List<WebElement> productList = Productcata.GetProductList();
        Productcata.GetProductByName(input.get("Productname"));
        MyCart mc = Productcata.AddProductToCart(input.get("Productname"));
        mc.ThatsMyCart();
        mc.CartSection(input.get("Productname"));
        CheckoutSection ckout = mc.Selectcountry(input.get("IntialAlphabets"));
        Boolean flag =  ckout.Checkout();
        Assert.assertTrue(flag);
    }

    @DataProvider
    public Object[][] GetdataforErrorCheck() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Email", "Mansi@yopmail.com");
        hm.put("Password", "Piyush798@");
        hm.put("Productname", "QWERTY");
        hm.put("IntialAlphabets", "ind");

        HashMap<String, String> hm1 = new HashMap<String, String>();
        hm1.put("Email", "Piyush@yopmail.com");
        hm1.put("Password", "Piyush798@");
        hm1.put("Productname", "IPHONE 13 PRO");
        hm1.put("IntialAlphabets", "ind");

        HashMap<String, String> hm2 = new HashMap<String, String>();
        hm2.put("Email", "Shubham@yopmail.com");
        hm2.put("Password", "Piyush798@");
        hm2.put("Productname", "ADIDAS ORIGINAL");
        hm2.put("IntialAlphabets", "ind");


        return new Object[][]{{hm}, {hm1}, {hm2}};

    }
}
