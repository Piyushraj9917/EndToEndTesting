package Piyush.Tests;

import Piyush.TestComponents.BaseTest;
import PiyushRaj.pageobjects.CheckoutSection;
import PiyushRaj.pageobjects.MyCart;
import PiyushRaj.pageobjects.OrdersPage;
import PiyushRaj.pageobjects.ProductCatalogue;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test (dataProvider = "getData", groups = {"Submition"})
    public void SubmitOrder(HashMap<String,String> input) throws IOException {
        ProductCatalogue Productcata =lp.LoginAtApplication(input.get("Email"),input.get("Password"));
        List<WebElement> productList = Productcata.GetProductList();
        Productcata.GetProductByName(input.get("Productname"));
        MyCart mc = Productcata.AddProductToCart(input.get("Productname"));
        mc.ThatsMyCart();
        mc.CartSection(input.get("Productname"));
        CheckoutSection checkout = mc.Selectcountry(input.get("IntialAlphabets"));
        checkout.Checkout();
    }

    @Test(dependsOnMethods = {"SubmitOrder"},dataProvider = "getData", groups = {"Submition"})
    public void OrderHistoryVerification(HashMap<String,String> input)
    {
        lp.LoginAtApplication(input.get("Email"),input.get("Password"));
        OrdersPage ordersOBJ  = lp.MyOrders();
        Boolean Match = ordersOBJ.MoveToOrders(input.get("Productname"));
        Assert.assertTrue(Match);
    }

    public File TakeScreenShot(File TestCasename) throws IOException {

       TakesScreenshot ts =  (TakesScreenshot)driver;
       File src = ts.getScreenshotAs(OutputType.FILE);
       File file = new File(System.getProperty("user.dir")+"//reports "+ TestCasename + ".png");
        FileUtils.copyFile(src, file);
        return file;
    }

    @DataProvider
    public Object[][] getData()
    {
        HashMap<String,String > map = new HashMap<String,String >();
        map.put("Email", "Mansi@yopmail.com");
        map.put("Password", "Piyush798@");
        map.put("Productname", "QWERTY");
        map.put("IntialAlphabets","ind");

        HashMap<String,String > map1 = new HashMap<String,String >();
        map1.put("Email", "Piyush@yopmail.com");
        map1.put("Password", "Piyush798@");
        map1.put("Productname", "IPHONE 13 PRO");
        map1.put("IntialAlphabets","ind");

        return new Object[][] {{map}, {map1}};
    }

}
