package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.navigate().to("https://lulugandgeorgia.com");
        String luluTitle = driver.getTitle();
        System.out.println(luluTitle.toLowerCase().trim());
        String luluUrl = driver.getCurrentUrl();
        System.out.println(luluUrl);
        if(luluUrl.contains(luluTitle)){
            System.out.println("Lulu passed");
        }else {
            System.out.println("Lulu failed");
        }

        driver.navigate().to("https://wayfair.com/");
        String wayfareTitle = driver.getTitle();
        System.out.println(wayfareTitle.toLowerCase().trim());
        String wayfareUrl = driver.getCurrentUrl();
        System.out.println(wayfareUrl);
        if(wayfareUrl.contains(wayfareTitle)){
            System.out.println("Wayfare passed");
        }else {
            System.out.println("Wayfare failed");
        }

        driver.navigate().to("https://walmart.com/");
        String walmartTitle = driver.getTitle();
        System.out.println(walmartTitle.toLowerCase().trim());
        String walmartUrl = driver.getCurrentUrl();
        System.out.println(walmartUrl);
        if(walmartUrl.contains(walmartTitle)){
            System.out.println("Walmart passed");
        }else {
            System.out.println("Walmart failed");
        }

        driver.navigate().to("https://westelm.com/");
        String westelmTitle = driver.getTitle();
        System.out.println(westelmTitle.toLowerCase().trim());
        String westelmUrl = driver.getCurrentUrl();
        System.out.println(westelmUrl);
        if(westelmUrl.contains(westelmTitle)){
            System.out.println("Westelm passed");
        }else {
            System.out.println("Westelm failed");
        }
        driver.quit();
    }
}
