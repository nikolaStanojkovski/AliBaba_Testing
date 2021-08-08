package pptech.skitproject.alibabatesting.ui_selenium.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/");
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-content"))).isDisplayed();
    }

    public boolean isLogged() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[2]/div[4]/div[4]/div/div/div/div[4]/div"));
        String elementText = element.getText();

        return elementText.equals("you havent login.");
    }

    // Checkers for elements on page

    public boolean getNavigationExistence() { // check if the navigation exists
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]"));
            return element != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSearchBarExistence() {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[2]/div[3]/div/div/form/div[2]/input"));
            return element != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getAccountIconsExistence() {
        try {
            driver.manage().window().maximize();
            // window needs to be full screen in order or load all account icons
            Thread.sleep(1500); // wait until elements are loaded

            String signIn = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/a")).getText();
            String logIn = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/div[1]/div[1]/div[2]/div[2]/a")).getText();
            String messages = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/a")).getText();
            String orders = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[4]/div[3]/div[1]/div[2]/a")).getText();
            String cart = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[2]/div[4]/div[4]/div/div/a/div/div[2]/a")).getText();

            return signIn.equals("Sign In") && logIn.equals("Join Free")
                    && messages.equals("Messages") && orders.equals("Orders")
                    && cart.equals("Cart"); // checking every account widget icon to see if it exists
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getImportantNavigationItems() {
        try {
            String categories = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[1]/div/div/h3/span")).getText();
            String shippingInformation = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[1]/a")).getText();
            String tradeShows = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[2]/a")).getText();
            String personalProtectiveEquipment = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[3]/a")).getText();
            String buyerCentral = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[4]/a")).getText();
            String sellerInformation = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[5]/a")).getText();
            String helpInformation = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[4]/div/div[3]/ul/li[6]/a")).getText();

            return categories.equals("Categories") && shippingInformation.equals("Ready to Ship")
                    && tradeShows.equals("Trade Shows") && personalProtectiveEquipment.equals("Personal Protective Equipment")
                    && buyerCentral.equals("Buyer Central") && sellerInformation.equals("Sell on Alibaba") && helpInformation.equals("Help");
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getImportantCategoryItems() {
        try {
            List<WebElement> importantCategoryItems = driver.findElements(By.className("category-item"));
            int counter = 0;
            for(WebElement element : importantCategoryItems) {
                WebElement innerText = element.findElement(By.className("txt"));
                if(innerText.getText().equals("Consumer Electronics")
                        || innerText.getText().equals("Apparel") || innerText.getText().equals("Vehicles & Accessories")
                        || innerText.getText().equals("Sports & Entertainment") || innerText.getText().equals("Machinery")
                        || innerText.getText().equals("Home & Garden") || innerText.getText().equals("Beauty & Personal Care"))
                    counter++;
            }

            return counter == 7;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getTrendingProductSections() {
        try {
            List<WebElement> elements = driver.findElements(By.className("double-item"));
            return elements.size() == 6; // there should 6 sections of trending categories with products in them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getCustomizedProductListing() {
        try {
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/h3"));
            return element.getText().equals("Customized products"); // check if there is a customized category product listing
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getReadyToShipProductListing() {
        try {
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/h3"));
            return element.getText().equals("Ready-to-ship products"); // check if there is a customized category product listing
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getPersonalizedCategoryListing() {
        try {
            List<WebElement> elements = driver.findElements(By.className("home-category-info-norm"));
            return elements.size() == 3; // there should 3 sections of personalized recommended categories with products in them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getWeeklyMarketListing() {
        try {
            List<WebElement> elements = driver.findElements(By.className("weekly-market"));
            return elements.size() == 2; // there should 2 sections with weekly market information in them
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRequestQuotationFormExistence() {
        try {
            WebElement element = driver.findElement(By.id("rfq-quotation"));
            return element != null; // return true if the form exists
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRecommendedProductsListing() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().window().maximize();
            js.executeScript("window.scrollBy(0,2500)"); // scroll down to the section first, because it is not loaded at first

            Thread.sleep(1000); // wait until element is loaded
            WebElement element = driver.findElement(By.id("recommendation-for-you"));
            if(element != null) {
                List<WebElement> products = element.findElements(By.className("m-r4u-product-item"));
                return products != null && products.size() != 0; // return true if the section exists and there are more than 0 products in them
            } else
                return false;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void searchFor(String text) {
        try {
            driver.manage().window().maximize();
            // window needs to be full screen in order or load all account icons
            Thread.sleep(1500); // wait until elements are loaded

            WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[2]/div[3]/div/div/form/div[2]/input"));
            searchbar.sendKeys(text); // find the search input bar
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"J_SC_header\"]/header/div[2]/div[3]/div/div/form/input[4]"));
            submitButton.submit(); // find the submit button

            Thread.sleep(8000);
            // wait for the requested page to load
        } catch (Exception ignored) {

        }
    }
}
