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
//
//    @Given("^I am on the home page$")
//    public void iAmOnTheHomePage() throws Throwable {
//        driver.get("https://kristinek.github.io/site/examples/age.html");
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
//}

//    @When("^user navigates to Age Page$")
//    public void user_navigates_to_Age_Page() throws Throwable {
//        driver.get("https://kristinek.github.io/site/examples/age.html");
//    }
//
//    @When("^User enter name \"([^\"]*)\"$")
//    public void user_enter_name(String arg1) throws Throwable {
//        WebElement nameTextbox = driver.findElement(By.id("name"));
//        nameTextbox.clear();
//        nameTextbox.sendKeys(arg1);
//    }
//
//    @When("^User enter age (\\d+)$")
//    public void user_enter_age(int arg1) throws Throwable {
//        WebElement ageText = driver.findElement(By.name("age"));
//        ageText.sendKeys(""+arg1);
//    }
//
//    @When("^User clicks on submit button$")
//    public void user_clicks_on_submit_button() throws Throwable {
//        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
//        submitBtn.click();
//    }

//    @Then("^User see message \"([^\"]*)\"$")
//    public void user_see_message(String arg1) throws Throwable {
//        WebElement msg = driver.findElement(By.id("message"));
//        String atcualMessage = msg.getText();
//        Assert.assertEquals(arg1,atcualMessage );
//    }
//}

    @Given("^I am on number page$")
    public void IamOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^I enter number: \"([^\"]*)\"$")
    public void I_enter_number(String arg1) throws Throwable {
        WebElement numberTextbox = driver.findElement(By.id("numb"));
        numberTextbox.clear();
        numberTextbox.sendKeys(arg1);
    }

    @When("^I click submit number$")
    public void user_clicks_on_submit_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button"));
        submitBtn.click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void I_see_a_message(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("ch1_error"));
        String atcualMessage = msg.getText();
        Assert.assertEquals(arg1, atcualMessage);
    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void I_see_a_new_message(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(arg1,alertMsg);
    }


}


