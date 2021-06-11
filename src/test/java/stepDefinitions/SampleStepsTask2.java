package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SampleStepsTask2 {
    private WebDriver driver;

    public SampleStepsTask2() {
        this.driver = Hooks.driver;
    }


    @Given("^I am on Employee page$")
    public void i_am_on_Employee_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
        WebElement addBtn = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        addBtn.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement enterName = driver.findElement(By.id("name"));
        enterName.clear();
        enterName.click();
        enterName.sendKeys(arg1);

        WebElement enterSurname = driver.findElement(By.id("surname"));
        enterSurname.clear();
        enterSurname.click();
        enterSurname.sendKeys(arg2);

        WebElement enterJob = driver.findElement(By.id("job"));
        enterJob.clear();
        enterJob.click();
        enterJob.sendKeys(arg3);

        WebElement dateOfBirtField = driver.findElement(By.id("dob"));
        dateOfBirtField.click();
        dateOfBirtField.clear();
        dateOfBirtField.sendKeys(arg4 + Keys.TAB);

        WebElement checkbox = driver.findElement(By.id(arg5));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement genderBtn = driver.findElement(By.id(arg6));
        genderBtn.click();

        WebElement employeeStatusDropDown = driver.findElement(By.id("status"));
        Select dropdownSelect = new Select(employeeStatusDropDown);
        dropdownSelect.selectByVisibleText(arg7);
    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addBtn = driver.findElement(By.xpath("//button[@onclick='addPersonToList()']"));
        addBtn.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_buttonP() throws Throwable {
        WebElement editBtnP = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editBtnP.click();
    }

    //
    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String
            arg7) throws Throwable {
        WebElement enterName = driver.findElement(By.id("name"));
        enterName.click();
        enterName.clear();
        enterName.sendKeys(arg1);

        WebElement enterSurname = driver.findElement(By.id("surname"));
        enterSurname.click();
        enterSurname.clear();
        enterSurname.sendKeys(arg2);

        WebElement enterJob = driver.findElement(By.id("job"));
        enterJob.click();
        enterJob.clear();
        enterJob.sendKeys(arg3);

        WebElement dateOfBirtField = driver.findElement(By.id("dob"));
        dateOfBirtField.click();
        dateOfBirtField.clear();
        dateOfBirtField.sendKeys(arg4 + Keys.TAB);

        WebElement checkbox = driver.findElement(By.id(arg5));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement genderBtn = driver.findElement(By.id(arg6));
        genderBtn.click();

        WebElement employeeStatusDropDown = driver.findElement(By.id("status"));
        Select dropdownSelect = new Select(employeeStatusDropDown);
        dropdownSelect.selectByVisibleText(arg7);
    }

    @When("^click on edit-button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtn = driver.findElement(By.id("modal_button"));
        editBtn.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement removeBtn = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        removeBtn.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetList = driver.findElement(By.xpath("//button[text()='Reset List']"));
        resetList.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearAllFieldBtn = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        clearAllFieldBtn.click();

    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement enterName = driver.findElement(By.id("name"));
        Assert.assertTrue(enterName.getText().isEmpty());

        WebElement enterSurname = driver.findElement(By.id("surname"));
        Assert.assertTrue(enterSurname.getText().isEmpty());

        WebElement enterJob = driver.findElement(By.id("job"));
        Assert.assertTrue(enterJob.getText().isEmpty());

        WebElement dateOfBirtField = driver.findElement(By.id("dob"));
        Assert.assertTrue(dateOfBirtField.getText().isEmpty());

        List<WebElement> checkboxList = driver.findElements(By.className("w3-check"));
        for (WebElement checkbox : checkboxList) {
            if (checkbox.getAttribute("id").equals("english")) {
                Assert.assertTrue(checkbox.isSelected());
            } else
                Assert.assertFalse(checkbox.isSelected());
        }

        WebElement genderBtn = driver.findElement(By.xpath("//input[@type='radio']"));
        Assert.assertFalse(genderBtn.isSelected());

        WebElement employeeStatusDropDown = driver.findElement(By.id("status"));
        Select dropdown = new Select(employeeStatusDropDown);
        Assert.assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }
}
