package pptech.skitproject.alibabatesting.ui_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        return new ChromeDriver();
    }

}
