package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        driver.findElement(By.name("username")).sendKeys("primetesting121212");
        driver.findElement(By.name("password")).sendKeys("primetest");
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        String expectedOverviewMessage =
        driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")).getText();
        String actualOverviewMessage = "Accounts Overview";

        Assert.assertEquals("Not Matching", expectedOverviewMessage,actualOverviewMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        driver.findElement(By.name("username")).sendKeys("[[[[[");
        driver.findElement(By.name("password")).sendKeys("[[[[[");
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
       String actualDisplay =
        driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")).getText();
       String expectedDisplay = "The username and password could not be verified.";

       Assert.assertEquals("Not Matching",expectedDisplay,actualDisplay);

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        driver.findElement(By.name("username")).sendKeys("primetesting");
        driver.findElement(By.name("password")).sendKeys("primetest");
        driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
        String expectedcustomerLoginMessage =
        driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();
        String actualcustomerLoginMessage = "Customer Login";

        Assert.assertEquals("Not Matching",expectedcustomerLoginMessage,actualcustomerLoginMessage);

    }
    @After
    public void tearDown(){
       driver.quit();
    }
}

