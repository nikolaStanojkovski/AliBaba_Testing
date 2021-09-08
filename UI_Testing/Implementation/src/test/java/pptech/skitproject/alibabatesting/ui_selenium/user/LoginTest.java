package pptech.skitproject.alibabatesting.ui_selenium.user;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

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

    @Order(1)
    @Test(priority = 1)
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoaded());
    }



//    FOR TASKO - TRY SOME ANTI SCRAPING TEHNIQUES, ZA SEKOJ SLUCHAJ OSTAVIV NESHTO PODOLE SHTO FUNKCIONIRA

//    @Order(2)
//    @Test(priority = 2)
//    public void test1() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.open();
//        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "projectskital1b@b@");
//        // there is an already registered user with these credentials
//        Thread.sleep(2500);
//
//        loginPage.checkSlideBar();
//        Thread.sleep(5000);
//        // wait for redirected page to load
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/");
//    }


    @Order(2)
    @Test(priority = 2)
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "projectskital1b@b@");
        // there is an already registered user with these credentials
        Thread.sleep(5000);

        Assert.assertTrue(loginPage.getSliderBar());
        // if the slider bar is shown, that means the credentials are correct and after verification login will be made
    }

    @Order(3)
    @Test(priority = 3)
    public void test2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.signIn("", "");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.alibaba.com/");
        // if the user is not redirected, the login was not successful
    }

    @Order(4)
    @Test(priority = 4)
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.alibaba.com/");
        // if the user is not redirected, the login was not successful
    }

    @Order(5)
    @Test(priority = 5)
    public void test4() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.signIn("nikola.stanojkovski.finki@gmail.com", "invalidpassword");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.alibaba.com/");
        // if the user is not redirected, the login was not successful
    }
}
