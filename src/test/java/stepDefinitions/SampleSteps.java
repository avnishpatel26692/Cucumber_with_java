package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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

//    @Given("^I am on number page$")
//    public void i_am_on_number_page() throws Throwable {
//        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
//
//    }
//
//    @When("^I enter number: \"([^\"]*)\"$")
//    public void i_enter_number(String arg1) throws Throwable {
//        WebElement numberLine = driver.findElement(By.id("numb"));
//        numberLine.sendKeys(arg1);
//    }
//
//    @When("^I click submit number$")
//    public void i_click_submit_number() throws Throwable {
//        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
//        submitBtn.click();
//    }
//
//    @Then("^I see a message: \"([^\"]*)\"$")
//    public void i_see_a_message(String arg1) throws Throwable {
//        WebElement msg = driver.findElement(By.className("error"));
//        String actualMsg = msg.getText();
//        Assert.assertEquals(arg1, actualMsg);
//
//
//    }
//
//    @Then("^I see a new message: \"([^\"]*)\"$")
//    public void i_see_a_new_message(String arg1) throws Throwable {
//        Alert alert = driver.switchTo().alert();
//        String actualMsg = alert.getText();
//        Assert.assertEquals(arg1, actualMsg);
//    }
//}


    @Given("^user navigates to Age Page$")
    public void user_navigates_to_Age_Page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @Then("^user enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
    }

    @And("^user enter age \"([^\"]*)\"$")
    public void user_enter_age(int arg1) throws Throwable {
        WebElement ageText = driver.findElement(By.name("age"));
        ageText.sendKeys("" + arg1);
    }

    @And("^User clicks on submit button$")
    public void user_clicks_on_submit_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();
    }

    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("message"));
        String actualMessage = msg.getText();
        Assert.assertEquals(arg1, actualMessage);
    }
}




