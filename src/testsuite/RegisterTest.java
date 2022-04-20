package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //find register element for registration
        driver.findElement(By.linkText("Register")).click();
        //find text and match with expected text
        String actualSignUpText =
        driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")).getText();
        String expectedSignUpText = "Signing up is easy!";
         //validate message
        Assert.assertEquals("Not Matching",actualSignUpText,expectedSignUpText);

    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){

        driver.findElement(By.linkText("Register")).click();
        //find all the elements for registration
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("prime");
        driver.findElement(By.id("customer.lastName")).sendKeys("test");
        driver.findElement(By.id("customer.address.street")).sendKeys("23 prime test");
        driver.findElement(By.id("customer.address.city")).sendKeys("Ahmedabad");
        driver.findElement(By.id("customer.address.state")).sendKeys("gujarat");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("380050");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("000000000");
        driver.findElement(By.id("customer.ssn")).sendKeys("prime");
        driver.findElement(By.id("customer.username")).sendKeys("primetesting12121212");
        driver.findElement(By.id("customer.password")).sendKeys("primetest");
        driver.findElement(By.id("repeatedPassword")).sendKeys("primetest");
        driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]")).click();

        String actualWecomeText =
                driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")).getText();
        String expectedWelcomeText = "Your account was created successfully. You are now logged in.";
        //validate message
        Assert.assertEquals("Not Matching",actualWecomeText,expectedWelcomeText);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
