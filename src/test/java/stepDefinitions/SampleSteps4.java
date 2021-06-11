package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class SampleSteps4 {
    private WebDriver driver;

    public SampleSteps4() {
        this.driver = Hooks.driver;
    }

    @Given("^user navigates to action page$")
    public void user_navigates_to_action_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^user clicks on checkboxes$")
    public void user_clicks_on_checkboxes(List<String> arg1) throws Throwable {
        for (String checkBoxValue : arg1) {
            String checkboxXpath = "//input[@value='" + checkBoxValue + "']";
            WebElement checkbox = driver.findElement(By.xpath(checkboxXpath));
            checkbox.click();
        }
    }

    @When("^user clicked on result checkbox button$")
    public void user_clicked_on_result_checkbox_button() throws Throwable {
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
        for (Map.Entry<String, String> txtbox : arg1.entrySet()) {
            String key = txtbox.getKey(); //1st time : name 2nd time : age
            String value = txtbox.getValue(); //1st time: Abc 2nd time 5
            WebElement textbox = driver.findElement(By.id(key));
            textbox.clear();
            textbox.sendKeys(value);
        }

    }

    @Given("^I have the following order$")
    public void i_have_the_following_order(DataTable arg1) throws Throwable {
        for (Map<String, String> map : arg1.asMaps(String.class, String.class)) {
            String vegetableName = map.get("vegetable"); //cucumber
            String quantity = map.get("quantity"); // 4
            String cost = map.get("cost"); //10
            String availability = map.get("Availability"); // yes
            System.out.println("========================");
            System.out.println("Vegetable: " + vegetableName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Cost: " + cost);
            System.out.println("Availability: " + availability);
            System.out.println("========================");
        }

//    Steps Task 2

    }

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
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.sendKeys(arg1);
        WebElement surNameTextbox = driver.findElement(By.id("surname"));
        surNameTextbox.sendKeys(arg2);
        WebElement jobTextbox = driver.findElement(By.id("job"));
        jobTextbox.sendKeys(arg3);
        WebElement dobTextbox = driver.findElement(By.id("dob"));
        dobTextbox.sendKeys(arg4 + Keys.TAB);
        WebElement checkBox = driver.findElement(By.id(arg5));
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        WebElement radioBtn = driver.findElement(By.id(arg6));
        radioBtn.click();
        WebElement emplDropDownList = driver.findElement(By.id("status"));
        Select dropDown = new Select(emplDropDownList);
        dropDown.selectByVisibleText(arg7);
    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addBtn = driver.findElement(By.id("modal_button"));
        addBtn.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button1() throws Throwable {
        WebElement editBtn = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editBtn.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
        WebElement surNameTextbox = driver.findElement(By.id("surname"));
        surNameTextbox.clear();
        surNameTextbox.sendKeys(arg2);
        WebElement jobTextbox = driver.findElement(By.id("job"));
        jobTextbox.clear();
        jobTextbox.sendKeys(arg3);
        WebElement dobTextbox = driver.findElement(By.id("dob"));
        dobTextbox.clear();
        dobTextbox.sendKeys(arg4 + Keys.TAB);
        WebElement checkBox = driver.findElement(By.id(arg5));
        checkBox.click();
        WebElement genderDropDown = driver.findElement(By.id(arg6));
genderDropDown.click();
        WebElement empStatus = driver.findElement(By.id("status"));
        Select dropDown = new Select(empStatus);
        dropDown.selectByVisibleText(arg7);

    }

    @When("^click on edit-button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtn1 = driver.findElement(By.id("modal_button"));
        editBtn1.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement removeBtn = driver.findElement(By.xpath("//span[contains(@onclick,'deletePerson(3)')]"));
        removeBtn.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetBtn = driver.findElement(By.xpath("//button[contains(@onclick,'resetListOfPeople()')]"));
        resetBtn.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearBtn = driver.findElement(By.xpath("//button[contains(@onclick,'openModalForAddPerson()')]"));
        clearBtn.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameInputField = driver.findElement(By.id("name"));
        Assert.assertTrue(nameInputField.getText().isEmpty());
        WebElement surnameInputField = driver.findElement(By.id("surname"));
        Assert.assertTrue(surnameInputField.getText().isEmpty());
        WebElement jobInputField = driver.findElement(By.id("job"));
        Assert.assertTrue(jobInputField.getText().isEmpty());
        WebElement dateOfBirthInputField = driver.findElement(By.id("dob"));
        Assert.assertTrue(dateOfBirthInputField.getText().isEmpty());
        WebElement checkBox1 = driver.findElement(By.id("english"));
        Assert.assertTrue(checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.id("french"));
        Assert.assertFalse(checkBox2.isSelected());
        WebElement checkBox3 = driver.findElement(By.id("spanish"));
        Assert.assertFalse(checkBox3.isSelected());
        WebElement radioBtn1 = driver.findElement(By.id("male"));
        Assert.assertFalse(radioBtn1.isSelected());
        WebElement radioBtn2 = driver.findElement(By.id("female"));
        Assert.assertFalse(radioBtn2.isSelected());
        WebElement dropDownList = driver.findElement(By.id("status"));
        Select dropdown = new Select(dropDownList);
        Assert.assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }
}
