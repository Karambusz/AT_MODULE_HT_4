package com.miamato.pageobject.ebay;

import com.miamato.PropertyManager;
import com.miamato.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class.getSimpleName());
    private final String HOME_PAGE_URL = propertyManager.getProperty("homepage.url");

    @FindBy(xpath = "//a[@href='https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F']")
    public WebElement registrationButton;

    @FindBy(xpath = "//a[@href='https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@id='gh-ug']")
    public WebElement customerTitleName;

    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    @Step("Click on register button")
    public HomePage clickRegisterButton(){
        logger.info("Trying to click on register button on homepage");
        new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(registrationButton)).click();
        return this;
    }

    @Step("Click on sign in button")
    public HomePage clickSignInButton(){
        logger.info("Trying to click on register button on homepage");
        new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(signInButton)).click();
        return this;
    }
}
