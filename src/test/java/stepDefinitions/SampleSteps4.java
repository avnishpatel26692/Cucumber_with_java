package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SampleSteps4 {
        private WebDriver driver;
    private Object DataTable;

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
            WebElement msg;
            msg = driver.findElement(By.id("result_checkbox"));
            String actualMsg = msg.getText();
            Assert.assertEquals(arg1,actualMsg );
        }
    @When("^user enters details$")
    public void user_enters_details(Map<String, String> arg1) throws Throwable {
        for (Map.Entry<String, String> txtbox : arg1.entrySet()) {
            String key = txtbox.getKey(); //1st time : name, 2nd time :age
            String value = txtbox.getValue(); //1st time: ABC, 2nd time "5
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
    @Given("^I am on Employee page$")
    public void i_am_on_Employee_page() throws Throwable {
       driver.get("https://kristinek.github.io/site/tasks/list_of_people");

    }

    @When("^click on Add person$")
    public void click_on_Add_person() throws Throwable {
       WebElement AddPersn = driver.findElement(By.id("addPersonBtn"));
        AddPersn.click();
    }

    @When("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fill_all_fields(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
      WebElement nameTextbox = driver.findElement(By.id("name"));
      nameTextbox.sendKeys(arg1);
      WebElement SurnTextbox = driver.findElement(By.id("surname"));
      SurnTextbox.sendKeys(arg2);
      WebElement JobTextbox = driver.findElement(By.id("job"));
      JobTextbox.sendKeys(arg3);
      WebElement DateTextbox = driver.findElement(By.id("dob"));
      DateTextbox.sendKeys(arg4+ Keys.TAB);
      WebElement CheckBox = driver.findElement(By.id(arg5));
      if(!CheckBox.isSelected()){
          CheckBox.click();}

          WebElement radioBtn1 = driver.findElement(By.id(arg6));
          radioBtn1.click();
        WebElement dropDownBox = driver.findElement(By.id("status"));
        Select dropdownSelect = new Select(dropDownBox);
        dropdownSelect.selectByVisibleText(arg7);

      }



    @Then("^click button add$")
    public void click_button_add() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("modal_button")));
    WebElement AddBtn = driver.findElement(By.id("modal_button"));
    AddBtn.click();
    }

    @When("^click on edit button$")
    public void click_on_edit_button1() throws Throwable {
        WebElement EditBtn = driver.findElement(By.xpath("//span[contains(@onclick,'openModalForEditPerson(3)')]"));
        EditBtn.click();

    }

    @When("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void edit_something(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
        nameTextbox.clear();
        nameTextbox.sendKeys(arg1);
        WebElement SurnTextbox = driver.findElement(By.id("surname"));
        SurnTextbox.clear();
        SurnTextbox.sendKeys(arg2);
        WebElement JobTextbox = driver.findElement(By.id("job"));
        JobTextbox.clear();
        JobTextbox.sendKeys(arg3);
        WebElement DateTextbox = driver.findElement(By.id("dob"));
        DateTextbox.clear();
        DateTextbox.sendKeys(arg4+Keys.TAB);
        WebElement CheckBox = driver.findElement(By.id(arg5));
        if(!CheckBox.isSelected()){
            CheckBox.click();}

        WebElement radioBtn1 = driver.findElement(By.id(arg6));
        radioBtn1.click();
        WebElement dropDownBox = driver.findElement(By.id("status"));
        Select dropdownSelect = new Select(dropDownBox);
        dropdownSelect.selectByVisibleText(arg7);

    }

    @When("^click on edit-button$")
    public void click_on_edit_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement editBtn = driver.findElement(By.id("modal_button"));
        editBtn.click();
    }

    @When("^remove a person$")
    public void remove_a_person() throws Throwable {
        WebElement RemoveBtn = driver.findElement(By.xpath("//span[@onclick='deletePerson(3)']"));
        RemoveBtn.click();

    }

    @Then("^reset list$")
    public void reset_list() throws Throwable {
        WebElement ResetBtn = driver.findElement(By.xpath("//button[text()='Reset List']"));
        ResetBtn.click();

    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
        WebElement ClearBtn = driver.findElement(By.xpath("//button[text()='Clear all fields']"));
        ClearBtn.click();


    }

    @Then("^check empty fields$")
    public void check_empty_fields() throws Throwable {
        WebElement nameTextbox = driver.findElement(By.id("name"));
       Assert.assertTrue(nameTextbox.getText().isEmpty());
        WebElement SurnTextbox = driver.findElement(By.id("surname"));
        Assert.assertTrue(SurnTextbox.getText().isEmpty());
        WebElement JobTextbox = driver.findElement(By.id("job"));
        Assert.assertTrue(JobTextbox.getText().isEmpty());
        WebElement DateTextbox = driver.findElement(By.id("dob"));
        Assert.assertTrue(DateTextbox.getText().isEmpty());
       List<WebElement> checkboxes = driver.findElements(By.className("w3-check"));
        for(WebElement elementName : checkboxes)
        {
            if (elementName.getAttribute("id").equals("english"))
                Assert.assertTrue(elementName.isSelected());
            else
                Assert.assertFalse(elementName.isSelected());
        }

       List<WebElement> radioBtns = driver.findElements(By.className("w3-radio"));
      for (WebElement radioBtn : radioBtns) {
          Assert.assertFalse(radioBtn.isSelected());
          WebElement DropDown = driver.findElement(By.id("status"));
          Select DropDown1 = new Select(DropDown);
          Assert.assertEquals("Employee", DropDown1.getFirstSelectedOption().getText());
      }}}






    

