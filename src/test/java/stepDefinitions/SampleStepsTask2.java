package stepDefinitions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.TAB;

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
        WebElement clickOnAddPerson = driver.findElement(By.xpath("//button[contains(text(),'Add person')]"));
        clickOnAddPerson.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(arg1);
        WebElement surnameField = driver.findElement(By.id("surname"));
        surnameField.sendKeys(arg2);
        WebElement jobField = driver.findElement(By.id("job"));
        jobField.sendKeys(arg3);
        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys(arg4 + TAB);
        WebElement checkField = driver.findElement(By.id(arg5));
        if (!checkField.isSelected()) {
            checkField.click();
        }
        WebElement radioButton = driver.findElement(By.id(arg6));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
        WebElement employeeField = driver.findElement(By.id("status"));
        Select dropdown = new Select(employeeField);
        dropdown.selectByVisibleText(arg7);
    }


    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement clickOnAddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        clickOnAddButton.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]")));
        WebElement editButton = driver.findElement(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]"));
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
        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.clear();
        dobField.sendKeys(arg4 + TAB);
        WebElement checkField = driver.findElement(By.id(arg5));
        if(!checkField.isSelected())
        {
            checkField.click();
        }
        WebElement radioButton = driver.findElement(By.id(arg6));
        if(!radioButton.isSelected())
        {
            radioButton.click();
        }
        WebElement employeeField = driver.findElement(By.id("status"));
        Select dropdown = new Select(employeeField);
        dropdown.selectByVisibleText(arg7);
    }
//    @When("^click on edit-button$")
//    public void click_on_edit_button() throws Throwable {


    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        List<WebElement> removeButton = driver.findElements(By.xpath("//*[contains(@class,'x')]"));
        for (WebElement removeName : removeButton){
          removeButton.get(3).click();
        }
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetButton = driver.findElement(By.xpath("/html/body/div[2]/button[2]"));
        resetButton.click();
    }

    @When("^click on edit-button$")
    public void click_on_edit_button1(){
        driver.findElement(By.id("modal_button")).click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearButton = driver.findElement(By.xpath("//button[contains(text(),'Clear all fields')]"));
        clearButton.click();

    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameField = driver.findElement(By.id("name"));
        Assert.assertTrue(nameField.getText().isEmpty());
        WebElement surnameField = driver.findElement(By.id("surname"));
        Assert.assertTrue(surnameField.getText().isEmpty());
        WebElement jobField = driver.findElement(By.id("job"));
        Assert.assertTrue(jobField.getText().isEmpty());
        WebElement dobField = driver.findElement(By.id("dob"));
        Assert.assertTrue(dobField.getText().isEmpty());
        List<WebElement> checkboxField = driver.findElements(By.className("w3-check"));
        for(WebElement elementName : checkboxField){
            if (elementName.getAttribute("id").equals("english"))
                Assert.assertTrue(elementName.isSelected());
            else
                Assert.assertFalse(elementName.isSelected());
        }
        List<WebElement> radioField = driver.findElements(By.className("w3-radio"));
        for (WebElement radioFld : radioField){
            Assert.assertFalse(radioFld.isSelected());
        }
        WebElement employeeField = driver.findElement(By.id("status"));
        Select dropdown = new Select(employeeField);
        Assert.assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }
}
