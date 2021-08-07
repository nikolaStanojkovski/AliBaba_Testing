package pptech.skitproject.alibabatesting.selenium.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.models.TradeRole;
import pptech.skitproject.alibabatesting.selenium.BasePage;
import pptech.skitproject.alibabatesting.selenium.Setup;

public class LoginTest {

    private WebDriver driver;

    /*
        Test 1: Successful login with valid credentials

        Test 2: Unsuccessful login with invalid email address
        Test 3: Unsuccessful login with invalid password
        Test 4: Unsuccessful login with invalid credentials
     */

    @BeforeTest
    public void setup(){
        driver = Setup.getDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoaded());
    }

    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "projectskital1b@b@");
        // there is an already registered user with these credentials

        loginPage.checkSlideBar();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/");
    }

    @Test
    public void test2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.signIn("", "");
        Thread.sleep(2000);

        loginPage.checkSlideBar();
        Thread.sleep(3000);

        LoginPage redirectedPage = new LoginPage(driver);

        Assert.assertEquals(redirectedPage.getErrorMessage(), "Please enter your email address or member ID.");
    }
    @Test
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "");

        loginPage.checkSlideBar();

        Thread.sleep(2000);
        Assert.assertEquals("Please enter your password.", loginPage.getErrorMessage());
    }

    @Test
    public void test4() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "invalidpassword");

        loginPage.checkSlideBar();

        Thread.sleep(2000);
        Assert.assertEquals("Your account name or password is incorrect. Help", loginPage.getErrorMessage());
    }
}
