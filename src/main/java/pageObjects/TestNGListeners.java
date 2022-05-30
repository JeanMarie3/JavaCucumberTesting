package pageObjects;
//        Advantages of Cucumber Software
//        It is helpful to involve business stakeholders who can’t easily read code
//        Cucumber Testing tool focuses on end-user experience
//        Style of writing tests allow for easier reuse of code in the tests
//        Quick and easy set up and execution
//        Cucumber test tool is an efficient tool for testing

import TestRunner.TypesListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

@Listeners(TypesListeners.class)
public class TestNGListeners {
    private WebDriver driver;
    private WebElement element;
    private String BaseUrl = "https://www.google.com";
    private String BaseUrl2 = " https://demo.guru99.com/";

    @BeforeMethod
    public void setUp() throws Exception {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Natek\\source\\Drivers\\firefox\\geckodriver.exe");
        //Hardcoded
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natek\\source\\Drivers\\chromedriver2\\chromedriver.exe");
        //Not hardcoded
        //import io.github.bonigarcia.wdm.WebDriverManager;
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    @Test(priority = 1)
    public void TestGoogle() throws Exception {
        //setting the driver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\klamnlo\\source\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natek\\source\\Drivers\\chromedriver_win32\\chromedriver.exe");
       //getBaseUrl();
//        //Initiating your chromedriver
        //WebDriver driver = new ChromeDriver();
        driver.get(BaseUrl);
        SECONDS.sleep(4);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //element = driver.findElement(By.id("lst-ib"));
        //WebElement p = driver.findElement(By.name("q"));
        element= driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver Interview questions");
        //driver.findElement(By.name("btnK")).click();
        element.submit();
        driver.manage().window().maximize();

        }

    @Test(priority = 2)
    public void TestGuru99() throws Exception {
        driver.get(BaseUrl2);
        SECONDS.sleep(4);
        element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.submit();
        //button.click(); click() function for gecko (firefox)
        //Example Of Implicit Wait Command
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        //Static waiting
        SECONDS.sleep(2);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
    }

    @Test(priority = 3)
    public void fluentWaitExample() throws Exception{
        //Example of Fluent Wait Command
//Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        //wait.withTimeout(5000, TimeUnit.MILLISECONDS);
//Specify polling time
        //wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        wait.until(ExpectedConditions.alertIsPresent());

    }

    @AfterMethod
    public void tearDown() throws Exception {

        //closing the browser
        driver.close();

        // Closing all browsers and closing WebDriver Session
        driver.quit();

        Reporter.log("Driver Closed After Testing");
    }
}