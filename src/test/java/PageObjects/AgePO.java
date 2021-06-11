package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePO {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameTxtbox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTxtbox;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitBtn;

    public void setName(String name)
    {
        nameTxtbox.clear();
        nameTxtbox.sendKeys(name);
    }

    public void setAge(String age)
    {
        ageTxtbox.sendKeys(age);
    }

    public void clickOnSubmit()
    {
        submitBtn.click();
    }

}
