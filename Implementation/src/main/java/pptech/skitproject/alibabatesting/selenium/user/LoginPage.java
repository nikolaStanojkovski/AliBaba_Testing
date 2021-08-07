package pptech.skitproject.alibabatesting.selenium.user;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pptech.skitproject.alibabatesting.selenium.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://passport.alibaba.com/icbu_login.htm?return_url=null&hasPreCheckLogin=true");
    }

    public boolean isLoaded() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form"))).isDisplayed();
    }

    public void signIn(String email, String password) throws InterruptedException {
        // email
        driver.findElement(By.id("fm-login-id")).sendKeys(email);

        // password
        driver.findElement(By.id("fm-login-password")).sendKeys(password);


        // submit button
        driver.findElement((By.cssSelector("input[value='Sign In']"))).click();
        Thread.sleep(3000);
    }

    public String getErrorMessage() {
        try {
            WebElement element = driver.findElement(By.id("//*[@id='login-error']/span[2]"));
            return element.getText(); // return the text of the error if it is displayed
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public void checkSlideBar() {
        try {
            driver.switchTo().frame(0);
            WebElement slider = driver.findElement(By.id("nc_1_n1z"));
            Actions move = new Actions(driver);
            Action action = (Action) move.dragAndDropBy(slider, 319, 0).build();
            action.perform();
            Thread.sleep(5000);
        } catch (NoSuchElementException | InterruptedException ignored) {

        }
    }

}
