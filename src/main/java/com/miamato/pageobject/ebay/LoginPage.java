package com.miamato.pageobject.ebay;

import com.miamato.PropertyManager;
import com.miamato.pageobject.BasePage;
import com.miamato.valueobjects.Customer;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());

    @FindBy(xpath = "//input[@id='userid']")
    public WebElement customerSignInEmail;
    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    public WebElement signInContinueButton;
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement customerSignInPassword;
    @FindBy(xpath = "//button[@id='sgnBt']")
    public WebElement signInButton;


    public LoginPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Sign In")
    public LoginPage signIn(Customer customer) {
        logger.info("Entering customer sign in email");
        customerSignInEmail.sendKeys(customer.signInEmail);
        logger.info("Clicking sign in continue button");
        signInContinueButton.click();
        logger.info("Entering customer sign in password");
        new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(1)).until(
                ExpectedConditions.visibilityOf(customerSignInPassword)).sendKeys(customer.signInPassword);
        logger.info("Clicking sign in  button");
        signInButton.click();
        return this;
    }
}
