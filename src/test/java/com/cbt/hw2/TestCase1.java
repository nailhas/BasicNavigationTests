package com.cbt.hw2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        utils.wait(3);
        //click the Sign Up For Mailing List link:
        driver.findElement(By.xpath("//a[@href=\"/sign_up\"] ")).click();

        //fill out sign-up form (name & PW):
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Ivan Stotysyachniy");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("plhqhbjd@sharklasers.com");

        //click Sign-up button:
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();

        //get and print message displayed after signing up:
        String signUpMessage = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
        System.out.println(signUpMessage);

        //find the Home button:
        String.valueOf(driver.findElement(By.cssSelector("[class='btn btn-primary'] > i")));

        driver.quit();
        }
}
