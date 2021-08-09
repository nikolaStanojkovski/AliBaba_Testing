package pptech.skitproject.alibabatesting.ui_selenium.category;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;
import pptech.skitproject.alibabatesting.ui_selenium.category.CategoriesPage;
import pptech.skitproject.alibabatesting.ui_selenium.category.SubcategoryPage;

public class CategoriesTest {

    private WebDriver driver;

    /*
        Test 1: Main categories list existence
        Test 2: Main specific categories listing check
        Test 3: Main specific categories in the page existence
        Test 4: Subcategories listing existence
        Test 5: Navigation to the specific category on the page
        Test 6: Navigation to a specific category page
        Test 7: Navigation to a specific subcategory page

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
    public void shouldOpenMain() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();
        Assert.assertTrue(categoriesPage.isLoadedMain());
    }

    @Order(2)
    @Test(priority = 2)
    public void shouldOpenSpecificCategory() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openSpecificCategory();
        Assert.assertTrue(categoriesPage.isLoadedSpecificCategory());
    }


    @Order(3)
    @Test(priority = 3)
    public void test1() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getCategoriesListing());
    }

    @Order(4)
    @Test(priority = 4)
    public void test2() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getAllCategoriesListing());
    }

    @Order(5)
    @Test(priority = 5)
    public void test3() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getAllCategoriesInSections());
    }

    @Order(6)
    @Test(priority = 6)
    public void test4() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getSubcategoryListing());
    }

    @Order(7)
    @Test(priority = 7)
    public void test5() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getToSpecificCategorySection());
    }

    @Order(8)
    @Test(priority = 8)
    public void test6() throws InterruptedException {
        Thread.sleep(4000);
        tearDown();
        setup();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        categoriesPage.navigateToSpecificCategoryPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.alibaba.com/Toys-Hobbies_p26"));
    }

    @Order(9)
    @Test(priority = 9)
    public void test7() throws InterruptedException {
        Thread.sleep(4000);
        tearDown();
        setup();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        categoriesPage.navigateToSpecificSubcategoryPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.alibaba.com/catalog/classic-toys"));
    }
}
