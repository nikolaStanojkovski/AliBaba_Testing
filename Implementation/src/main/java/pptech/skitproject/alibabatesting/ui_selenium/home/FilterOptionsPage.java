package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class FilterOptionsPage extends BasePage {

    public FilterOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/products/car_parts.html");
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("root")))).isDisplayed();
    }


    public boolean getMainFiltersListing() {
        try {
            WebElement element = driver.findElement(By.className("search-rts__left-filters"));

            return element != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getMainFilters() {
        try {
            List<WebElement> elementList = driver.findElements(By.className("lfs-filter-wrapper__title-content"));
            for(WebElement element : elementList) {
                if(!element.getText().equals("CATEGORIES") &&
                        !element.getText().equals("Supplier Types") &&
                        !element.getText().equals("Product Types") &&
                        !element.getText().equals("Min. Order") &&
                        !element.getText().equals("Price") &&
                        !element.getText().equals("Supplier Country/Region") &&
                        !element.getText().equals("Past Export Country/Region") &&
                        !element.getText().equals("Management Certification") &&
                        !element.getText().equals("Product Certification") )
                    return false;
            }

            return true;
            // Check if every element from the filters menu is there
        } catch (Exception ignored) {
            return false;
        }
    }

    public void categoryFilterCheck() {
        try {
            // For the purpose of testing, one of the links of the "Categories" filter was used: "Car Bumpers"
            WebElement carBumpersLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div/a[1]"));
            carBumpersLink.click();
            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void supplierTypeFilterCheck() {
        try {
            // For the purpose of testing, one of the links of the "Supplier types" filter was used: "Verified Supplier"
            WebElement verifiedSupplierLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[2]/a[2]"));
            verifiedSupplierLink.click();
            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void productTypeFilterCheck() {
        try {
            // For the purpose of testing, one of the links of the "Product types" filter was used: "Ready to Ship" (products)
            WebElement readyToShipLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[3]/div[2]/a[1]"));
            readyToShipLink.click();
            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void minOrderQuantityFilterCheck() {
        try {
            // For the purpose of testing, 3 as a quantity is used here
            WebElement quantityInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[4]/div[2]/span/input"));
            quantityInput.sendKeys("3");
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[4]/div[2]/a/button"));
            submitButton.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void minPriceFilterCheck() {
        try {
            // For the purpose of testing, 300 ($) as a minimum price is used here
            WebElement priceInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/span[1]/input"));
            priceInput.sendKeys("300");
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/a/button"));
            submitButton.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void maxPriceFilterCheck() {
        try {
            // For the purpose of testing, 300 ($) as a maximum price is used here
            WebElement priceInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/span[3]/input"));
            priceInput.sendKeys("300");
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/a/button"));
            submitButton.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void maxMinPriceFilterCheck() {
        try {
            // For the purpose of testing, 10 ($) as minimum price and  300 ($) as a maximum price is used here
            WebElement minPriceInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/span[1]/input"));
            minPriceInput.sendKeys("10"); // min input
            WebElement maxPriceInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/span[3]/input"));
            maxPriceInput.sendKeys("300"); // max input
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/div[2]/a/button"));
            submitButton.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void supplierCountryRegionFilterCheck() {
        try {
            // For the purpose of testing, choosing 'Japan' as a supplier country of the products
            WebElement japanSupplierLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[6]/div[2]/div[2]/div[1]/div/div[4]/a"));
            japanSupplierLink.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void pastCountryRegionFilterCheck() {
        try {
            WebElement extendLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[7]/div"));
            extendLink.click();
            Thread.sleep(2000);
            // wait for the select to extend

            // For the purpose of testing, choosing 'South Korea' as a past export country of the products
            WebElement southKoreaPasCountryLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[7]/div[2]/div[2]/div/div/div[6]/a"));
            southKoreaPasCountryLink.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void managementCertificationFilterCheck() {
        try {
            // For the purpose of testing, choosing 'ISO' as a management certification
            WebElement isoManagementLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[8]/div[2]/div[2]/div[1]/div/div[1]/a"));
            isoManagementLink.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }

    public void productCertificationFilterCheck() {
        try {
            // For the purpose of testing, choosing 'CE' as a product certification
            WebElement CECertificationLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[9]/div[2]/div[2]/div[1]/div/div[1]/a"));
            CECertificationLink.click();

            Thread.sleep(5000);
            // wait until the new page loads
        } catch (Exception ignored) {

        }
    }
}
