package bismastrFramework.tests;

import bismastrFramework.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class SubmitOrder extends BaseTest {

    @Test
    public void submitOrder(){
        String productName = "ZARA COAT 3";
        loginPage.goTo();
        ProductCataloguePage productCataloguePage = loginPage.loginWeb("anshika@gmail.com", "Iamking@000");
        List<WebElement> products = productCataloguePage.getProductList();
        productCataloguePage.addProductToCart(productName);
        CartPage cartPage = productCataloguePage.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckOutPage checkOutPage = cartPage.goToCheckout();
        checkOutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkOutPage.submitOrder();
    }


}
