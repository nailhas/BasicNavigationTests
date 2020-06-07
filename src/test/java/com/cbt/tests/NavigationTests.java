package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import static com.cbt.utilities.StringUtility.verifyEquals;

public class NavigationTests {
    public static void main(String[] args) {

        //1. Open browser - Chrome, Firefox, or Edge:
        //WebDriver driver = BrowserFactory.getDriver("chrome");
        //WebDriver driver = BrowserFactory.getDriver("firefox");
        WebDriver driver = BrowserFactory.getDriver("edge");
        assert driver != null;
        driver.manage().window().maximize();

        //2. Go to website https://google.com:
        driver.get("https://google.com");

        //3. Save the title in a string variable:
        String googleTitle = driver.getTitle();
        System.out.println(googleTitle);

        //4. Go to https://etsy.com:
        driver.navigate().to("https://etsy.com");

        //5. Save the title in a string variable:
        String etsyTitle = driver.getTitle();
        System.out.println(etsyTitle);

        //6. Navigate back to previous page
        driver.navigate().back();

        //7. Verify that title is same is in step 3:
        String backToGoogleTitle = driver.getTitle();
        verifyEquals(backToGoogleTitle, googleTitle);

        //8. Navigate forward to previous page:
        driver.navigate().forward();

        //9. Verify that title is same is in step 5:
        String backToEtsyTitle = driver.getTitle();
        verifyEquals(backToEtsyTitle, etsyTitle);

        //close the browser:
        driver.quit();
    }
}
