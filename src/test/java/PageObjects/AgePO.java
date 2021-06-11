package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePO {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTextBox;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    public void setName(String name) {
        nameTextBox.clear();
        nameTextBox.sendKeys(name);
    }

    public void setAge(String age) {
        ageTextBox.sendKeys(age);
    }

    public void clickOnSubmit()
    {
        submitButton.click();
    }
}
