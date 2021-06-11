package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePO {
    @FindBy(how= How.ID,using="name")
    private WebElement name;

    @FindBy(how = How.ID,using="age")
    private WebElement age;

    @FindBy(how = How.ID,using="submit")
    private WebElement button;

    public void setName(String name){
        this.name.clear();
        this.name.sendKeys(name);
    }

    public void setAge(String age){
        this.age.clear();
        this.age.sendKeys(age);
    }

    public void submit(){
        button.click();
    }
}
