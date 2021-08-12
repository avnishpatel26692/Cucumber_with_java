package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import runners.CucumberRunner;


public class Registration {
    private WebDriver driver;
    static EmailGenerator  emailGenerator;

    public Registration(){
        this.driver = Hooks.driver;
        emailGenerator = PageFactory.initElements(Hooks.driver, EmailGenerator.class);
    }


    @Given("^I am on the home page DEMO$")
    public void i_am_on_the_home_page_DEMO() throws Throwable {
        driver.get("http://www.demoshop24.com/index.php?route=common/home");
    }

    @When("^I click on 'My Account' button on top right side$")
    public void i_click_on_My_Account_button_on_top_right_side() throws Throwable {
        WebElement MyAccountBtn = driver.findElement(By.className("dropdown"));
        MyAccountBtn.click();
    }

    @When("^In dropdown I click on 'Register' button$")
    public void in_dropdown_I_click_on_Register_button() throws Throwable {
        WebElement RegBTN = driver.findElement(By.xpath("//a[text()='Register']"));
        RegBTN.click();
    }
    @When("^I am fill the registration form: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_am_fill_the_registration_form(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        FirstName.clear();
        FirstName.sendKeys(arg1);
        WebElement LastName = driver.findElement(By.id("input-lastname"));
        LastName.clear();
        LastName.sendKeys(arg2);
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.clear();
        Telephone.sendKeys(arg3);
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(arg4);
        WebElement PassConfirm = driver.findElement(By.id("input-confirm"));
        PassConfirm.clear();
        PassConfirm.sendKeys(arg5);
    }

    @And("^I am fill email field \"([^\"]*)\"$")
    public void iAmFillEmailField(String arg0) throws Throwable {
        emailGenerator.setEmail(arg0);
    }



    @When("^I am click on 'Subscribe' radio button$")
    public void i_am_click_on_Subscribe_radio_button() throws Throwable {
        WebElement RadioBtn = driver.findElement(By.xpath("//*[@value='0']"));
        RadioBtn.click();
    }

    @When("^I am click on 'Privacy Policy' checkbox button$")
    public void i_am_click_on_Privacy_Policy_checkbox_button() throws Throwable {
        WebElement Checkbox = driver.findElement(By.name("agree"));
        Checkbox.click();
    }

    @When("^I click on 'Continue' button$")
    public void i_click_on_Continue_button() throws Throwable {
        WebElement ContBtn = driver.findElement(By.xpath("//*[@value='Continue']"));
        ContBtn.click();
   }

    @When("^I click on next 'Continue' button$")
    public void i_click_on_next_Continue_button() throws Throwable {
        WebElement NextContBtn = driver.findElement(By.xpath("//a[text()='Continue']"));
        NextContBtn.click();
    }

    @Then("^On the left side I see 'My Account' block, 'My Orders' block and below 'My Account' is 'Edit your account information'$")
    public void on_the_left_side_I_see_My_Account_block_My_Orders_block_and_below_My_Account_is_Edit_your_account_information() throws Throwable {
        WebElement AccBlock = driver.findElement(By.xpath("//*[@id='content']/ul[1]"));
        Assert.assertTrue(AccBlock.isDisplayed());

    }

}
