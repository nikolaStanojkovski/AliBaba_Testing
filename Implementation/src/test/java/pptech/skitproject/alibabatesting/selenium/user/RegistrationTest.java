package pptech.skitproject.alibabatesting.selenium.user;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pptech.skitproject.alibabatesting.selenium.Setup;
import pptech.skitproject.alibabatesting.models.TradeRole;

public class RegistrationTest {

    private WebDriver driver;

    /*
        Test 1: Successful registration with valid credentials

        Test 2: Unsuccessful registration with invalid trade role
        Test 3: Unsuccessful registration with empty email address
        Test 4: Unsuccessful registration with incorrect email address format (correct email address format: test@test.com)
        Test 5: Unsuccessful registration with empty password
        Test 6: Unsuccessful registration with incorrect login password with unsatisfied requirements (Requirements: 6 to 20 characters and combination of letters, numbers and symbols)
        Test 7: Unsuccessful registration with empty confirm password
        Test 8: Unsuccessful registration with unmatched password and confirm password
        Test 9: Unsuccessful registration with empty company name
        Test 10: Unsuccessful registration with empty username
        Test 11: Unsuccessful registration with incorrect username format
        Test 12: Unsuccessful registration with incorrect phone number (phone number should be valid and have less than 14 digits)
        Test 13: Unsuccessful registration with unverified slider bar
        Test 14: Unsuccessful registration with unchecked license agreement

     */

    @BeforeTest
    public void setup(){
        driver = Setup.getDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        Assert.assertTrue(registrationPage.isLoaded());
    }

    @Order(1)
    @Test
    public void test1() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertTrue(registrationPage.bannerIsOpened());
    }

    @Order(2)
    @Test
    public void test2() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(null, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getTradeRoleError(), "Please select trade role");
    }

    @Order(3)
    @Test
    public void test3() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getEmailError(), "Please enter your email");
    }

    @Order(4)
    @Test
    public void test4() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba.error.gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getEmailError(), "The format of the email address is incorrect. Please fill in again");
    }

    @Order(5)
    @Test
    public void test5() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getPasswordError(), "Please set the login password");
    }

    @Order(6)
    @Test
    public void test6() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "testPassword",
                "projectskital1b@b@", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getPasswordError(), "The password setting does not meet the requirements");
    }

    @Order(7)
    @Test
    public void test7() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getConfirmPasswordError(), "Please enter the login password again");
    }

    @Order(8)
    @Test
    public void test8() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "project", "SKIT Testing Project", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getConfirmPasswordError(), "The two passwords you entered are inconsistent. Please enter again");
    }

    @Order(9)
    @Test
    public void test9() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "", "SKIT Project", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getCompanyNameError(), "Enter the company name");
    }

    @Order(10)
    @Test
    public void test10() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Project", "", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getUsernameError(), "Please enter the user name");
    }

    @Order(11)
    @Test
    public void test11() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Project", "S", "+389-78-916885", true, true);

        Assert.assertEquals(registrationPage.getUsernameError(), "Please enter 1-60 alphabetical characters");
    }

    @Order(12)
    @Test
    public void test12() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Project", "SKIT Project", "", true, true);

        Assert.assertEquals(registrationPage.getPhoneNumberError(), "Please enter less than 14 digits");
    }

    @Order(13)
    @Test
    public void test13() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Project", "SKIT Project", "+389-78-916885", false, true);

        Assert.assertEquals(registrationPage.getVerificationError(), "Please drag the slider for verification");
    }

    @Order(14)
    @Test
    public void test14() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.signUp(TradeRole.BUYER, "projectskitalibaba@gmail.com", "projectskital1b@b@",
                "projectskital1b@b@", "SKIT Project", "SKIT Project", "+389-78-916885", true, false);

        Assert.assertEquals(registrationPage.getAgreementError(), "Please check the agreement");
    }

}
