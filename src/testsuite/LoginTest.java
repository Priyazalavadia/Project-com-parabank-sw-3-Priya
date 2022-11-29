package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "Priya");
        //Find the password field element
        sendTextToElement(By.name("password"), "Hasit237400");
        //click on login tab
        clickOnElement(By.xpath("//input[contains(@value,'Log In')]"));

        //verify the Accounts Overview text is display
        String expectedMessage ="Accounts Overview";

        WebElement actualTextFromElement= driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage=actualTextFromElement.getText();

        Assert.assertEquals("Accounts Overview",expectedMessage,actualMessage);

    }
    @Test
            public void verifyTheErrorMessage(){
       // Enter invalid username
        sendTextToElement(By.name("username"), "Priya1");
       // Enter invalid password
        sendTextToElement(By.name("password"), "Hasit2374001");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[contains(@value,'Log In')]"));

        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage ="The username and password could not be verified";

        WebElement actualTextFromElement= driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage=actualTextFromElement.getText();

        Assert.assertEquals("Accounts Overview",expectedMessage,actualMessage);
        }

        @Test
    public void userShouldLogoutSuccessfully(){
            sendTextToElement(By.name("username"), "Priya");
            //Find the password field element
            sendTextToElement(By.name("password"), "Hasit237400");
            //click on login tab
            clickOnElement(By.xpath("//input[contains(@value,'Log In')]"));



        }

    @After
    public void tearDown(){
        closeBrowser();
    }
    }