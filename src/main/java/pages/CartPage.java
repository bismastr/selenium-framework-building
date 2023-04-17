package pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitles;

    public Boolean VerifyProductDisplay(String productName){
        Boolean match = productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckOutPage(driver);
    }

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
