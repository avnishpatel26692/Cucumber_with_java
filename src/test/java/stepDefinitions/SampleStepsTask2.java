package stepDefinitions;

import PageObjects.AgePO;
import PageObjects.AgeSubmittedPO;
import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        WebElement addPersonButton = driver.findElement(By.xpath("//button[@id='addPersonBtn']"));
        addPersonButton.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameInputField = driver.findElement(By.id("name"));
        nameInputField.clear();
        nameInputField.sendKeys(arg1);
        WebElement surnameInputField = driver.findElement(By.id("surname"));
        surnameInputField.clear();
        surnameInputField.sendKeys(arg2);
        WebElement jobInputField = driver.findElement(By.id("job"));
        jobInputField.clear();
        jobInputField.sendKeys(arg3);
        WebElement dateOfBirthInputField = driver.findElement(By.id("dob"));
        dateOfBirthInputField.clear();
        dateOfBirthInputField.sendKeys(arg4);

        WebElement checkBoxEnglish = driver.findElement(By.xpath("//input[@id='english']"));
        WebElement checkBoxFrench = driver.findElement(By.xpath("//input[@id='french']"));
        WebElement checkBoxSpanish = driver.findElement(By.xpath("//input[@id='spanish']"));
        List<WebElement> checkBoxes = new ArrayList<>();
        checkBoxes.add(checkBoxEnglish);
        checkBoxes.add(checkBoxFrench);
        checkBoxes.add(checkBoxSpanish);
        for (WebElement nextCheckBox : checkBoxes) {
            if (nextCheckBox.isSelected()) {
                nextCheckBox.click();
            }
        }
        String xPath = "//input[@id='" + arg5 + "']";
        WebElement checkBox = driver.findElement(By.xpath(xPath));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        xPath = "//input[@id='" + arg6 + "']";
        WebElement radioButton = driver.findElement(By.xpath(xPath));
        radioButton.click();
        WebElement dropDownList = driver.findElement(By.xpath("//select[@id='status']"));
        Select dropdown = new Select(dropDownList);
        dropdown.selectByVisibleText(arg7);
    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addPersonToList()']"));
        addButton.click();
    }

    @When("^click on edit-button$")
    public void click_on_edit_button() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]"));
        addButton.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameInputField = driver.findElement(By.id("name"));
        nameInputField.clear();
        nameInputField.sendKeys(arg1);
        WebElement surnameInputField = driver.findElement(By.id("surname"));
        surnameInputField.clear();
        surnameInputField.sendKeys(arg2);
        WebElement jobInputField = driver.findElement(By.id("job"));
        jobInputField.clear();
        jobInputField.sendKeys(arg3);
        WebElement dateOfBirthInputField = driver.findElement(By.id("dob"));
        dateOfBirthInputField.clear();
        dateOfBirthInputField.sendKeys(arg4);

        String xPath = "//input[@id='" + arg5 + "']";
        WebElement checkBox = driver.findElement(By.xpath(xPath));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        xPath = "//input[@id='" + arg6 + "']";
        WebElement radioButton = driver.findElement(By.xpath(xPath));
        radioButton.click();
        WebElement dropDownList = driver.findElement(By.xpath("//select[@id='status']"));
        Select dropdown = new Select(dropDownList);
        dropdown.selectByVisibleText(arg7);
    }

    @When("^click on edit button$")
    public void click_on_editbutton1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement addButton = driver.findElement(By.xpath("//button[contains(@onclick,'editPerson(3)')]"));
        addButton.click();

    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("//span[contains(@onclick,'deletePerson(3)')]"));
        addButton.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("//button[contains(@onclick,'resetListOfPeople()')]"));
        addButton.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement addPersonButton = driver.findElement(By.xpath("//button[contains(@onclick,'openModalForAddPerson()')]"));
        addPersonButton.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement nameInputField = driver.findElement(By.id("name"));
        Assert.assertTrue(nameInputField.getText().isEmpty());
        WebElement surnameInputField = driver.findElement(By.id("surname"));
        Assert.assertTrue(surnameInputField.getText().isEmpty());
        WebElement jobInputField = driver.findElement(By.id("job"));
        Assert.assertTrue(jobInputField.getText().isEmpty());
        WebElement dateOfBirthInputField = driver.findElement(By.id("dob"));
        Assert.assertTrue(dateOfBirthInputField.getText().isEmpty());
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='english']"));
        Assert.assertTrue(checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='french']"));
        Assert.assertFalse(checkBox2.isSelected());
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='spanish']"));
        Assert.assertFalse(checkBox3.isSelected());
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@id='male']"));
        Assert.assertFalse(radioButton1.isSelected());
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@id='female']"));
        Assert.assertFalse(radioButton2.isSelected());
        WebElement dropDownList = driver.findElement(By.xpath("//select[@id='status']"));
        Select dropdown = new Select(dropDownList);
        Assert.assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }
}
