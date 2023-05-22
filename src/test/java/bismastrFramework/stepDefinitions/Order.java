package bismastrFramework.stepDefinitions;

import bismastrFramework.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ConfirmationPage;
import pages.ProductCataloguePage;

import java.io.IOException;
import java.util.List;

public class Order extends BaseTest {

    ProductCataloguePage productCataloguePage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    @Given("I landed on Ecommerce page")
    public void iLandedOnEcommercePage() throws IOException {
        bf();
        loginPage.goTo();
    }
    @When("^User add product (.*) to cart$")
    public void userAddProductProductNameToCart(String productName) {
        productCataloguePage.addProductToCart(productName);
        cartPage = productCataloguePage.goToCartPage();
    }

    @And("^User checkout (.*) and submit order$")
    public void userCheckoutProductNameAndSubmitOrder(String productName) {
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckOutPage checkOutPage = cartPage.goToCheckout();
        checkOutPage.selectCountry("india");
        checkOutPage.submitOrder();

    }

    @Then("^User redirected to thankyou page$")
    public void userRedirectedToThankyouPage() {


    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void loggedInWithUsernameAndPassword(String username, String password) {
        productCataloguePage = loginPage.loginWeb(username, password);
    }
}
