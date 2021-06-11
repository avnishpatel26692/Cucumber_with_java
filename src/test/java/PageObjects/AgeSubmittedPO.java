package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {
    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    public String getMessage() {
        return this.message.getText();
    }
}
