package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
    private WebDriver driver;
    static PersonList personList;
    static PersonAdd person;

    public Task2() {
        this.driver = Hooks.driver;
        personList = PageFactory.initElements(driver, PersonList.class);
        person = PageFactory.initElements(driver, PersonAdd.class);
    }

    @Given("^I am on Employee page$")
    public void iAmOnEmployeePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }


    @When("^click on Add person$")
    public void clickOnAddPerson() {
        personList.clickAddPersonButton();

    }

    @And("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fillAllFields(String name, String surname, String job, String birthday, String language, String gender, String status) throws Throwable {

        person.setName(name);
        person.setSurname(surname);
        person.setJob(job);
        person.setBirthday(birthday);
        person.setLanguage(language);
        person.setGender(gender);
        person.setEmployeeStatus(status);
    }

    @Then("^click button add$")
    public void clickButtonAdd() throws InterruptedException {
        person.getAddBtn().click();
        Thread.sleep(1000);
    }

    @When("^click on edit button$")
    public void clickOnEditButton() throws InterruptedException {
        Thread.sleep(250);
        personList.clickEditButton();
    }

    @And("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void editSomething(String name, String surname, String job, String birthday, String language, String gender, String status) throws Throwable {

        Thread.sleep(500);

        person.setName(name);
        person.setSurname(surname);
        person.setJob(job);
        person.setBirthday(birthday);
        person.setLanguage(language);
        person.setGender(gender);
        person.setEmployeeStatus(status);
        Thread.sleep(1000);
    }

    @And("^click on edit-button$")
    public void clickOnEditButton2() throws InterruptedException {
        WebElement editBtn = driver.findElement(By.xpath("//button[text()='Edit']"));
        editBtn.click();
        Thread.sleep(1000);
    }

    @And("^remove a person$")
    public void removeAPerson() throws InterruptedException {
        WebElement deleteBtn = driver.findElement(By.xpath("//span[@onclick='deletePerson(0)']"));
        deleteBtn.click();
        Thread.sleep(1000);
    }

    @Then("^reset list$")
    public void resetList() {
        personList.getResetBtn().click();
    }

    @When("^click clear-button$")
    public void click_clear_button() throws Throwable {
            WebElement clear = driver.findElement(By.xpath("//div[contains(@class,'clear-btn')]/button"));
            clear.click();
        }

        @Then("^check empty fields$")
        public void check_empty_fields () throws Throwable {
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

