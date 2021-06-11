package runners.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagePO {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTxtbox;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitBtn;

    public void setName(String name){
        nameTextBox.clear();
        nameTextBox.sendKeys(name);
    }
    public void setAge (String age){
        ageTxtbox.sendKeys(age);
    }
    public void clicSubmit(){
        submitBtn.click();
    }
}
