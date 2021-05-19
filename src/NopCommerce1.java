import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NopCommerce1 {


    WebDriver driver;


    @Before
    public void browser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyNavigateRegisterpage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Vrajesh");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("13");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1983");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("vrajeshpatel"+randomInt+"@yahoo.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Prime");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc1234");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abc1234");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        String expectedMessage = "Your registration completed";
        WebElement message = driver.findElement(By.xpath("//div[@class='result']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Message not Displayed",expectedMessage,actualMessage);




    }
}
