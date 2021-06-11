package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;

public class Task2SampleSteps {
    private WebDriver driver;

    public Task2SampleSteps(){
        this.driver = Hooks.driver;
    }
    @Given
            ("^I am on Employee page$")

    public void i_am_on_Employee_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When
            ("^click on Add person$")

    public void click_on_Add_person() throws Throwable {
        WebElement add = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        add.click();
    }

    @When
            ("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")

    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(arg1);

        WebElement surname = driver.findElement(By.id("surname"));
        surname.clear();
        surname.sendKeys(arg2);

        WebElement job = driver.findElement(By.id("job"));
        job.clear();
        job.sendKeys(arg3);

        WebElement dob = driver.findElement(By.id("dob"));
        dob.clear();
        dob.sendKeys(arg4);

        for(WebElement e:driver.findElements(By.xpath("//input[@type='checkbox']"))){
            if(e.isSelected()){
                e.click();
            }
        }

        WebElement checkbox = driver.findElement(By.id(arg5));
        checkbox.click();

        WebElement gender = driver.findElement(By.id(arg6));
        gender.click();

        WebElement status = driver.findElement(By.id("status"));
        Select select = new Select(status);
        select.selectByVisibleText(arg7);
    }

    @Then
            ("^click button add$")

    public void click_button_add() throws Throwable {
        WebElement add = driver.findElement(By.xpath("//button[@onclick='addPersonToList()']"));
        add.click();
    }

    @When
            ("^click on edit button$")

    public void click_on_edit_button() throws Throwable {
        WebElement edit = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        edit.click();
    }

    @When
            ("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")

    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(arg1);

        WebElement surname = driver.findElement(By.id("surname"));
        surname.clear();
        surname.sendKeys(arg2);

        WebElement job = driver.findElement(By.id("job"));
        job.clear();
        job.sendKeys(arg3);

        WebElement dob = driver.findElement(By.id("dob"));
        dob.clear();
        dob.sendKeys(arg4);

        for(WebElement e:driver.findElements(By.xpath("//input[@type='checkbox']"))){
            if(e.isSelected()){
                e.click();
            }
        }

        WebElement checkbox = driver.findElement(By.id(arg5));
        checkbox.click();

        WebElement gender = driver.findElement(By.id(arg6));
        gender.click();

        WebElement status = driver.findElement(By.id("status"));
        Select select = new Select(status);
        select.selectByVisibleText(arg7);
    }

    @When
            ("^click on edit-button 2$")


    public void click_on_edit_button_2() throws Throwable {
        WebElement edit = driver.findElement(By.xpath("//button[@onclick='editPerson(3)']"));
        edit.click();
    }

    @When
            ("^remove a person$")

    public void remove_a_person() throws Throwable {
        WebElement delete = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        delete.click();
    }

    @Then
            ("^reset list$")

    public void reset_list() throws Throwable {
        WebElement reset = driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']"));
        reset.click();
    }

    @And("^click clear-button$")
    public void clickClearButton() {
        WebElement clear = driver.findElement(By.xpath("//div[contains(@class,'clear-btn')]/button"));
        clear.click();
    }

    @Then
            ("^check empty fields$")

    public void checkEmptyFields() {
        WebElement name = driver.findElement(By.id("name"));
        Assert.assertEquals("",name.getText());

        WebElement surname = driver.findElement(By.id("surname"));
        Assert.assertEquals("",surname.getText());

        WebElement job = driver.findElement(By.id("job"));
        Assert.assertEquals("",job.getText());

        WebElement dob = driver.findElement(By.id("dob"));
        Assert.assertEquals("",dob.getText());

        for(WebElement e:driver.findElements(By.xpath("//input[@type='checkbox']"))){
            if(e.getAttribute("id").equals("english")){ Assert.assertTrue(e.isSelected()); }
            else Assert.assertFalse(e.isSelected());
        }

        for(WebElement e: driver.findElements(By.xpath("//input[@type='radio']"))){
            Assert.assertFalse(e.isSelected());
        }

        for(WebElement e: driver.findElements(By.xpath("//select[@id='status']/option"))){
            if(e.getAttribute("value").equals("employee")){Assert.assertTrue(e.isSelected());}
            else Assert.assertFalse(e.isSelected());
        }
    }

}