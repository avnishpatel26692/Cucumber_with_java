package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

//    @Given("^I am on the home page DEMO$")
//    public void iAmOnTheHomePageDEMO() throws Throwable {
//        driver.get("http://www.demoshop24.com/index.php?route=common/home");
//
//    }
//
//    @When("^I click on 'My Account' button on top right side$")
//    public void iClickOnMyAccountButtonOnTopRightSide() throws Throwable {
//        WebElement ButOnRightSide = driver.findElement(By.className("dropdown open"));
//        ButOnRightSide.click();
//
//    }

//    @And("^In dropdown I click on 'Register' button$")
//    public void inDropdownIClickOnRegisterButton() {
//
//
//    }
//
//    @And("^I am fill the registration form$")
//    public void iAmFillTheRegistrationForm() {
//    }
//
//    @And("^I click on 'Continue' button$")
//    public void iClickOnContinueButton() {
//
//    }
//
//    @And("^I click on next'Continue' button$")
//    public void iClickOnNextContinueButton() {
//
//    }
//
//    @Then("^On the left side I see 'My Account' block, 'My Orders' block and below 'My Account' is 'Edit your account information'$")
//    public void onTheLeftSideISeeMyAccountBlockMyOrdersBlockAndBelowMyAccountIsEditYourAccountInformation() {
//    }
}



