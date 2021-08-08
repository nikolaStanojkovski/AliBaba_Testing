package pptech.skitproject.alibabatesting.ui_selenium.localization;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.ui_selenium.Setup;

public class LanguageTest {

    private WebDriver driver;

    /*
        Test 1: Language change check on Home Page
        Test 2: Language change check on Help Page

        Test 3: Language change check on Login Page
        Test 4: Language change check on Registration Page

        Test 5: Language change check on Product Listing Page
        Test 6: Language change check on Specific Product Page
        Test 7: Language change check on Filter Options
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
    public void test1() {

    }

}
