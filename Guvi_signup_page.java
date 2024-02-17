import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Guvi_signup_page {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Launch the webdriver
        driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
   @AfterClass
    public void tearDown(){
        //Close the webdriver
        driver.quit();
    }

    @Test
    public void signupPage() throws InterruptedException {
        //Launch the website
        driver.get("https://www.guvi.in/");

        //Clicking on the Signup button
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']")).click();

        //Enter Full name
        driver.findElement(By.id("name")).sendKeys("Blippy names");
        //Enter Email address
        driver.findElement(By.id("email")).sendKeys("Test55ams@gmail.com");
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("Hockey@12345");
        //Enter Mobile number
        driver.findElement(By.id("mobileNumber")).sendKeys("9789456123");
        //Clicking on the Signup button //a[@id='signup-btn']
        driver.findElement(By.xpath("//a[@id='signup-btn']")).click();

        //Verifying the Successful registration of the user
        WebElement userName=driver.findElement(By.xpath("//h1[text()='Welcome to GUVI!']"));
        Assert.assertEquals(userName.getText(),"Welcome to GUVI!");

        //Navigating back to Guvi home page
        driver.findElement(By.id("laterBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='navbar-guvilogo-black']")).click();
        Thread.sleep(3000);

        //Clicking on the login button
        driver.findElement(By.xpath("//a[@class='nav-link  text-primary text-center px-4']")).click();

        //Enter the Loginname
        driver.findElement(By.id("email")).sendKeys("divyarooban@yahoo.com");

        //Enter the password
        driver.findElement(By.id("password")).sendKeys("Dinu@0730");

        //Click on the signin button
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(2000);

        //Verifying the successful login

        Assert.assertEquals(driver.getTitle(),"GUVI | courses");



    }
}
