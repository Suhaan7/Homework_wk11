package broswerfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

public static WebDriver driver;

public void openBrowser(String url){
    ChromeOptions options = new ChromeOptions();//setting Webdriver
    driver = new ChromeDriver(options);
    driver.get(url);//launch url
    driver.manage().window().maximize();//maximize screen
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));//giving wait
}
    public void closeBrowser (){driver.quit();}
}


