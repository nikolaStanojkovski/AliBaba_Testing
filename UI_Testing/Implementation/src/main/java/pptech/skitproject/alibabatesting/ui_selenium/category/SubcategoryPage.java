package pptech.skitproject.alibabatesting.ui_selenium.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.ui_selenium.BasePage;

import java.util.List;

public class SubcategoryPage extends BasePage {

    public SubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.alibaba.com/Toys-Hobbies_p26");
        // For the purpose of testing, the subcategory 'Toys-Hobbies'
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("pageContent")))).isDisplayed();
    }


    public boolean getSubcategoryListing() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1500); // wait until elements are loaded
        try {
            String title = driver.findElement(By.xpath("//*[@id=\"mod_0_10571008\"]/div/div[1]/div/div[1]")).getText();
            WebElement categoryNavigation = driver.findElement(By.className("industry-category-nav"));

            return title.equals("CATEGORIES") && categoryNavigation != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getSubcategories() {
        try {
            List<WebElement> firstPageNavCategories = driver.findElements(By.className("category-menu-link"));
            for(WebElement element : firstPageNavCategories) {
                if(!element.getText().equals("Action Figure") &&
                        !element.getText().equals("Baby Toys") &&
                        !element.getText().equals("Balloons") &&
                        !element.getText().equals("Blocks") &&
                        !element.getText().equals("Candy Toys") &&
                        !element.getText().equals("Classic Toys") &&
                        !element.getText().equals("Dolls & Accessories") &&
                        !element.getText().equals("Educational Toys") &&
                        !element.getText().equals("Electronic Pets") &&
                        !element.getText().equals("Fishing Toys") &&
                        !element.getText().equals("Glass Marbles") )
                    return false;
            } // check if all required categories are listed on the page

            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getImageNavigationListing() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1500); // wait until elements are loaded
        try {
            WebElement categoryNavigation = driver.findElement(By.className("imageNav"));
            List<WebElement> categoryNavigationItems = driver.findElements(By.className("imageNavItem"));

            return categoryNavigation != null && categoryNavigationItems != null && categoryNavigationItems.size() != 0;
            // check if the section is existent and there are items in it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getImageNavigationItems() {
        try {
            List<WebElement> firstPageNavCategories = driver.findElements(By.className("imageNavItem"));
            for(WebElement element : firstPageNavCategories) {
                String text = element.findElement(By.tagName("span")).getText();
                if(!text.equals("Candy Toys") &&
                        !text.equals("Toy Vehicle") &&
                        !text.equals("Pretend Play & Preschool") &&
                        !text.equals("Toy Animal") &&
                        !text.equals("Action Figure") &&
                        !text.equals("Balloons") &&
                        !text.equals("Educational Toys") &&
                        !text.equals("Classic Toys") &&
                        !text.equals("Outdoor Toys & Structures") &&
                        !text.equals("Baby Toys") &&
                        !text.equals("Blocks"))
                    return false;
            } // check if all required categories are listed in the section

            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean get3DRealityShowroom() {
        try {
            String title = driver.findElement(By.xpath("//*[@id=\"mod_1_10456014\"]/div/div/a/div/div[1]/span")).getText();
            WebElement navigationElement = driver.findElement(By.xpath("//*[@id=\"mod_1_10456014\"]/div/div/div"));
            List<WebElement> gridItems = driver.findElements(By.className("grid-item"));

            return title.equals("3D Reality Showroom") && navigationElement != null &&
                    gridItems != null && gridItems.size() != 0;
            // checking if the section is existent and checking if there are items in it
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean getRecommendationsList() {
        try {
            String title = driver.findElement(By.xpath("//*[@id=\"mod_2_10291047\"]/div/h2")).getText();
            WebElement productList = driver.findElement(By.className("recommend-list"));
            List<WebElement> recommendedProducts = driver.findElements(By.className("flex5ColFloor"));

            return title.equals("Recommended for you") && productList != null &&
                    recommendedProducts != null && recommendedProducts.size() != 0;
            // checking if the section is existent and checking if there are items in it
        } catch (Exception ignored) {
            return false;
        }
    }
}
