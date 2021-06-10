package stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @When("^user navigates to Age Page$")
    public void user_navigates_to_Age_Page() {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^User enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1)  {
        WebElement nameTextBox = driver.findElement(By.id("name"));
        nameTextBox.clear();
        nameTextBox.sendKeys(arg1);
    }

    @When("^User enter age (\\d+)$")
    public void user_enter_age(int arg1) {
        WebElement ageTextBox = driver.findElement(By.id("age"));
        ageTextBox.sendKeys("" + arg1);
    }

    @When("^User clicks on submit button$")
    public void user_clicks_on_submit_button() {
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();
    }

    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) {
        WebElement message = driver.findElement(By.id("message"));
        String actualMessage = message.getText();
        Assert.assertEquals(arg1, actualMessage);
    }

    @Given("^I am on number page$")
    public void i_am_on_number_page() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void i_enter_number(String arg1) {
        WebElement numberInputField = driver.findElement(By.id("numb"));
        numberInputField.sendKeys(arg1);
    }

    @When("^I click submit number$")
    public void i_click_submit_number() {
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        submitButton.click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void i_see_a_message(String arg1) {
        WebElement message = driver.findElement(By.id("ch1_error"));
        String realValue = message.getText();
        Assert.assertEquals(arg1, realValue);
    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void i_see_a_new_message(String arg1)  {
        Alert alert = driver.switchTo().alert();
        String newMessage = alert.getText();
        Assert.assertTrue(newMessage.contains(arg1));
        alert.accept();
        Assert.assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }

}

