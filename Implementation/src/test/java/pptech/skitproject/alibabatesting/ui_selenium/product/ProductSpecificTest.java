package pptech.skitproject.alibabatesting.ui_selenium.product;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class ProductSpecificTest {

    private WebDriver driver;

    /*
        Test 1: Product appearance check

        Test 2: Product image check
        Test 3: Product image list check
        Test 4: Product title check
        Test 5: Product tags check
        Test 6: Product overall review check
        Test 7: Product quantity sold check
        Test 8: Product price check
        Test 9: Product minimum order quantity (MOQ) check
        Test 10: Product quantity check

        Test 11: Product description check
        Test 12: Product company profile check
        Test 13: Product buyer reviews check

        Test 14: Product feedback form existence
        Test 15: Product feedback form elements check
        Test 16: Product feedback form functionality

        Test 17: Total product price check
        Test 18: Shipping price check
        Test 19: Shipping information check
        Test 20: Total price check

        Test 21: 'Order' button check
        Test 22: 'Contact' button check
        Test 23: 'Call Us' button check
        Test 24: 'Add to cart' button check
        Test 25: 'Favourite' button check

        Test 26: Recommendations section check
        Test 27: Recommendations section items check

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
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();
        Assert.assertTrue(productSpecificPage.isLoaded());
    }


    @Order(2)
    @Test(priority = 2)
    public void test1() throws InterruptedException {
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductAppearance());
    }

    @Order(3)
    @Test(priority = 3)
    public void test2() throws InterruptedException {
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductImage());
    }

    @Order(4)
    @Test(priority = 4)
    public void test3() throws InterruptedException {
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductImageList());
    }

    @Order(5)
    @Test(priority = 5)
    public void test4() throws InterruptedException {
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductTitle());
    }

    @Order(6)
    @Test(priority = 6)
    public void test5() throws InterruptedException {
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductTags());
    }

    @Order(7)
    @Test(priority = 7)
    public void test6() throws InterruptedException {
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductOverallReview());
    }

    @Order(8)
    @Test(priority = 8)
    public void test7() throws InterruptedException {
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductQuantitySold());
    }

    @Order(9)
    @Test(priority = 9)
    public void test8() throws InterruptedException {
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductPrice());
    }

    @Order(10)
    @Test(priority = 10)
    public void test9() throws InterruptedException {
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductMOQ());
    }

    @Order(11)
    @Test(priority = 11)
    public void test10() throws InterruptedException {
        Thread.sleep(2000);
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductQuantity());
    }

    @Order(12)
    @Test(priority = 12)
    public void test11() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductDescription());
    }

    @Order(13)
    @Test(priority = 13)
    public void test12() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getCompanyProfile());
    }

    @Order(14)
    @Test(priority = 14)
    public void test13() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getProductReviews());
    }

    @Order(15)
    @Test(priority = 15)
    public void test14() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getFeedbackForm());
    }

    @Order(16)
    @Test(priority = 16)
    public void test15() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);
        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getFeedbackFormElements());
    }

    @Order(17)
    @Test(priority = 17)
    public void test16() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getFeedbackFormFunctionality());
    }


    @Order(18)
    @Test(priority = 18)
    public void test17() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getTotalProductPrice());
    }

    @Order(19)
    @Test(priority = 19)
    public void test18() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getShippingPrice());
    }

    @Order(20)
    @Test(priority = 20)
    public void test19() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getShippingInformation());
    }

    @Order(21)
    @Test(priority = 21)
    public void test20() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getTotalPrice());
    }


    @Order(22)
    @Test(priority = 22)
    public void test21() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getOrderButton());
    }

    @Order(23)
    @Test(priority = 23)
    public void test22() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getContactButton());
    }

    @Order(24)
    @Test(priority = 24)
    public void test23() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getCallUsButton());
    }

    @Order(25)
    @Test(priority = 25)
    public void test24() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getAddToCartButton());
    }

    @Order(26)
    @Test(priority = 26)
    public void test25() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getFavouriteButton());
    }


    @Order(27)
    @Test(priority = 27)
    public void test26() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getRecommendationsSection());
    }

    @Order(28)
    @Test(priority = 28)
    public void test27() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductSpecificPage productSpecificPage = new ProductSpecificPage(driver);
        productSpecificPage.open();

        productSpecificPage.checkError();

        Assert.assertTrue(productSpecificPage.getRecommendationsItems());
    }
}
