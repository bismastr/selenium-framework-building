package bismastrFramework.tests;

import bismastrFramework.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashMap;
import java.util.List;

public class SubmitOrder extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData",groups = "Purchase")
    public void submitOrder(HashMap<String, String> input){
        loginPage.goTo();
        ProductCataloguePage productCataloguePage = loginPage.loginWeb(input.get("email"), input.get("password"));
        List<WebElement> products = productCataloguePage.getProductList();
        productCataloguePage.addProductToCart(input.get("product"));
        CartPage cartPage = productCataloguePage.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckOutPage checkOutPage = cartPage.goToCheckout();
        checkOutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkOutPage.submitOrder();
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void  verifyOrder(){
        loginPage.goTo();
        ProductCataloguePage productCataloguePage = loginPage.loginWeb("anshika@gmail.com", "Iamking@000");
        OrderPage orderPage = productCataloguePage.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData(){
        HashMap<String, String> map = new HashMap<>();
        map.put("email", "anshika@gmail.com");
        map.put("password", "Iamking@000");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "shetty@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("product", "ZARA COAT 3");
        return new Object[][] {{map1}, {map}};
    }


}
