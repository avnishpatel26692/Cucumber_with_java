package stepDefinitions;

import PageObjects.AgePO;
import PageObjects.AgeSubmittedPO;
import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class SampleStepsUsingPO {
    private WebDriver driver;
    static AgePO agePageObject;
    static AgeSubmittedPO ageSubmittedPageObject;

    public SampleStepsUsingPO() {
        this.driver = Hooks.driver;
        agePageObject = PageFactory.initElements(driver, AgePO.class);
        ageSubmittedPageObject = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

//    @Given("^I am on age page using PO$")
//    public void i_am_on_age_page_using_PO() throws Throwable {
//        driver.get("https://kristinek.github.io/site/examples/age.html");
//    }
//
//    @When("^I enter name: \"([^\"]*)\" using PO$")
//    public void i_enter_name_using_PO(String arg1) throws Throwable {
//        agePageObject.setName(arg1);
//    }
//
//    @When("^I enter age: (\\d+) using PO$")
//    public void i_enter_age_using_PO(int arg1) throws Throwable {
//        agePageObject.setAge(""+arg1);
//    }
//
//    @When("^I click submit age using PO$")
//    public void i_click_submit_age_using_PO() throws Throwable {
//        agePageObject.clickOnSubmit();
//    }
//
//    @Then("^I see message: \"([^\"]*)\" using PO$")
//    public void i_see_message_using_PO(String arg1) throws Throwable {
//        String actualMessage = ageSubmittedPageObject.getMsg();
//        Assert.assertEquals(arg1, actualMessage);
//    }

    @Given("^I am on Employee page$")
    public void i_am_on_Employee_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
        WebElement addPersonBtn = driver.findElement(By.id("addPersonBtn"));
        addPersonBtn.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String  arg7) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
        WebElement surnameTextbox = driver.findElement(By.id("surname"));
        surnameTextbox.clear();
        surnameTextbox.sendKeys(arg2);
        WebElement jobTextbox = driver.findElement(By.id("job"));
        jobTextbox.clear();
        jobTextbox.sendKeys(arg3);
        WebElement calendarTextbox = driver.findElement(By.id("dob"));
        calendarTextbox.clear();
        calendarTextbox.sendKeys(arg4);
        calendarTextbox.sendKeys(Keys.ENTER);
        WebElement checkbox = driver.findElement(By.id(arg5));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        WebElement radioBtn = driver.findElement(By.id(arg6));
        radioBtn.click();

        WebElement employeeStatus = driver.findElement(By.id("status"));
            Select dropDown = new Select(employeeStatus);
            dropDown.selectByVisibleText(arg7);

        }




    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addBtn = driver.findElement(By.id("modal_button"));
        addBtn.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtn = driver.findElement(By.xpath("//*[@id='person3']/span[2]"));
        editBtn.click();

    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);

        WebElement surnameTextbox = driver.findElement(By.id("surname"));
        surnameTextbox.clear();
        surnameTextbox.sendKeys(arg2);

        WebElement jobTextbox = driver.findElement(By.id("job"));
        jobTextbox.clear();
        jobTextbox.sendKeys(arg3);
        WebElement calendarTextbox = driver.findElement(By.id("dob"));
        calendarTextbox.clear();
        calendarTextbox.sendKeys(arg4);
        calendarTextbox.sendKeys(Keys.ENTER);
        WebElement checkbox = driver.findElement(By.id(arg5));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        WebElement radioBtn = driver.findElement(By.id(arg6));
        radioBtn.click();

        WebElement employeeStatus = driver.findElement(By.id("status"));
        Select dropDown = new Select(employeeStatus);
        dropDown.selectByVisibleText(arg7);

    }


    @When("^click on edit-button$")
    public void click_on_edit_button1() throws Throwable {
        WebElement edit1Btn = driver.findElement(By.id("modal_button"));
        edit1Btn.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement removeBtn = driver.findElement(By.xpath("//*[@id='person3']/span[1]"));
        removeBtn.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement edit1Btn = driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']"));
        edit1Btn.click();

    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearBtn = driver.findElement(By.id("addPersonBtn"));
        clearBtn.click();

    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        Assert.assertTrue(nameTextbox.getText().isEmpty());

        WebElement surnameTextbox = driver.findElement(By.id("surname"));
        Assert.assertTrue(surnameTextbox.getText().isEmpty());

        WebElement jobTextbox = driver.findElement(By.id("job"));
        Assert.assertTrue(jobTextbox.getText().isEmpty());

        WebElement calendarTextbox = driver.findElement(By.id("dob"));
        Assert.assertTrue(calendarTextbox.getText().isEmpty());

        WebElement checkbox = driver.findElement(By.id("english"));
        Assert.assertTrue(checkbox.isSelected());

        WebElement checkbox1 = driver.findElement(By.id("french"));
        Assert.assertFalse(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.id("spanish"));
        Assert.assertFalse(checkbox2.isSelected());

        WebElement radioBtn = driver.findElement(By.id("male"));
        Assert.assertFalse(radioBtn.isSelected());


        WebElement radioBtn1 = driver.findElement(By.id("female"));
        Assert.assertFalse(radioBtn1.isSelected());

        WebElement employeeStatus = driver.findElement(By.id("status"));
        Select dropdown = new Select(employeeStatus);
        Assert.assertEquals("Employee", dropdown.getFirstSelectedOption().getText());

        }


    }