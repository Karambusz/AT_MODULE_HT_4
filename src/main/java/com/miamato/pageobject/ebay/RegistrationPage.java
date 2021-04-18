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

import java.sql.Timestamp;
import java.time.Duration;

public class RegistrationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class.getSimpleName());
    private final String EMAIL_SUFFIX = "customer@gmail.com";

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement customerFirstName;
    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement customerLastName;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement customerEmail;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement customerPassword;
    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='businessaccount-radio']")
    public WebElement businessAccountRadioButton;
    @FindBy(xpath = "//input[@id='businessName']")
    public WebElement customerBusinessName;
    @FindBy(xpath = "//input[@id='businessEmail']")
    public WebElement customerBusinessEmail;
    @FindBy(xpath = "//input[@id='bizPassword']")
    public WebElement customerBusinessPassword;
    @FindBy(xpath = "//button[@id='BUSINESS_REG_FORM_SUBMIT']")
    public WebElement createBusinessAccountButton;



    public RegistrationPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Create new account")
    public RegistrationPage createNewAccount(Customer customer){
        enterPersonalInformation(customer);
        enterNewCustomerEmail(customer, customerEmail);
        clickCreateAccountButton();
        return this;
    }

    @Step("Create new business account")
    public RegistrationPage createNewBusinessAccount(Customer customer){
        switchAccountType();
        enterBusinessInformation(customer);
        enterNewCustomerEmail(customer, customerBusinessEmail);
        createBusinessAccountButton.click();
        return this;
    }

    @Step("Enter customer personal information")
    public RegistrationPage enterPersonalInformation(Customer customer){
        logger.info("Entering customer name");
        customerFirstName.sendKeys(customer.name);
        logger.info("Entering customer last name");
        customerLastName.sendKeys(customer.lastName);
        logger.info("Entering password");
        customerPassword.sendKeys(customer.password);
        logger.info("Selecting birth date from dropdown");
        return this;
    }

    @Step("Enter customer business information")
    public RegistrationPage enterBusinessInformation(Customer customer){
        logger.info("Entering customer business name");
        customerBusinessName.sendKeys(customer.businessName);
        logger.info("Entering business password");
        customerBusinessPassword.sendKeys(customer.businessPassword);
        logger.info("Selecting birth date from dropdown");
        return this;
    }

    @Step("Enter customer business password")
    public RegistrationPage enterPassword(){
        logger.info("Entering business password");
        customerBusinessPassword.sendKeys("NewPasswordForRegistration_321");
        return this;
    }

    @Step("Enter new customer email")
    public RegistrationPage enterNewCustomerEmail(Customer customer, WebElement customerEmail){
        logger.info("Generating unique email for customer");
        long customerIndex = new Timestamp(System.currentTimeMillis()).getTime();
        logger.info("Entering generated email: " + customerIndex + EMAIL_SUFFIX);
        new WebDriverWait(driver, Duration.ofSeconds(2), Duration.ofSeconds(1)).until(
                ExpectedConditions.visibilityOf(customerEmail)).sendKeys(customerIndex + EMAIL_SUFFIX);
        customer.setEmail(customerIndex+EMAIL_SUFFIX);
        return this;
    }

    @Step("Switch account type")
    public RegistrationPage switchAccountType(){
        logger.info("Clicking Business account radio button");
        businessAccountRadioButton.click();
        return this;
    }

    @Step("Click create an account button")
    public RegistrationPage clickCreateAccountButton(){
        logger.info("Clicking create account button");
        createAccountButton.click();
        return this;
    }
}
