package com.cbt.hw2_1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase6 {
    public static void main(String[] args) {
    WebDriver driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://www.tempmailaddress.com/");
        //retrieve and save an email address as a string:
        String emailAddress = driver.findElement(By.xpath("//span[@class='animace']")).getText();
        System.out.println(emailAddress);

        //go to https://practice-cybertekschool.herokuapp.com and click “Sign Up For Mailing List button:
    driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

    //Enter any valid full name:
    driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Alex Johnson");

    //Enter email address, which is retrieved above:
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);

    //Click Sign Up button:
    driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

    //get and verify the sign-up message:
    WebElement actualMessage = driver.findElement(By.xpath("//h3[@name='signup_message']"));
        Assert.assertEquals(actualMessage.getText(), "Thank you for signing up. Click the button below to return to the home page.");

    //go back to https://www.tempmailaddress.com/
    driver.navigate().to("https://www.tempmailaddress.com/");
        utils.wait(15);

    //Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”:
    WebElement cybertekEmail = driver.findElement(By.xpath("//*[text()='do-not-reply@practice.cybertekschool.com']"));
        System.out.println(cybertekEmail);
    Assert.assertEquals(cybertekEmail.getText(), " do-not-reply@practice.cybertekschool.com");

    //Click on that email to open it:
    cybertekEmail.click();

    //Verify that email is from: “do-notreply@practice.cybertekschool.com”:
    WebElement emailSender = driver.findElement(By.xpath("//span[@id='odesilatel']"));
    Assert.assertEquals(emailSender.getText(), "do-not-reply@practice.cybertekschool.com");

    //Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”:
    WebElement subject = driver.findElement(By.xpath("//span[@id='predmet']"));
    Assert.assertEquals(subject.getText(), "Thanks for subscribing to practice.cybertekschool.com!");

    driver.quit();
    }
}
