package stepDefinitions;

import pageObject.AgePO;
import pageObject.AgeSubmittedPO;
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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SampleStepsWithPO {
    private WebDriver driver;
    private AgePO agePO;
    private AgeSubmittedPO ageSubmittedPO;

    public SampleStepsWithPO() {
        this.driver = Hooks.driver;
        agePO = PageFactory.initElements(driver,AgePO.class);
        ageSubmittedPO = PageFactory.initElements(driver,AgeSubmittedPO.class);
    }

    @When("^User navigates to Age page using PO$")
    public void user_navigates_to_Age_page_using_PO() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^User enter name and age using PO$")
    public void user_enter_name_and_age_using_PO(Map<String,String> arg1) throws Throwable {
        int i =1;
        for(Map.Entry<String,String> entry : arg1.entrySet()){
            if(i==1){ agePO.setName(entry.getValue()); }
            if(i==2){agePO.setAge(entry.getValue());}
            i++;
        }
    }

    @When("^User clicks on submit button using PO$")
    public void user_clicks_on_submit_button_using_PO() throws Throwable {
        agePO.submit();
    }

    @Then("^User see message using PO \"([^\"]*)\"$")
    public void user_see_message_using_PO(String arg1) throws Throwable {
        Assert.assertEquals(arg1,ageSubmittedPO.getMessage());
    }

}
