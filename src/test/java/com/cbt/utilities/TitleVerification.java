package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/");
        String mainPageTitle = driver.getTitle();
        String mainPageUrl = driver.getCurrentUrl();

        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        String dropdownPageTitle = driver.getTitle();
        String dropdownPageUrl = driver.getCurrentUrl();
        verifyEquals(mainPageTitle, dropdownPageTitle);

        driver.navigate().to("http://practice.cybertekschool.com/login");
        String loginPageTitle = driver.getTitle();
        String loginPageUrl = driver.getCurrentUrl();
        verifyEquals(dropdownPageTitle, loginPageTitle);

        if(mainPageUrl.startsWith("http://practice.cybertekschool.com") &&
            dropdownPageUrl.startsWith("http://practice.cybertekschool.com") &&
            loginPageUrl.startsWith("http://practice.cybertekschool.com")){
            System.out.println("URL of all 3 pages start with \"http://practice.cybertekschool.com\"");
        }else {
            System.out.println("Different start of URLs");
        }
        driver.quit();
    }
}
