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

    // For sample1.feature:
    @When("^I am on the home page$")
    public void i_am_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/");

    }

    @Then("^I should see home page header$")
    public void i_should_see_home_page_header(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        // Should check that with video!!!
        WebElement title = driver.findElement(By.id("h1"));
        String headerMessage = title.getText();
        Assert.assertEquals(arg1, headerMessage);
    }

    @Then("^I should see home page description$")
    public void i_should_see_home_page_description(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        // Should check that with video!!!
        WebElement description = driver.findElement(By.tagName("p"));
        String descriptionMessage = description.getText();
        Assert.assertEquals(arg1, descriptionMessage);
    }

//    @Then("^I should see menu$")
//    public void i_should_see_menu() {
//        // Write code here that turns the phrase above into concrete actions
//        WebElement
//    }


    // For Sample2.feature:
    @When("^User navigates to Age Page$")
    public void user_navigates_to_Age_Page() {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }


    @When("^User enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1) { // it can be throws Throwable - it doesn't change the test run
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
    }

    @When("^User enter age (\\d+)$")
    public void user_enter_age(int arg1) {
        WebElement ageText = driver.findElement(By.name("age"));
        ageText.sendKeys("" + arg1);
    }

    @When("^User clicks on submit button$")
    public void user_clicks_on_submit_button() {
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();
    }

    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) {
        WebElement msg = driver.findElement(By.id("message"));
        String actualMessage = msg.getText();
        Assert.assertEquals(arg1, actualMessage);
    }

    // Task 1 test steps
    @Given("^I am on number page$")
    public void i_am_on_number_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void i_enter_number(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement enterNumber = driver.findElement(By.id("numb"));
        enterNumber.sendKeys("" + arg1);
    }

    @When("^I click submit number$")
    public void i_click_submit_number() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void i_see_a_message(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement message = driver.findElement(By.id("ch1_error"));
        String actualMessage = message.getText();
        Assert.assertEquals(arg1, actualMessage);

    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void i_see_a_new_message(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        String newMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(arg1,newMessage);
        alert.accept();
    }


}



