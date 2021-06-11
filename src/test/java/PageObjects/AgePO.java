package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePO {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameTxtBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTxtBox;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitBtn;

    public void setName(String name) {
        nameTxtBox.clear();
        nameTxtBox.sendKeys(name);
    }

    public void setAge(String age) {
        ageTxtBox.sendKeys(age);
    }

    public void clickOnSubmit() {
        submitBtn.click();
    }

















}
