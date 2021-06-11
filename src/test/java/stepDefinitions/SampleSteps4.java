package stepDefinitions;

import cucumber.api.DataTable;
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
       for(String checkboxValue : arg1){
           String checkxpath = "//input[@value = '" + checkboxValue + "']";
           WebElement checkbox = driver.findElement(By.xpath(checkxpath));
           checkbox.click();
       }
    }

    @When("^user clicked on result checkbox button$")
    public void user_clicked_on_result_checkbox_button() throws Throwable {
        WebElement clickButton = driver.findElement(By.id("result_button_checkbox"));
        clickButton.click();
    }

    @Then("^message should be displayed \"([^\"]*)\"$")
    public void message_should_be_displayed(String arg1) throws Throwable {
        WebElement message = driver.findElement(By.id("result_checkbox"));
        String actualMessage = arg1;
        Assert.assertEquals(message.getText(), actualMessage);
    }

    @When("^user enters details$")
    public void user_enters_details(Map<String, String> arg1) throws Throwable {

        for(Map.Entry<String, String> txtbox: arg1.entrySet()){
            String key = txtbox.getKey();
            String value = txtbox.getValue();
            WebElement textbox = driver.findElement(By.id(key));
            textbox.clear();
            textbox.sendKeys(value);
        }
    }
    @Given("^I have the following order$")
    public void i_have_the_following_order(DataTable arg1) throws Throwable {
        for(Map<String, String> map : arg1.asMaps(String.class, String.class)){
            String vegetableName = map.get("vegetable");
            String quantity = map.get("quantity");
            String cost = map.get("cost");
            String availability = map.get("Availability");
            System.out.println("Vegetable: " + vegetableName);
            System.out.println("Quantity: " + quantity);
            System.out.println("cost: " + cost);
            System.out.println(("Availability: " + availability));
        }
    }
}
