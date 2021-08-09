package pptech.skitproject.alibabatesting.ui_selenium.category;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class SubcategoriesTest {

    private WebDriver driver;

    /*
        Test 1: Subcategory list existence
        Test 2: Subcategories list check
        Test 3: Image navigation list existence
        Test 4: Image navigation list check
        Test 5: 3D Reality Showroom section check
        Test 6: Product recommendations section check

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
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getSubcategoryListing());
    }

    @Order(4)
    @Test(priority = 4)
    public void test2() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getSubcategories());
    }

    @Order(5)
    @Test(priority = 5)
    public void test3() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getImageNavigationListing());
    }

    @Order(6)
    @Test(priority = 6)
    public void test4() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getImageNavigationItems());
    }

    @Order(7)
    @Test(priority = 7)
    public void test5() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.get3DRealityShowroom());
    }

    @Order(8)
    @Test(priority = 8)
    public void test6() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getRecommendationsList());
    }

}
