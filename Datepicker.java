
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

public class Datepicker {
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
    public void datePicker() throws InterruptedException {
        //Launch the website
       driver.get("https://jqueryui.com/datepicker/");

       //Switching to iframe
       WebElement iframe=driver.findElement(By.className("demo-frame"));
       driver.switchTo().frame(iframe);

       //Selecting the datefield
       WebElement datefield=driver.findElement(By.id("datepicker"));
       Thread.sleep(2000);
       datefield.click();

       //Selecting the next month
       WebElement cal=driver.findElement(By.xpath("//a[@title='Next']"));
       Thread.sleep(3000);
       cal.click();


       //Selecting the date "22"
        WebElement date=driver.findElement(By.xpath("//a[@data-date='22']"));
        Thread.sleep(2000);
        date.click();

        //Printing the selected date in the console
        System.out.println("The selected date is "+datefield.getAttribute("value"));

   }

}
