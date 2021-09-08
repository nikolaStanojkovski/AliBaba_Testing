package pptech.skitproject.alibabatesting.ui_selenium.help;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class HelpTest {

    private WebDriver driver;

    /*
        Test 1: 'Help' section existence check
        Test 2: 'Help' section links check

        Test 3: 'For Buyers' link check
        Test 4: 'For Buyers' page check
        Test 5: 'For Suppliers' link check
        Test 6: 'For Suppliers' page check
        Test 7: 'Submit a Dispute' check
        Test 8: 'Report IPR Infringement' link check
        Test 9: 'Report IPR Infringement' page check
        Test 10: 'Report Abuse' check
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
    public void test1() {
        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getHelpSection());
    }

    @Order(2)
    @Test(priority = 2)
    public void test2() {
        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getHelpSectionLinks());
    }

    @Order(3)
    @Test(priority = 3)
    public void test3() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getBuyersPageLink());
    }

    @Order(4)
    @Test(priority = 4)
    public void test4() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getBuyersPage());
    }

    @Order(5)
    @Test(priority = 5)
    public void test5() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getSuppliersPageLink());
    }

    @Order(6)
    @Test(priority = 6)
    public void test6() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getSuppliersPage());
    }

    @Order(7)
    @Test(priority = 7)
    public void test7() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getSubmitDispute());
    }

    @Order(8)
    @Test(priority = 8)
    public void test8() throws InterruptedException {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getReportInfringementLink());
    }

    @Order(9)
    @Test(priority = 9)
    public void test9() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getReportInfringement());
    }

    @Order(10)
    @Test(priority = 10)
    public void test10() {
        tearDown();
        setup();

        HelpPages helpPages = new HelpPages(driver);

        Assert.assertTrue(helpPages.getReportAbuse());
    }
}
