package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
        WebElement addBtn = driver.findElement(By.xpath("//button[@onclick='openModalForAddPerson()']"));
        addBtn.click();

    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameLine = driver.findElement(By.id("name"));
        nameLine.sendKeys(arg1);

        WebElement surnameLine = driver.findElement(By.id("surname"));
        surnameLine.sendKeys(arg2);

        WebElement jobLine = driver.findElement(By.id("job"));
        jobLine.sendKeys(arg3);

        WebElement dobLine = driver.findElement(By.id("dob"));
        dobLine.sendKeys(arg4);

        for(WebElement langCheckBox:driver.findElements(By.xpath("//input[@type='checkbox']"))){
            if(langCheckBox.isSelected()){
                langCheckBox.click();
            }
        }
        WebElement langCheckBox = driver.findElement(By.id(arg5));
        langCheckBox.click();

        WebElement genderRadio = driver.findElement(By.id(arg6));
        genderRadio.click();

        WebElement eStatus = driver.findElement(By.id("status"));
        Select select = new Select(eStatus);
        select.selectByVisibleText(arg7);



    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebElement addBtn = driver.findElement(By.id("modal_button"));
        addBtn.click();

    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editBtn = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editBtn.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameLine = driver.findElement(By.id("name"));
        nameLine.clear();
        nameLine.sendKeys(arg1);

        WebElement surnameLine = driver.findElement(By.id("surname"));
        surnameLine.clear();
        surnameLine.sendKeys(arg2);

        WebElement jobLine = driver.findElement(By.id("job"));
        jobLine.clear();
        jobLine.sendKeys(arg3);

        WebElement dobLine = driver.findElement(By.id("dob"));
        dobLine.clear();
        dobLine.sendKeys(arg4);

        for(WebElement langCheckBox:driver.findElements(By.xpath("//input[@type='checkbox']"))){
            if(langCheckBox.isSelected()){
                langCheckBox.click();
            }
        }
        WebElement langCheckBox = driver.findElement(By.id(arg5));
        langCheckBox.click();

        WebElement genderRadio = driver.findElement(By.id(arg6));
        genderRadio.click();

        WebElement eStatus = driver.findElement(By.id("status"));
        Select select = new Select(eStatus);
        select.selectByVisibleText(arg7);
    }


    @When("^click on edit-button2$")
    public void click_on_edit_button2() throws Throwable {
        WebElement editButton = driver.findElement(By.xpath("//button[@onclick='editPerson(3)']"));
        editButton.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement delete = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        delete.click();

    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement reset = driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']"));
        reset.click();

    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clear = driver.findElement(By.xpath("//div[contains(@class,'clear-btn')]/button"));
        clear.click();

    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
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