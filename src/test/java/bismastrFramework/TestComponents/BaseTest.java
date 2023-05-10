package bismastrFramework.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;

    public WebDriver initDriver() {

//        Properties prop = new Properties();
//        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
//        prop.load(file);
//        String browserName = prop.getProperty("browser");
        String browserName = "chrome";

        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File drc = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, drc);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

   @BeforeMethod(alwaysRun = true)
    public void bf() {
        setDriver();
        loginPage = new LoginPage(getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void af(){
        driver.close();
    }
}
