package stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PersonAdd {

    @FindBy(how = How.ID, using = "name")
    private WebElement PersonNameTxtbox;

    @FindBy(how = How.ID, using = "surname")
    private WebElement PersonSurnameTxtbox;

    @FindBy(how = How.ID, using = "job")
    private WebElement PersonJobTxtbox;

    @FindBy(how = How.ID, using = "dob")
    private WebElement PersonBirthdayTxtbox;

    @FindBy(how = How.NAME, using = "language")
    private List<WebElement> languageCheckboxes;

    @FindBy(how = How.ID, using = "male")
    private WebElement genderRadioMaleBtn;

    @FindBy(how = How.ID, using = "female")
    private WebElement genderRadioFemaleBtn;

    @FindBy(how = How.ID, using = "status")
    private WebElement textDropDownEmployeeStatus;

    @FindBy(how = How.XPATH, using = "//button[text()='Add']")
    private WebElement addBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
    private WebElement cancelBtn;


    public String getName() {
        return PersonNameTxtbox.getText();
    }

    public void setName(String name) {
        PersonNameTxtbox.clear();
        PersonNameTxtbox.sendKeys(name);
    }

    public String getSurname() {
        return PersonSurnameTxtbox.getText();
    }

    public void setSurname(String surname) {
        PersonSurnameTxtbox.clear();
        PersonSurnameTxtbox.sendKeys(surname);
    }

    public String getJob() {
        return PersonJobTxtbox.getText();
    }

    public void setJob(String job) {
        PersonJobTxtbox.clear();
        PersonJobTxtbox.sendKeys(job);
    }

    public void setBirthday(String birthday) throws InterruptedException {
        PersonBirthdayTxtbox.clear();
        PersonBirthdayTxtbox.sendKeys(birthday + Keys.ENTER); //dd/mm/yyyy
    }

    public void setGender(String gender) {

        if (gender.equals("male")) {
            genderRadioMaleBtn.click();
        } else if (gender.equals("female")) {
            genderRadioFemaleBtn.click();
        }
    }


    public String getLanguageXpath(String language) {
        return "//input[@id='" + language + "']";
    }

    public void setLanguage(String language) {
        languageCheckboxes.get(0).click();

        int i = 0;
        if (language.equals("french")) {
            i = 1;
        }
        else if(language.equals("spanish")) {
            i = 2;
        }

        languageCheckboxes.get(i).click();
    }

//    public String getGenderRadioBtnXpath(String gender) {
//        return "//input[@id='" + gender + "']";
//    }

//    public String getEmployeeStatusOption(String status) {
//        return "//input[@value='" + status + "']";
//
//    }

    public void setEmployeeStatus(String status) {
        Select drop = new Select(textDropDownEmployeeStatus);
        drop.selectByVisibleText(status);
    }

    public WebElement getAddBtn() {
        return addBtn;
    }


    private WebElement getCancelBtn() {
        return cancelBtn;
    }
}


