package bismastrFramework.tests;

import bismastrFramework.TestComponents.BaseTest;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class ErrorValidations extends BaseTest {

    @Test
    public void loginError(){
        loginPage.goTo();
        loginPage.loginWeb("anshika@gmail.com", "sadad");
        Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
    }
}
