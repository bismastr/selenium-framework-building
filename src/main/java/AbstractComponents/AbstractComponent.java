package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public CartPage goToCartPage(){
        cartHeader.click();
        return new CartPage(driver);
    }

    public void waitElementToAppear(By findBy){
        wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
