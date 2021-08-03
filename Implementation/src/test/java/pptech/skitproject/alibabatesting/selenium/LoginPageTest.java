package pptech.skitproject.alibabatesting.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;

    /*
        Test 1, 2, 3...:
     */

    @BeforeTest
    public void setup(){
        driver = getDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        return new ChromeDriver();
    }
}
