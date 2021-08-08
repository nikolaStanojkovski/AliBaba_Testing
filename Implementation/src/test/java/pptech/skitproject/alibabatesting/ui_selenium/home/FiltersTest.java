package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;


public class FiltersTest {

    private WebDriver driver;

    /*
        Test 1: Search for a product

        Test 2: Main filters list existence
        Test 3: Main filters items check
        Test 4: Category filter check
        Test 5: Supplier types filter check
        Test 6: Product types filter check
        Test 7: Minimal order quantity filter check
        Test 8: Minimal price filter check
        Test 9: Maximum price filter check
        Test 10: Minimal and maximum price filter check
        Test 11: Supplier country/region filter check
        Test 12: Past export country/region filter check
        Test 13: Management certification filter check
        Test 14: Product certification filter check

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
        FilterOptionsPage filtersPage = new FilterOptionsPage(driver);
        filtersPage.open();
        Assert.assertTrue(filtersPage.isLoaded());
    }


    @Order(2)
    @Test
    public void test1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.searchFor("car parts");
        // used the keyword "car parts" for the purpose of this example

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/trade/search?fsb=y&IndexArea=product_en&CatId=&SearchText=car+parts");
        // check if the website navigated to the particular search page
    }

    @Order(3)
    @Test
    public void test2() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();

        Assert.assertTrue(filterOptionsPage.getMainFiltersListing());
    }

    @Order(4)
    @Test
    public void test3() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();

        Assert.assertTrue(filterOptionsPage.getMainFilters());
    }

    @Order(5)
    @Test
    public void test4() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.categoryFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts/CID120601.html?IndexArea=product_en");
        // See if the redirection was successfully made and products have been filtered out
    }

    @Order(6)
    @Test
    public void test5() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.supplierTypeFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&assessment_company=ASS");
        // See if the redirection was successfully made and products have been filtered out
    }

    @Order(7)
    @Test
    public void test6() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.productTypeFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&productTag=1200000228");
        // See if the redirection was successfully made and products have been filtered out
    }

    @Order(8)
    @Test
    public void test7() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.minOrderQuantityFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/trade/search?IndexArea=product_en&SearchText=car_parts&f0=y&moqf=MOQF&moqt=MOQT3");
        // See if the redirection was successfully made and products have been filtered out, the 'MOQT' attribute is the determining factor here
    }

    @Order(9)
    @Test
    public void test8() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.minPriceFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/trade/search?IndexArea=product_en&SearchText=car_parts&f0=y&pricef=300&pricet=");
        // See if the redirection was successfully made and products have been filtered out, the 'pricef' attribute is the determining factor here
    }

    @Order(10)
    @Test
    public void test9() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.maxPriceFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/trade/search?IndexArea=product_en&SearchText=car_parts&f0=y&pricef=&pricet=300");
        // See if the redirection was successfully made and products have been filtered out, the 'pricet' attribute is the determining factor here
    }

    @Order(11)
    @Test
    public void test10() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.maxMinPriceFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/trade/search?IndexArea=product_en&SearchText=car_parts&f0=y&pricef=10&pricet=300");
        // See if the redirection was successfully made and products have been filtered out, the 'pricet' and 'pricef' attributes are the determining factor here
    }

    @Order(12)
    @Test
    public void test11() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.supplierCountryRegionFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&Country=JP&param_order=CNTRY-JP");
        // See if the redirection was successfully made and products have been filtered out, the 'Country' and 'param_order' attributes are the determining factor here
    }

    @Order(13)
    @Test
    public void test12() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.pastCountryRegionFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&param_order=EC-KR&exportCountry=KR");
        // See if the redirection was successfully made and products have been filtered out, the 'exportCountry' and 'param_order' attributes are the determining factor here
    }

    @Order(14)
    @Test
    public void test13() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.managementCertificationFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&param_order=CAT-ISO&companyAuthTag=ISO");
        // See if the redirection was successfully made and products have been filtered out, the 'param_order' and 'companyAuthTag' attributes are the determining factor here
    }

    @Order(15)
    @Test
    public void test14() throws InterruptedException {
        FilterOptionsPage filterOptionsPage = new FilterOptionsPage(driver);
        filterOptionsPage.open();
        filterOptionsPage.productCertificationFilterCheck();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.alibaba.com/products/car_parts.html?IndexArea=product_en&param_order=PAT-CE&productAuthTag=CE");
        // See if the redirection was successfully made and products have been filtered out, the 'param_order' and 'companyAuthTag' attributes are the determining factor here
    }
}
