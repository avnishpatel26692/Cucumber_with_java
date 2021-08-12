package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Random;

public class EmailGenerator {

@FindBy(how = How.ID, using = "input-email")
private WebElement emailTxtbox;



    public void setEmail(String email){
        if(email.equalsIgnoreCase("random")) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(10000);
            emailTxtbox.clear();
            emailTxtbox.sendKeys("username"+ randomInt +"@gmail.com");
        }
        else {
            emailTxtbox.clear();
            emailTxtbox.sendKeys(email);
        }
    }
}


