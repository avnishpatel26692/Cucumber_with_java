package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonList {
    @FindBy(how = How.XPATH, using = "//button[@onclick='openModalForAddPerson()']")
    private WebElement addPersonButton;

    @FindBy(how= How.XPATH, using = "//span[contains(@onclick,'openModalForEditPerson(2)')]")
    private WebElement editPersonButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Reset List']")
    private WebElement resetBtn;

    //button[@onclick='addPersonToList()']
    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public void clickEditButton() throws InterruptedException {
        Thread.sleep(250);
        editPersonButton.click();
    }

    public WebElement getResetBtn() {
        return resetBtn;
    }


}
