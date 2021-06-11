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

public class Task2 {
    private WebDriver driver;

    public Task2() {
        this.driver = Hooks.driver;
    }
    @Given("^I am on Employee page$")
    public void i_am_on_Employee_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
        WebElement addPerson = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        addPerson.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(arg1);

        WebElement lastName = driver.findElement(By.id("surname"));
        lastName.sendKeys(arg2);

        WebElement job = driver.findElement(By.id("job"));
        job.sendKeys(arg3);

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.sendKeys(arg4 + Keys.TAB);

        WebElement checkBox = driver.findElement(By.id(arg5));
        if(!checkBox.isSelected()){
            checkBox.click();}

        WebElement radioBtn = driver.findElement(By.id(arg6));
        radioBtn.click();

        WebElement dropDown = driver.findElement(By.name("option"));
        Select dropD = new Select(dropDown);
        dropD.selectByVisibleText(arg7);

    }
    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addBtn = driver.findElement(By.xpath("//button[@onclick='addPersonToList()']"));
        addBtn.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtnP = driver.findElement(By.xpath("//span[contains(@onclick,'openModalForEditPerson(0)')]"));
        editBtnP.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys(arg1);

        WebElement lastName = driver.findElement(By.id("surname"));
        lastName.clear();
        lastName.sendKeys(arg2);

        WebElement job = driver.findElement(By.id("job"));
        job.clear();
        job.sendKeys(arg3);

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.clear();
        dateOfBirth.sendKeys(arg4 + Keys.TAB);

        WebElement checkBox = driver.findElement(By.id(arg5));
        if(!checkBox.isSelected()){
            checkBox.click();  }

        WebElement genderBtn = driver.findElement(By.id(arg6));
        genderBtn.click();

        WebElement dropDown = driver.findElement(By.name("option"));
        Select dropD = new Select(dropDown);
        dropD.selectByVisibleText(arg7);

    }

    @When("^click on edit-button$")
    public void click_on_edit_button1() throws Throwable {
        WebElement editBtn = driver.findElement(By.id("modal_button"));
        editBtn.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement deleteBtn = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        deleteBtn.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetList = driver.findElement(By.xpath("//button[text()='Reset List']"));
        resetList.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearFields = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        clearFields.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        Assert.assertTrue(nameField.getText().isEmpty());

        WebElement lastName = driver.findElement(By.id("surname"));
        Assert.assertTrue(lastName.getText().isEmpty());

        WebElement job = driver.findElement(By.id("job"));
        Assert.assertTrue(job.getText().isEmpty());

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        Assert.assertTrue(dateOfBirth.getText().isEmpty());

        List<WebElement> checkBox = driver.findElements(By.className("w3-check"));
        for (WebElement elementName : checkBox)
        {
            if (elementName.getAttribute("id").equals("english"))
                Assert.assertTrue(elementName.isSelected());
            else
                Assert.assertFalse(elementName.isSelected());
        }

        List<WebElement>radioBtn = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement element : radioBtn) {
            Assert.assertFalse(element.isSelected());
        }

        WebElement dropDown = driver.findElement(By.id("status"));
        Select dropD = new Select(dropDown);
        Assert.assertEquals("Employee",dropD.getFirstSelectedOption().getText());
    }
}
