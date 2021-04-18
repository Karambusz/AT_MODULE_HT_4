package com.miamato.test;

import com.miamato.BaseTest;
import com.miamato.pageobject.ebay.HomePage;
import com.miamato.valueobjects.Customer;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayBasicTests extends BaseTest {

    @Test
    public void customerRegistration() throws InterruptedException {
        Customer customer = new Customer(propertyManager);
        homePage.open()
                .clickRegisterButton();
        registrationPage.createNewAccount(customer);
        checkName(customer);
    }

    @Test
    public void customerBusinessRegistration() throws InterruptedException {
        Customer customer = new Customer(propertyManager);
        homePage.open()
                .clickRegisterButton();
        registrationPage.createNewBusinessAccount(customer);
        Assert.assertFalse(registrationPage.createBusinessAccountButton.isEnabled());
    }


    @Test
    public void customerSignIn(){
        Customer customer = new Customer(propertyManager);
        homePage.open()
                .clickSignInButton();
        loginPage.signIn(customer);
        checkSignName(customer);
    }

    @Step("Check customer name")
    private void checkName(Customer customer){
        assertLogger.info("Checking customer name on homepage");
        Assert.assertEquals(homePage.customerTitleName.getText(), "Hi " + customer.name  + " !");
    }

    @Step("Check customer sign in name")
    private void checkSignName(Customer customer){
        assertLogger.info("Checking customer name on homepage");
        Assert.assertEquals(homePage.customerTitleName.getText(), "Hi " + customer.signInName + " !");
    }
}
