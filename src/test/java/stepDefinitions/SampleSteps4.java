package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        for(String checkBoxValue : arg1)
        {
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
        Assert.assertEquals(arg1,actualMsg );
    }

    @When("^user enters details$")
    public void user_enters_details(Map<String, String> arg1) throws Throwable {
        for(Map.Entry<String, String> txtbox: arg1.entrySet())
        {
            String key = txtbox.getKey(); //name
            String value = txtbox.getValue(); //ABC
            WebElement textbox = driver.findElement(By.id(key));
            textbox.clear();
            textbox.sendKeys(value);
        }
    }

    @Given("^I have the following order$")
    public void i_have_the_following_order(DataTable arg1) throws Throwable {
        for(Map<String, String> map : arg1.asMaps(String.class, String.class))
        {
            String vegetableName =  map.get("vegetable"); //cucumber
            String quantity = map.get("quantity"); // 4
            String cost = map.get("cost"); //10
            String availability = map.get("Availability"); // yes
            System.out.println("========================");
            System.out.println("Vegetable: "  + vegetableName);
            System.out.println("Quantity: "  + quantity);
            System.out.println("Cost: "  + cost);
            System.out.println("Availability: "  + availability);
            System.out.println("========================");
        }
    }
////////////////////////////////  TASK 2

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
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys(arg1);

        WebElement surnameBox = driver.findElement(By.id("surname"));
        surnameBox.sendKeys(arg2);

        WebElement jobBox = driver.findElement(By.id("job"));
        jobBox.sendKeys(arg3);

        WebElement dobBox = driver.findElement(By.id("dob"));
        dobBox.sendKeys(arg4+ Keys.TAB);

        WebElement lang = driver.findElement(By.id(arg5));
        if(!lang.isSelected()){
            lang.click();
        }

        WebElement gender = driver.findElement(By.id(arg6));
        gender.click();

        WebElement empStatus = driver.findElement(By.id("status"));
        Select select = new Select(empStatus);
        select.selectByVisibleText(arg7);

    }

    @Then("^click button add$")
    public void click_button_add() throws Throwable {

        WebElement addPersonBtn = driver.findElement(By.xpath("//button[text()='Add']"));
        addPersonBtn.click();

    }

    @When("^click on edit button$")
    public void click_on_edit_button() throws Throwable {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]']")));
        WebElement editPersonBtn = driver.findElement(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]"));
        editPersonBtn.click();
    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {

        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.clear();
        nameBox.sendKeys(arg1);

        WebElement surnameBox = driver.findElement(By.id("surname"));
        surnameBox.clear();
        surnameBox.sendKeys(arg2);

        WebElement jobBox = driver.findElement(By.id("job"));
        jobBox.clear();
        jobBox.sendKeys(arg3);

        WebElement dobBox = driver.findElement(By.id("dob"));
        dobBox.clear();
        dobBox.sendKeys(arg4+ Keys.TAB);



        WebElement langEnglish = driver.findElement(By.id("english"));
        if(langEnglish.isSelected()) langEnglish.click();

        WebElement langFrench = driver.findElement(By.id("french"));
        if(langFrench.isSelected()) langFrench.click();

        WebElement langSpanish = driver.findElement(By.id("spanish"));
        if(langSpanish.isSelected()) langSpanish.click();

        WebElement lang = driver.findElement(By.id(arg5));

        WebElement genderMale = driver.findElement(By.id("male"));
        if(genderMale.isSelected()) genderMale.click();

        WebElement genderFemale = driver.findElement(By.id("female"));
        if(genderFemale.isSelected()) genderFemale.click();

        WebElement gender = driver.findElement(By.id(arg6));
        gender.click();

        WebElement empStatus = driver.findElement(By.id("status"));
        Select select = new Select(empStatus);
        select.selectByVisibleText(arg7);


    }

    @When("^click on edit-button$")
    public void click_on_edit_button2() throws Throwable {
        WebElement editPersonBtn = driver.findElement(By.xpath("//button[text()='Edit']"));
        editPersonBtn.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement deletePersonBtn = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        deletePersonBtn.click();
    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement deletePersonBtn = driver.findElement(By.xpath("//button[text()='Reset List']"));
        deletePersonBtn.click();

    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement clearAllFieldsBtn = driver.findElement(By.xpath("//button[text()='Clear all fields']"));
        clearAllFieldsBtn.click();
    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameBox = driver.findElement(By.id("name"));
        Assert.assertTrue(nameBox.getText().isEmpty());

        WebElement surnameBox = driver.findElement(By.id("surname"));
        Assert.assertTrue(surnameBox.getText().isEmpty());

        WebElement jobBox = driver.findElement(By.id("job"));
        Assert.assertTrue(jobBox.getText().isEmpty());

        WebElement dobBox = driver.findElement(By.id("dob"));
        Assert.assertTrue(dobBox.getText().isEmpty());

        WebElement langEnglish = driver.findElement(By.id("english"));
        Assert.assertTrue(langEnglish.isSelected());

        WebElement langFrench = driver.findElement(By.id("french"));
        Assert.assertFalse(langFrench.isSelected());

        WebElement langSpanish = driver.findElement(By.id("spanish"));
        Assert.assertFalse(langSpanish.isSelected());

        WebElement genderMale = driver.findElement(By.id("male"));
        Assert.assertFalse(genderMale.isSelected());

        WebElement genderFemale = driver.findElement(By.id("female"));
        Assert.assertFalse(genderFemale.isSelected());

        WebElement empStatus = driver.findElement(By.id("status"));
        Select select = new Select(empStatus);
        String actualValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Employee", actualValue);

    }

}
