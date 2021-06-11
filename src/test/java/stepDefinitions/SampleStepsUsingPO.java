package stepDefinitions;

import PageObject.AgePO;
import PageObject.AgeSubmittedPO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SampleStepsUsingPO {
    private WebDriver driver;
    static AgePO agePageObj;
    static AgeSubmittedPO ageSubPageObj;

    public SampleStepsUsingPO()
    { this.driver = Hooks.driver;
    agePageObj = PageFactory.initElements(driver,AgePO.class);
    ageSubPageObj = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

    @Given("^I am on age page using PO$")
    public void i_am_on_age_page_using_PO() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void i_enter_name_using_PO(String arg1) throws Throwable {
        agePageObj.setName(arg1);
    }

    @When("^I enter age: (\\d+) using PO$")
    public void i_enter_age_using_PO(int arg1) throws Throwable {
        agePageObj.setAge(""+arg1);
    }

    @When("^I click submit age using PO$")
    public void i_click_submit_age_using_PO() throws Throwable {
        agePageObj.clickOnSubmit();
    }

    @Then("^I see message: \"([^\"]*)\" using PO$")
    public void i_see_message_using_PO(String arg1) throws Throwable {
        String actualMessage = ageSubPageObj.getMsg();
        Assert.assertEquals(arg1,actualMessage);
    }

}
