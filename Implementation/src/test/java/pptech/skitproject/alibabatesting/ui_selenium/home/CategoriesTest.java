package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class CategoriesTest {

    private WebDriver driver;

    /*
        Category listing page:
            Test 1: Main categories list existence
            Test 2: Main specific categories listing check
            Test 3: Main specific categories in the page existence
            Test 4: Subcategories listing existence
            Test 5: Navigation to the specific category on the page
            Test 6: Navigation to a specific category page
            Test 7: Navigation to a specific subcategory page

        Specific category page:
            Test 8: Subcategory list existence
            Test 9: Subcategories list check
            Test 10: Image navigation list existence
            Test 11: Image navigation list check
            Test 12: 3D Reality Showroom section check
            Test 13: Product recommendations section check

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
    public void shouldOpenMain() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();
        Assert.assertTrue(categoriesPage.isLoadedMain());
    }

    @Order(2)
    @Test
    public void shouldOpenSpecificCategory() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openSpecificCategory();
        Assert.assertTrue(categoriesPage.isLoadedSpecificCategory());
    }


    // All categories page


    @Order(3)
    @Test
    public void test1() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getCategoriesListing());
    }

    @Order(4)
    @Test
    public void test2() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getAllCategoriesListing());
    }

    @Order(5)
    @Test
    public void test3() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getAllCategoriesInSections());
    }

    @Order(6)
    @Test
    public void test4() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getSubcategoryListing());
    }

    @Order(7)
    @Test
    public void test5() throws InterruptedException {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        Assert.assertTrue(categoriesPage.getToSpecificCategorySection());
    }

    @Order(8)
    @Test
    public void test6() throws InterruptedException {
        Thread.sleep(4000);
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        categoriesPage.navigateToSpecificCategoryPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.alibaba.com/Toys-Hobbies_p26"));
    }

    @Order(9)
    @Test
    public void test7() throws InterruptedException {
        Thread.sleep(4000);
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.openMain();

        categoriesPage.navigateToSpecificSubcategoryPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.alibaba.com/catalog/classic-toys"));
    }


    // Specific category page


    @Order(10)
    @Test
    public void test8() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getSubcategoryListing());
    }

    @Order(11)
    @Test
    public void test9() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getSubcategories());
    }

    @Order(12)
    @Test
    public void test10() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getImageNavigationListing());
    }

    @Order(13)
    @Test
    public void test11() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getImageNavigationItems());
    }

    @Order(14)
    @Test
    public void test12() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.get3DRealityShowroom());
    }

    @Order(15)
    @Test
    public void test13() throws InterruptedException {
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);
        subcategoryPage.open();

        Assert.assertTrue(subcategoryPage.getRecommendationsList());
    }
}
