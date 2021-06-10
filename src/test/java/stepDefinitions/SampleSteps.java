package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @When("^user navigates to Age Page$")
    public void user_navigates_to_Age_Page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^User enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1) throws Throwable {
        WebElement nameTxtBox = driver.findElement(By.id("name"));
        nameTxtBox.clear();
        nameTxtBox.sendKeys(arg1);
    }

    @When("^User enter age (\\d+)$")
    public void user_enter_age(int arg1) throws Throwable {
        WebElement ageTxtBox = driver.findElement(By.name("age"));
        ageTxtBox.sendKeys("" + arg1);
    }

    @When("^User clicks on Submit button$")
    public void user_clicks_on_Submit_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
    }

    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("message"));
        String actual = msg.getText();
        Assert.assertEquals(arg1, actual);
    }

    @Given("^I am on number page$")
    public void i_am_on_number_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void i_enter_number(String arg1) throws Throwable {
        WebElement numberTxtBox = driver.findElement(By.id("numb"));
        numberTxtBox.click();
        numberTxtBox.sendKeys(arg1);
    }

    @When("^I click submit number$")
    public void i_click_submit_number() throws Throwable {
        WebElement submitBtn = driver.findElement(By.cssSelector(".w3-orange"));
        submitBtn.click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void i_see_a_message(String arg1) throws Throwable {
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String actual = errorMsg.getText();
        Assert.assertEquals(arg1, actual);
    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void i_see_a_new_message(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        Assert.assertEquals(arg1, actual);
        alert.accept();
    }


//    @Given("^I am on the home page$")
//    public void iAmOnTheHomePage() throws Throwable {
//        driver.get("https://kristinek.github.io/site");
//    }
//
//    @Then("^I should see home page header$")
//    public void iShouldSeeHomePageHeader() throws Throwable {
//        assertEquals("This is a home page",
//                driver.findElement(By.cssSelector("h1")).getText());
//    }
//
//    @And("^I should see home page description$")
//    public void iShouldSeeHomePageDescription() throws Throwable {
//        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//                driver.findElement(By.cssSelector("p")).getText());
//    }
//
//    @And("^I should see menu$")
//    public void iShouldSeeMenu() throws Throwable {
//        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
//    }


}



