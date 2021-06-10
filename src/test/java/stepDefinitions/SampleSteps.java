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

    @When("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see home page header$")
    public void i_should_see_home_page_header() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see home page description$")
    public void i_should_see_home_page_description() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see menu$")
    public void i_should_see_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user navigates to Age Page$")
    public void user_navigates_to_Age_Page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^User enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
    }

    @When("^User enter age (\\d+)$")
    public void user_enter_age(int arg1) throws Throwable {
        WebElement ageText = driver.findElement(By.name("age"));
        ageText.sendKeys(""+arg1);
    }

    @When("^User clicks on submit button$")
    public void user_clicks_on_submit_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();
    }

    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("message"));
        String atcualMessage = msg.getText();
        Assert.assertEquals(arg1,atcualMessage );
    }
}




