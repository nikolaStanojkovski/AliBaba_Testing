package pptech.skitproject.alibabatesting.ui_selenium.localization;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;
import pptech.skitproject.alibabatesting.ui_selenium.home.HomePage;
import pptech.skitproject.alibabatesting.ui_selenium.product.ProductSpecificPage;
import pptech.skitproject.alibabatesting.ui_selenium.product.ProductsListPage;
import pptech.skitproject.alibabatesting.ui_selenium.user.LoginPage;
import pptech.skitproject.alibabatesting.ui_selenium.user.RegistrationPage;

public class LanguageTest {

    private WebDriver driver;

    /*
        Test 1: Language change check on Home Page

        Test 2: Language change check on Login Page
        Test 3: Language change check on Registration Page

        Test 4: Language change check on Product Listing Page
        Test 5: Language change check on Specific Product Page
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
    @Test
    public void test1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getRegionalSettings());
    }


    @Order(2)
    @Test
    public void test2() throws InterruptedException {
        tearDown();
        setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        Assert.assertTrue(loginPage.getRegionalSettings());
    }

    @Order(3)
    @Test
    public void test3() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();

        Assert.assertTrue(registrationPage.getRegionalSettings());
    }


    @Order(4)
    @Test
    public void test4() throws InterruptedException {
        tearDown();
        setup();

        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getRegionalSettings());
    }

    @Order(5)
    @Test
    public void test5() throws InterruptedException {
        tearDown();
        setup();

        ProductSpecificPage productsSpecificPage = new ProductSpecificPage(driver);
        productsSpecificPage.open();

        Assert.assertTrue(productsSpecificPage.getRegionalSettings());
    }
}
