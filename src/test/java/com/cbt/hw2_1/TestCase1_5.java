package com.cbt.hw2_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1_5 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "Verify the message displayed: The date of birth is not valid")
    public void test1(){
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        WebElement actualMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        Assert.assertEquals(actualMessage.getText(), "The date of birth is not valid");
    }

    @Test(description = "Verify that c++, java, JavaScript languages are displayed")
    public void test2(){
        System.out.println(driver.findElement(By.xpath("//label[text()='C++']")).getText());
        System.out.println(driver.findElement(By.xpath("//label[text()='Java']")).getText());
        System.out.println(driver.findElement(By.xpath("//label[text()='JavaScript']")).getText());
    }

    @Test(description = "Verify warning message displayed: first name must be more than 2 and less than 64 characters long")
    public void test3(){
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("A");
        WebElement actualMessage=driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2')]"));
        Assert.assertEquals(actualMessage.getText(), "first name must be more than 2 and less than 64 characters long");
    }

    @Test(description = "Verify warning message displayed: The last name must be more than 2 and less than 64 characters long")
    public void test4(){
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("b");
        WebElement actualMessage=driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2')]"));
        Assert.assertEquals(actualMessage.getText(), "The last name must be more than 2 and less than 64 characters long");
    }

    @Test(description = "Verify success message displayed: You've successfully completed registration!")
    public void test5(){
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Albert");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Einstain");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("alistain");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("alistain@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("alibaba@here");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("560-789-0123");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/01/2000");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByValue("DE");
        System.out.println(department.getFirstSelectedOption().getText());

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByVisibleText("SDET");
        System.out.println(jobTitle.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("//label[text()='Java']")).click();

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        WebElement actualMessage = driver.findElement(By.xpath("//p"));
        Assert.assertEquals(actualMessage.getText(), "You've successfully completed registration!");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
