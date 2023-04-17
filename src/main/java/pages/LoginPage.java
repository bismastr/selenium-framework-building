package pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement inptEmail;

    @FindBy(id="userPassword")
    WebElement inptPassword;

    @FindBy(id="login")
    WebElement btnLogin;

    public ProductCataloguePage loginWeb(String email, String password){
        inptEmail.sendKeys(email);
        inptEmail .sendKeys(password);
        btnLogin.click();
        return new ProductCataloguePage(driver);
    }

    public void goTo(){
        driver.get("htpps://rahulshettyacademy.com/client");
    }
}
