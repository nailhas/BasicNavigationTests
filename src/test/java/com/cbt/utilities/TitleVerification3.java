package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.navigate().to("https://luluandgeorgia.com");
        String luluTitleUnchanged = driver.getTitle();
        String luluTitle= luluTitleUnchanged.toLowerCase().replaceAll(" ", "");
        System.out.println(luluTitle);
        String luluUrl = driver.getCurrentUrl();
        System.out.println(luluUrl);
        if(luluUrl.contains(luluTitle)){
            System.out.println("Lulu passed");
        }else {
            System.out.println("Lulu failed");
        }
        driver.close();

        driver = new ChromeDriver();
        driver.get("https://wayfair.com/");
        String wayfareTitleUnchanged = driver.getTitle();
        String wayfareTitle = wayfareTitleUnchanged.toLowerCase().replaceAll(" ", "");
        System.out.println(wayfareTitle);
        String wayfareUrl = driver.getCurrentUrl();
        System.out.println(wayfareUrl);
        if(wayfareUrl.contains(wayfareTitle)){
            System.out.println("Wayfare passed");
        }else {
            System.out.println("Wayfare failed");
        }
        driver.close();

        driver = new ChromeDriver();
        driver.navigate().to("https://walmart.com/");
        String walmartTitleUnchanged = driver.getTitle();
        String walmartTitle = walmartTitleUnchanged.toLowerCase().replaceAll(" ", "");
        System.out.println(walmartTitle);
        String walmartUrl = driver.getCurrentUrl();
        System.out.println(walmartUrl);
        if(walmartUrl.contains(walmartTitle)){
            System.out.println("Walmart passed");
        }else {
            System.out.println("Walmart failed");
        }
        driver.close();

        driver = new ChromeDriver();
        driver.navigate().to("https://westelm.com/");
        String westelmTitleUnchanged = driver.getTitle();
        String westelmTitle = westelmTitleUnchanged.toLowerCase().replaceAll(" ", "");
        System.out.println(westelmTitle);
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
