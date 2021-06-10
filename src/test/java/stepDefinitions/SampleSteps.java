package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.junit.Assert;
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



    @Given("^I am on number page$")
    public void i_am_on_number_page() throws Throwable {
        driver.get ("https://kristinek.github.io/site/tasks/enter_a_number");

    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void i_enter_number(String arg1) throws Throwable {
        WebElement fieldToEnterNumber = driver.findElement(By.id("numb"));
        fieldToEnterNumber.sendKeys(arg1);

    }

    @When("^I click submit number$")
    public void i_click_submit_number() throws Throwable {
        WebElement fieldToEnterNumber2 = driver.findElement(By.className("w3-orange"));
        fieldToEnterNumber2.click();

    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void i_see_a_message(String arg1) throws Throwable {
    WebElement errorMessage = driver.findElement(By.id(("ch1_error")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(arg1, actualMessage);
    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void i_see_a_new_message(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(arg1, alertMsg);
    }
    }




