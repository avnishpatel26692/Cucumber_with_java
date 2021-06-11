package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class Task2Steps {
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
        WebElement addPersonButton = driver.findElement(By.xpath("//button[contains(text(),'Add person')]"));
        addPersonButton.click();

    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement namefield = driver.findElement(By.cssSelector("input#name"));
        namefield.sendKeys(arg1);
        WebElement surnamefield = driver.findElement(By.cssSelector("input#surname"));
        surnamefield.sendKeys(arg2);
        WebElement jobfield = driver.findElement(By.cssSelector("input#job"));
        jobfield.sendKeys(arg3);
        WebElement dob = driver.findElement(By.cssSelector("input#dob"));
        dob.sendKeys(""+arg4+Keys.TAB);
        WebElement checkbox = driver.findElement(By.id(arg5));
        if (!checkbox.isSelected())
        {
            checkbox.click();
        }
        WebElement radiobutton = driver.findElement(By.id(arg6));
        if (!radiobutton.isSelected())
        {
            radiobutton.click();
        }
        WebElement dropdown = driver.findElement(By.cssSelector("select#status"));
        Select dropdown1 = new Select(dropdown);
        dropdown1.selectByVisibleText(arg7);

    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {
    WebElement Addbutt = driver.findElement(By.xpath("//button[@id='modal_button'][1]"));
    Addbutt.click();

    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
        WebElement editpencil = driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(3)']"));
        editpencil.click();

    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement namefield = driver.findElement(By.cssSelector("input#name"));
        namefield.clear();
        namefield.sendKeys(arg1);

        WebElement surnamefield = driver.findElement(By.cssSelector("input#surname"));
        surnamefield.clear();
        surnamefield.sendKeys(arg2);

        WebElement jobfield = driver.findElement(By.cssSelector("input#job"));
        jobfield.clear();
        jobfield.sendKeys(arg3);

        WebElement dob = driver.findElement(By.cssSelector("input#dob"));
        dob.clear();
        dob.sendKeys(""+arg4+Keys.TAB);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement elementName : checkboxes){
        if (elementName.isSelected()) {
            elementName.click();
        }  }
        WebElement checkbox = driver.findElement(By.id(arg5));
            checkbox.click();


        WebElement radiobutton = driver.findElement(By.id(arg6));
            radiobutton.click();

        WebElement dropdown = driver.findElement(By.cssSelector("select#status"));
        Select dropdown1 = new Select(dropdown);
        dropdown1.selectByVisibleText(arg7);

    }

    @When("^click on huge edit button$")
    public void click_on_huge_edit_button() throws Throwable {
    WebElement hugeedit = driver.findElement(By.xpath("//button[@id='modal_button'][1]"));
    hugeedit.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement removeButt = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        removeButt.click();

    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement resetbutt = driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']"));
        resetbutt.click();

    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearbutt = driver.findElement(By.cssSelector("button#addPersonBtn"));
        clearbutt.click();


    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement namefield = driver.findElement(By.cssSelector("input#name"));
        Assert.assertTrue(namefield.getText().isEmpty());

        WebElement surnamefield = driver.findElement(By.cssSelector("input#surname"));
        Assert.assertTrue(surnamefield.getText().isEmpty());

        WebElement jobfield = driver.findElement(By.cssSelector("input#job"));
        Assert.assertTrue(jobfield.getText().isEmpty());

        WebElement dob = driver.findElement(By.cssSelector("input#dob"));
        Assert.assertTrue(dob.getText().isEmpty());



        List<WebElement>chechboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
       for (WebElement element: chechboxes)
       {
           if(element.getAttribute("id").equals("english"))
               Assert.assertTrue(element.isSelected());
           else{
               Assert.assertFalse(element.isSelected());
           }
       }

        List<WebElement> radiobuttons = driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement elementName : radiobuttons)
            assertFalse(elementName.isSelected());

        WebElement dropdown = driver.findElement(By.cssSelector("select#status"));
        Select dropdown1 = new Select(dropdown);
        Assert.assertEquals("Employee",dropdown1.getFirstSelectedOption().getText());


    }



}
