package com.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        // Implement adding the last found item to the cart
        WebElement lastItem = driver.findElement(By.cssSelector(".product-list .product:last-child"));
        lastItem.click();
    }

    public void emptyCart() {
        // Implement emptying the cart
        WebElement emptyCartButton = driver.findElement(By.id("empty_cart_button"));
        emptyCartButton.click();
    }
}