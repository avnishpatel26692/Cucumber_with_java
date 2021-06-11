package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task2Steps{
    private WebDriver driver;
    public Task2Steps() {
        this.driver = Hooks.driver;
    }


    @Given("^I am on Employee page$")
    public void i_am_on_Employee_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
        WebElement addPerson = driver.findElement(By.xpath("//button[text()='Add person']"));
        addPerson.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement fillName = driver.findElement(By.id("name"));
        fillName.sendKeys(arg1);
        WebElement fillSurname = driver.findElement(By.id("surname"));
        fillSurname.sendKeys(arg2);
        WebElement fillJob = driver.findElement(By.id("job"));
        fillJob.sendKeys(arg3);
        WebElement dataEnter = driver.findElement(By.id("dob"));
        dataEnter.click();

        WebElement checkbox = driver.findElement(By.id(arg5));
        if(!checkbox.isSelected())
        { checkbox.click(); }

        List<WebElement> radioBtns = driver.findElements(By.id(arg6));
        for (WebElement radio : radioBtns) {
            radio.click();}
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='status']"));
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(arg7);
        }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addNew = driver.findElement(By.xpath("//button[text()='Add']"));
        addNew.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtn = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editBtn.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement fillName = driver.findElement(By.id("name"));
        fillName.clear();
        fillName.sendKeys(arg1);
        WebElement fillSurname = driver.findElement(By.id("surname"));
        fillSurname.clear();
        fillSurname.sendKeys(arg2);
        WebElement fillJob = driver.findElement(By.id("job"));
        fillJob.clear();
        fillJob.sendKeys(arg3);
        WebElement dataEnter = driver.findElement(By.id("dob"));
        dataEnter.click();
        WebElement checkbox = driver.findElement(By.id(arg5));
        if(!checkbox.isSelected())
        { checkbox.click(); }
        List<WebElement> radioBtns = driver.findElements(By.id(arg6));
        for (WebElement radio : radioBtns) {
            radio.click();}
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='status']"));
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(arg7);

    }

    @When("^click on edit-button$")
    public void click_on_edit_button1() throws Throwable {
        WebElement editNewPerson = driver.findElement (By.xpath("//button[text()='Edit']"));
        editNewPerson.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement deletePerson = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        deletePerson.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetList = driver.findElement(By.xpath("//button[text()='Reset List']"));
        resetList.click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearBtn = driver.findElement(By.xpath("//button[text()='Clear all fields']"));
        clearBtn.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement fillName = driver.findElement(By.id("name"));
        Assert.assertTrue(fillName.getText().isEmpty());
        WebElement fillSurname = driver.findElement(By.id("surname"));
        Assert.assertTrue(fillSurname.getText().isEmpty());
        WebElement fillJob = driver.findElement(By.id("job"));
        Assert.assertTrue(fillJob.getText().isEmpty());
        WebElement dataEnter = driver.findElement(By.id("dob"));
        Assert.assertTrue(dataEnter.getText().isEmpty());
        List<WebElement> checkbox = driver.findElements(By.className("w3-check"));
        for(WebElement elementName : checkbox){
            if (elementName.getAttribute("id").equals("english"))
                Assert.assertTrue(elementName.isSelected());
            else
                Assert.assertFalse(elementName.isSelected());
        }
        List<WebElement> radioBtns = driver.findElements(By.className("w3-radio"));
        for(WebElement elementName : radioBtns){
            Assert.assertFalse(elementName.isSelected());
            WebElement dropDown = driver.findElement(By.id("status"));
            Select dropDownAgn = new Select(dropDown);
            Assert.assertEquals("Employee",dropDownAgn.getFirstSelectedOption().getText());

        }
    }

}
