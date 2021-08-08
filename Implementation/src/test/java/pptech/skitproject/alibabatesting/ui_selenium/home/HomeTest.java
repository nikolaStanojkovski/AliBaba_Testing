package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class HomeTest {

    private WebDriver driver;

    /*
        Test 1: Navigation existence
        Test 2: Search bar existence

        Test 3_1: Account widget icons without logged in user existence
        Test 3_2: Account widget icons without logged in user existence

        Test 4: Important navigation items existence
        Test 5: Important category listing
        Test 6: Trending products listing
        Test 7: Customized category product listing
        Test 8: Ready to Ship category product listing
        Test 9: Personalized category listing
        Test 10: Weekly market listing
        Test 11: Request for quotation form existence
        Test 12: Recommendations and personalization products existence
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
    public void shouldOpen() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isLoaded());
    }


    @Order(2)
    @Test
    public void test1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getNavigationExistence());
    }

    @Order(3)
    @Test
    public void test2() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getSearchBarExistence());
    }

    @Order(4)
    @Test
    public void test3_1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getAccountIconsExistence());
    }

//    @Order(14)
//    @Test
//    public void test3_2() throws InterruptedException {
//        HomePage homePage = new HomePage(driver);
//        homePage.open();
//
//        Assert.assertTrue(homePage.getAccountIconsExistence(true));
//    }

    @Order(5)
    @Test
    public void test4() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getImportantNavigationItems());
    }

    @Order(6)
    @Test
    public void test5() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getImportantCategoryItems());
    }

    @Order(7)
    @Test
    public void test6() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getTrendingProductSections());
    }

    @Order(8)
    @Test
    public void test7() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getCustomizedProductListing());
    }

    @Order(9)
    @Test
    public void test8() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getReadyToShipProductListing());
    }

    @Order(10)
    @Test
    public void test9() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getPersonalizedCategoryListing());
    }

    @Order(11)
    @Test
    public void test10() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getWeeklyMarketListing());
    }

    @Order(12)
    @Test
    public void test11() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getRequestQuotationFormExistence());
    }

    @Order(13)
    @Test
    public void test12() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.getRecommendedProductsListing());
    }
}
