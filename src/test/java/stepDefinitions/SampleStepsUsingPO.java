package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import runners.PageObjects.AgeSubmittedPO;
import runners.PageObjects.PagePO;

import java.awt.print.PageFormat;

public class SampleStepsUsingPO {
    private WebDriver driver;
    PagePO agePageObject;
    AgeSubmittedPO ageSubmittedPageObject;
    public SampleStepsUsingPO(){
        this.driver = Hooks.driver;
        agePageObject  = PageFactory.initElements(driver, PagePO.class);
        ageSubmittedPageObject = PageFactory.initElements(driver, AgeSubmittedPO.class);

    }

    @Given("^I am on age page using PO$")
    public void i_am_on_age_page_using_PO() throws Throwable {
    driver.get("https://kristinek.github.io/site/examples/age");
    }

    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void i_enter_name_using_PO(String arg1) throws Throwable {
        agePageObject.setName(arg1);
    }

    @When("^I enter age: (\\d+) using PO$")
    public void i_enter_age_using_PO(int arg1) throws Throwable {
        agePageObject.setAge(""+ arg1);
    }

    @When("^I click submit age using PO$")
    public void i_click_submit_age_using_PO() throws Throwable {
        agePageObject.clicSubmit();
    }

    @Then("^I see message \"([^\"]*)\" using PO$")
    public void i_see_message_using_PO(String arg1) throws Throwable {
        String actualMessage = ageSubmittedPageObject.getMsg();
        Assert.assertEquals(actualMessage, arg1);
    }

}
