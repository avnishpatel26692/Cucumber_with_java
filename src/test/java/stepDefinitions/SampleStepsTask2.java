package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
        WebElement addPersonButton = driver.findElement(By.id("addPersonBtn"));
        addPersonButton.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys(arg1);

        WebElement surnameField = driver.findElement(By.id("surname"));
        nameField.clear();
        surnameField.sendKeys(arg2);

        WebElement jobField = driver.findElement(By.id("job"));
        nameField.clear();
        jobField.sendKeys(arg3);

        WebElement dateOfBirthField = driver.findElement(By.id("dob"));
        nameField.clear();
        dateOfBirthField.sendKeys(arg4);

        WebElement languageCheckBox = driver.findElement(By.id(arg5));
        if (!languageCheckBox.isSelected()) {
            languageCheckBox.click();
        }

        WebElement genderCheckBox = driver.findElement(By.id(arg6));
        nameField.clear();
        genderCheckBox.click();

        WebElement employeeDropDownStatus = driver.findElement(By.id("status"));
        Select select = new Select(employeeDropDownStatus);
        select.selectByVisibleText(arg7);
    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addButton = driver.findElement(By.id("modal_button"));
        addButton.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editButton = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editButton.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys(arg1);

        WebElement surnameField = driver.findElement(By.id("surname"));
        surnameField.clear();
        surnameField.sendKeys(arg2);

        WebElement jobField = driver.findElement(By.id("job"));
        jobField.clear();
        jobField.sendKeys(arg3);

        WebElement dateOfBirthField = driver.findElement(By.id("dob"));
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(arg4);

        WebElement languageCheckBox = driver.findElement(By.id(arg5));
        if (!languageCheckBox.isSelected()) {
            languageCheckBox.click();
        }

        WebElement genderCheckBox = driver.findElement(By.id(arg6));
        genderCheckBox.click();

        WebElement employeeDropDownStatus = driver.findElement(By.id("status"));
        Select select = new Select(employeeDropDownStatus);
        select.selectByVisibleText(arg7);
    }

    @When("^click on edit-button$")
    public void click_on_edit_button_again() throws Throwable {
        WebElement editButton = driver.findElement(By.xpath("//button[text()='Edit']"));
        editButton.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement removeButton = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        removeButton.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement reset = driver.findElement(By.xpath("//button[text()='Reset List']"));
        reset.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clear = driver.findElement(By.xpath("//button[text()='Clear all fields']"));
        clear.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        Assert.assertEquals("", nameField.getText());

        WebElement surnameField = driver.findElement(By.id("surname"));
        Assert.assertEquals("", surnameField.getText());

        WebElement jobField = driver.findElement(By.id("job"));
        Assert.assertEquals("", jobField.getText());

        WebElement dateOfBirthField = driver.findElement(By.id("dob"));
        Assert.assertEquals("", dateOfBirthField.getText());

        WebElement languageCheckBox1 = driver.findElement(By.id("english"));
        Assert.assertTrue(languageCheckBox1.isSelected());
        WebElement languageCheckBox2 = driver.findElement(By.id("french"));
        Assert.assertFalse(languageCheckBox2.isSelected());
        WebElement languageCheckBox3 = driver.findElement(By.id("spanish"));
        Assert.assertFalse(languageCheckBox3.isSelected());

        WebElement genderCheckBox1 = driver.findElement(By.id("male"));
        Assert.assertFalse(genderCheckBox1.isSelected());
        WebElement genderCheckBox2 = driver.findElement(By.id("female"));
        Assert.assertFalse(genderCheckBox2.isSelected());

        WebElement employeeDropDownStatus = driver.findElement(By.xpath("//option[text()='Employee']"));
        Assert.assertTrue(employeeDropDownStatus.isSelected());
    }

}
