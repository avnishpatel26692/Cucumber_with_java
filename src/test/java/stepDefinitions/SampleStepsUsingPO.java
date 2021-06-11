package stepDefinitions;

import PageObjects.AgePO;
import PageObjects.AgeSubmittedPO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SampleStepsUsingPO {
    private WebDriver driver;
    static AgePO agePageObject;
    static AgeSubmittedPO ageSubmittedPageObject;

    public SampleStepsUsingPO() {
        this.driver = Hooks.driver;
        agePageObject = PageFactory.initElements(driver, AgePO.class);
        ageSubmittedPageObject = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

    @When("^I am on Age Page using PO$")
    public void i_am_on_Age_Page_using_PO() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^I enter name \"([^\"]*)\" using PO$")
    public void i_enter_name_using_PO(String arg1) throws Throwable {
        agePageObject.setName(arg1);
    }

    @When("^I enter age (\\d+) using PO$")
    public void i_enter_age_using_PO(int arg1) throws Throwable {
        agePageObject.setAge("" + arg1);
    }

    @When("^I click on Submit button using PO$")
    public void i_click_on_Submit_button_using_PO() throws Throwable {
        agePageObject.clickOnSubmit();
    }

    @Then("^I see message \"([^\"]*)\" using PO$")
    public void i_see_message_using_PO(String arg1) throws Throwable {
        String msg = ageSubmittedPageObject.getMessage();
        Assert.assertEquals(msg, arg1);
    }


}
