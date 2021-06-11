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
    @When("^User navigates to Age page$")
    public void user_navigates_to_Age_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }
    @When("^User enter name \"([^\"]*)\"$")
    public void user_enter_name(String arg1) throws Throwable {
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(arg1);
    }
    @When("^User enter age \"([^\"]*)\"$")
    public void user_enter_age(String arg1) throws Throwable {
        WebElement age = driver.findElement(By.id("age"));
        age.clear();
        age.sendKeys(arg1);
    }
    @When("^User clicks on submit button$")
    public void user_clicks_on_submit_button() throws Throwable {
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
    }
    @Then("^User see message \"([^\"]*)\"$")
    public void user_see_message(String arg1) throws Throwable {
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(arg1,message.getText());
    }
    @Given("^I am on number page$")
    public void i_am_on_number_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
    @When("^I enter number: \"([^\"]*)\"$")
    public void i_enter_number(String arg1) throws Throwable {
        WebElement number = driver.findElement(By.id("numb"));
        number.clear();
        number.sendKeys(arg1);
    }
    @When("^I click submit number$")
    public void i_click_submit_number() throws Throwable {
        WebElement button = driver.findElement(By.xpath("//button[@type='button']"));
        button.click();
    }
    @Then("^I see a message: \"([^\"]*)\"$")
    public void i_see_a_message(String arg1) throws Throwable {
        WebElement message = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals(arg1,message.getText());
    }
    @Then("^I see a new message: \"([^\"]*)\"$")
    public void i_see_a_new_message(String arg1) throws Throwable {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(arg1,alert.getText());
        alert.dismiss();
    }
    @Given("^User navigates to Actions page$")
    public void user_navigates_to_Actions_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }
    @When("^User clicks on$")
    public void user_clicks_on(List<String> arg1) throws Throwable {
        for(String e : arg1){
            WebElement checkbox = driver.findElement(By.xpath("//input[@value='"+e+"']"));
            checkbox.click();
        }
    }
    @When("^User clicks result button$")
    public void user_clicks_result_button() throws Throwable {
        WebElement button  = driver.findElement(By.id("result_button_checkbox"));
        button.click();
    }
    @Then("^User see result message \"([^\"]*)\"$")
    public void user_see_result_message(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("result_checkbox"));
        Assert.assertEquals(arg1,msg.getText());
    }
    @When("^User enter name and age$")
    public void user_enter_name_and_age(Map<String,String> arg1) throws Throwable {
        for(Map.Entry<String,String> e : arg1.entrySet()){
            WebElement field = driver.findElement(By.id(e.getKey()));
            field.clear();
            field.sendKeys(e.getValue());
        }
    }
    /* Code for iterating Datatable with multiple columns, where column name is key and everything else are values
    |key1|key2|key3|
    |value|value|value|
    ...
    for(Map<String,String>map : DataTable arg1.asMaps(String.class,String.class)){
        String value = map.get("key name");
    }
     */
}