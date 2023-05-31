package testsuite;

import broswerfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }//opening browser

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        userNameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        WebElement SecureAreaText = driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')]"));
        String actualSecureAreaText = SecureAreaText.getText();
        String expectedSecureAreaText = "Secure Area";
        Assert.assertEquals("Verifying Secure Area Text", expectedSecureAreaText, actualSecureAreaText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        userNameField.sendKeys("tomsmith1");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        WebElement invalidUserNameText = driver.findElement(By.xpath("//div[@class='flash error']"));

    }
@Test
    public void verifyThePasswordErrorMessage() {

        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        userNameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword");

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();

        WebElement invalidPassword = driver.findElement(By.xpath("//div[@id ='flash']"));

    }
    @After
    public void teardown(){closeBrowser();}
}