package stepDefinitions;

import cucumber.api.DataTable;
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


    @Given("^user navigates to Action Page$")
    public void user_navigates_to_Action_Page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^user clicks on checkboxes$")
    public void user_clicks_on_checkboxes(List<String> arg1) throws Throwable {
        for (String checkbox : arg1) {
            String checkboxXPath = "//input[@value='" + checkbox + "']";
            WebElement checkboxOption = driver.findElement(By.xpath(checkboxXPath));
            checkboxOption.click();
        }
    }

    @When("^user clicks on Result checkbox button$")
    public void user_clicks_on_Result_checkbox_button() throws Throwable {
        WebElement submitBtn = driver.findElement(By.id("result_button_checkbox"));
        submitBtn.click();
    }

    @Then("^message should be displayed \"([^\"]*)\"$")
    public void message_should_be_displayed(String arg1) throws Throwable {
        WebElement msg = driver.findElement(By.id("result_checkbox"));
        String actualMsg = msg.getText();
        Assert.assertEquals(arg1, actualMsg);
    }

    @When("^user enters details$")
    public void user_enters_details(Map<String, String> arg1) throws Throwable {
        //izveido Map no 2 vērtībām
        for (Map.Entry<String, String> txtBox : arg1.entrySet()) {
            String key = txtBox.getKey();         //name
            String value = txtBox.getValue();     //ABC
            WebElement textBox = driver.findElement(By.id(key));
            textBox.clear();
            textBox.sendKeys(value);
        }
    }

        @Given("^I have the following order$")
        public void i_have_the_following_order(DataTable arg1) throws Throwable {
            for (Map<String, String> map: arg1.asMaps(String.class, String.class)) {
                String vegetableName = map.get("vegetable"); //cucumber
                String quantity = map.get("quantity"); //4
                String cost = map.get("cost"); //10
                String availability = map.get("availability"); //yes

                System.out.println("===========");
                System.out.println("vegetable name: " + vegetableName);
                System.out.println("quantity: " + quantity);
                System.out.println("cost: " + cost);
                System.out.println("availability: " + availability);
                System.out.println("===========");


            }
        }

    }

