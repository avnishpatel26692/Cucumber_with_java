package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {

    @FindBy(how = How.ID, using = "message")
    private WebElement msg;

    public String getMsg()
    {
        return msg.getText();
    }
}
