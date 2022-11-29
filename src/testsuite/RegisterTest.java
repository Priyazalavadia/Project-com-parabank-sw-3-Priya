package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

  public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

  @Test
    public void verifyThatSigningUpPageDisplay(){
      //Click on the Register link
    clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

    //Verify the text Signing up is easy!
    String expectedMessage = "Signing up is easy!";
    //Find the welcome text element and get the text
    String actualMessage = getTextFromElement(By.xpath("h1[text()=@signing up is easy!']"));
    //validate actual and expected message
    Assert.assertEquals("No such msg displayed",expectedMessage,actualMessage);

   }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
      //Click on the Register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

      //Enter First name
        sendTextToElement(By.name("customer.firstName"),"Priya");

       // Enter Last name
        sendTextToElement(By.name("customer.lastname"),"Patel");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"),"camrose avenue");
        //Enter City
        sendTextToElement(By.id("customer.address.city"),"Edgware");
        //Enter State
        sendTextToElement(By.id("customer.address.city"),"London");

        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"HA86AG");

         // Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"),"1234567890");

         // Enter SSN
        sendTextToElement(By.id("customer.ssn"),"123456777");

         // Enter Username
        sendTextToElement(By.id("customer.username"),"Priya");

        // Enter Password
        sendTextToElement(By.id("customer.password"),"Hasit237400");

       // Enter Confirm
        sendTextToElement(By.id("repeatedPassword"),"Hasit237400");

         // Click on REGISTER button
        clickOnElement(By.xpath("//input[@value='Register']"));

        // Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMessage="Your account was created successfully. You are now logged in.";

        WebElement actualTextFromElement = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        String actualMessage =actualTextFromElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("no message found",expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
      closeBrowser();
    }
}

