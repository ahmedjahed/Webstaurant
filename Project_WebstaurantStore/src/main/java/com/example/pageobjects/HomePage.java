package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite(String url) {
        driver.get(url);
    }

    public void searchProduct(String productName) {
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }
}