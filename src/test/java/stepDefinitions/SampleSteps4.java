package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class SampleSteps4 {
    private WebDriver driver;

    public SampleSteps4() {
        this.driver = Hooks.driver;
    }

    @Given("^user navigates to action page$")
    public void user_navigates_to_action_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^user clicks on checkboxes$")
    public void user_clicks_on_checkboxes(List<String> arg1) throws Throwable {
        for(String checkBoxValue : arg1)
        {
            String checkboxXpath = "//input[@value='" + checkBoxValue + "']";
            WebElement checkbox = driver.findElement(By.xpath(checkboxXpath));
            checkbox.click();
        }
    }

    @When("^user clicked on result checkbox button$")
    public void user_clicked_on_result_checkbox_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.id("result_button_checkbox"));
        submitBtn.click();
    }

    @Then("^message should be displayed \"([^\"]*)\"$")
    public void message_should_be_displayed(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("result_checkbox"));
        String actualMsg = msg.getText();
        Assert.assertEquals(arg1,actualMsg );
    }

    @When("^user enters details$")
    public void user_enters_details(Map<String, String> arg1) throws Throwable {
        for(Map.Entry<String, String> txtbox: arg1.entrySet())
        {
            String key = txtbox.getKey(); //name
            String value = txtbox.getValue(); //ABC
            WebElement textbox = driver.findElement(By.id(key));
            textbox.clear();
            textbox.sendKeys(value);
        }

    }

}