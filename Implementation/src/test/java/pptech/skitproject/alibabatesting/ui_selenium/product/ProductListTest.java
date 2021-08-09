package pptech.skitproject.alibabatesting.ui_selenium.product;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class ProductListTest {

    private WebDriver driver;

    /*
        Test 1: List of products type/category/subcategory title
        Test 2: Products list existence

        Test 3: Product image existence
        Test 4: Product title existence
        Test 5: Product price existence
        Test 6: Product minimum order quantity (MOQ) existence
        Test 7: Product link to detailed information existence

        Test 8: "About products and suppliers" section existence
        Test 9: "Related products" section existence

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
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();
        Assert.assertTrue(productsListPage.isLoaded());
    }


    @Order(2)
    @Test(priority = 2)
    public void test1() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductsType());
    }

    @Order(3)
    @Test(priority = 3)
    public void test2() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductsList());
    }


    @Order(4)
    @Test(priority = 4)
    public void test3() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductImage());
    }

    @Order(5)
    @Test(priority = 5)
    public void test4() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductTitle());
    }

    @Order(6)
    @Test(priority = 6)
    public void test5() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductPrice());
    }

    @Order(7)
    @Test(priority = 7)
    public void test6() throws InterruptedException {
        tearDown();
        setup();
        Thread.sleep(2000);

        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductMOQ());
    }

    @Order(8)
    @Test(priority = 8)
    public void test7() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getProductLink());
    }


    @Order(9)
    @Test(priority = 9)
    public void test8() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getAboutSuppliersSection());
    }

    @Order(10)
    @Test(priority = 10)
    public void test9() throws InterruptedException {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.open();

        Assert.assertTrue(productsListPage.getRelatedProductsSection());
    }
}
