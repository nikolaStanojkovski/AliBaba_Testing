package pptech.skitproject.alibabatesting.ui_selenium.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/electrical-equipment-supplies/connectors-terminals/p5_p14190406?spm=a27aq.industry_category_productlist.scGlobalHomeHeader.532.325048dafeaFeq");
        // using the "Connectors Terminals" Products list, for purposes of testing the products list
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pageContent"))).isDisplayed();
    }

    public boolean getProductsType() {
        try {
            WebElement title = driver.findElement(By.xpath("//*[@id='page-path']/div/h1"));

            return title.isDisplayed() && title.getText().equals("Connectors & Terminals");
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductsList() {
        try {
            WebElement productsListSection = driver.findElement(By.id("right-content"));
            List<WebElement> productsList = driver.findElements(By.className("flexColFloor"));

            return productsListSection != null && productsListSection.isDisplayed()
                    && productsList != null && productsList.size() != 0;
            // the products are displayed if the section with the products is displayed and the number of cart items is above 0
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductImage() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement image = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[1]"));

            return product != null && product.isDisplayed() &&
                    image != null && image.isDisplayed();
            // return true if the product is displayed and the particular image in it is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductTitle() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[1]/span"));

            return product != null && product.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("10cm rf jumper assembly n plug to sma plug for semi-rigid rg141 jumper cables");
            // return true if the product is displayed and the particular title for the product is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductPrice() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement price = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[2]/span"));
            String[] parts = price.getText().split(" - ");
            String minPrice = parts[0];
            String maxPrice = parts[1];

            return product != null && product.isDisplayed() && price.isDisplayed()
                    && minPrice.equals("$0.80") && maxPrice.equals("$1.00");
            // return true if the product is displayed and the particular minimal and maximum price for the product is displayed (therefore the full price range is displayed)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductMOQ() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement moq = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a/div/div[2]/div[3]/div[1]/span"));

            return product != null && product.isDisplayed() &&
                    moq != null && moq.isDisplayed() && moq.getText().equals("10.0 Pieces");
            // return true if the product is displayed and the particular MOQ quantity for the product is displayed
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getProductLink() {
        try {
            // For the purpose of testing, first item of the product list is taken and checked
            WebElement product = driver.findElement(By.xpath("//*[@id='mod_2_10454002']"));
            WebElement productLink = driver.findElement(By.xpath("//*[@id=\"mod_2_10454002\"]/div/a"));

            return product != null && product.isDisplayed() &&
                    productLink != null && productLink.isDisplayed() && productLink.getTagName().equals("a");
            // return true if the product is displayed and the particular link for it is displayed (the tag is 'a' for links)
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAboutSuppliersSection() {
        try {
            WebElement section = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[1]"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[1]/div[1]"));

            return section != null && section.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("About product and suppliers:");
            // return true if the section is displayed and the particular title for it is displayed and correct
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRelatedProductsSection() {
        try {
            WebElement section = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[2]"));
            WebElement title = driver.findElement(By.xpath("//*[@id=\"__seobox\"]/div[2]/div[1]"));

            return section != null && section.isDisplayed() &&
                    title != null && title.isDisplayed() && title.getText().equals("Related Searches:");
            // return true if the section is displayed and the particular title for it is displayed and correct
        } catch (Exception ignored) {
            return false;
        }
    }
}
