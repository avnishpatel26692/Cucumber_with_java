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

public class SampleSteps4 {

    private WebDriver driver;

    public SampleSteps4() {
        this.driver = Hooks.driver;
    }

    @Given("^user navigates to Action Page$")
    public void user_navigates_to_Action_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^user clicks on checkboxes$")
    public void user_clicks_on_checkboxes(List<String> args1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        for (String checkBoxValue : args1) {
            String xPath = "//input[@id='" + checkBoxValue + "']"; //input[@value='Option1']
            WebElement checkBox = driver.findElement(By.xpath(xPath));
            checkBox.click();
        }
    }

    @When("^user clicked on result checkbox button$")
    public void user_clicked_on_result_checkbox_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement submitButton = driver.findElement(By.id("result_button_checkbox"));
        submitButton.click();
    }

    @Then("^message should be displayed \"([^\"]*)\"$")
    public void message_should_be_displayed(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement message = driver.findElement(By.id("result_checkbox"));
        //String expectedMessage = "You selected value(s): Option 1, Option 2";
        String actualMessage = message.getText();
        Assert.assertEquals(arg1, actualMessage);
    }

}
