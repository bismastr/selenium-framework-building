package bismastrFramework.tests;

import bismastrFramework.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void loginError(){
        loginPage.goTo();
        loginPage.loginWeb("anshika@gmail.com", "sadad");
        Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
    }


}
