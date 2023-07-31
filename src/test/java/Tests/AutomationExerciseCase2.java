package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationExerciseCase2 {
    private WebDriver driver;
    private HomePage homePage;
    private SignUpLoginPage signUpLoginPage;

    @BeforeEach
    void setup() {
        //1. Launch browser

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage= new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);


        //2. Navigate to url 'http://automationexercise.com'

        driver.get("https://automationexercise.com/");

        //We gonna create new acc for test login User with correct email and password!
        homePage.clickOnElementXpath(homePage.signupLogin);
        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.newUserSignUp);

        // Enter name and email address

        signUpLoginPage.typeInBlankXpath(signUpLoginPage.name, "name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.email, "randommail07@gmail.com");

        // Click 'Signup' button

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.signUpButton);

        // Fill details: Title, Name, Email, Password, Date of birth

        signUpLoginPage.getRandomButton().click(); // To randomly select one of the mr and mrs options.
        signUpLoginPage.selectRandomDate();
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.password, "Password");
        signUpLoginPage.clickOnElementXpath(signUpLoginPage.newsletter);
        signUpLoginPage.clickOnElementXpath(signUpLoginPage.optin);

        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number */

        signUpLoginPage.typeInBlankXpath(signUpLoginPage.firstName, "First Name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.lastName, "Last Name");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.company, "Apple");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.address, "Milky Way Galaxy");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.address2, "Solar System, World");
        signUpLoginPage.selectRandomCountry();
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.state, "California");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.city, "Cupertino");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.zipCode, "07050");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.mobilePhoneNumber, "05551234567");

        // Click 'Create Account button'

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.createAccountButton);

        // Click 'Continue' button

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.continueButton);
        signUpLoginPage.clickOnElementXpath(signUpLoginPage.continueButton);

        // Click 'Log Out' button

        homePage.waitUntilTheElementShowXpath(homePage.logOutBttn);
        homePage.clickOnElementXpath(homePage.logOutBttn);




    }

    @Test
    void testLoginUserWithCorrectEmailandPassword(){
        //3.Verify that home page is visible successfully

        homePage.waitUntilTheElementShowXpath(homePage.logo);
        WebElement logo = driver.findElement(By.xpath(homePage.logo));
        Assertions.assertTrue(logo.isDisplayed());

        //4. Click on 'Signup / Login' button

        homePage.clickOnElementXpath(homePage.signupLogin);
        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.newUserSignUp);

        //5. Verify 'Login to your account' is visible

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.logintoyouracc);
        WebElement logintoyouraccount= driver.findElement(By.xpath(signUpLoginPage.logintoyouracc));
        Assertions.assertTrue(logintoyouraccount.isDisplayed());

        //6. Enter correct email address and password

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.emailadress);
        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.accPassword);

        signUpLoginPage.typeInBlankXpath(signUpLoginPage.emailadress, "randommail07@gmail.com");
        signUpLoginPage.typeInBlankXpath(signUpLoginPage.accPassword, "Password");

        //7. Click 'login' button

        signUpLoginPage.waitUntilTheElementShowXpath(signUpLoginPage.loginBttn);
        signUpLoginPage.clickOnElementXpath(signUpLoginPage.loginBttn);

        //8. Verify that 'Logged in as username' is visible

        homePage.waitUntilTheElementShowXpath(homePage.loggedAcc);
        WebElement loggedAcc = driver.findElement(By.xpath(homePage.loggedAcc));
        Assertions.assertTrue(loggedAcc.isDisplayed());

        //9. Click 'Delete Account' button

        homePage.waitUntilTheElementShowXpath(homePage.deleteAcc);
        homePage.clickOnElementXpath(homePage.deleteAcc);

        //10. Verify that 'ACCOUNT DELETED!' is visible

        homePage.waitUntilTheElementShowXpath(homePage.accDeleted);
        WebElement deletedAcc = driver.findElement(By.xpath(homePage.accDeleted));
        Assertions.assertTrue(deletedAcc.isDisplayed());

        signUpLoginPage.clickOnElementXpath(signUpLoginPage.continueButton);


    }

    @AfterEach
    void teardown() {
        driver.close();
    }

}

