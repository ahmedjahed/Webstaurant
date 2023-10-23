package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.example.common.ExcelDataProvider;
import com.example.pageobjects.CartPage;
import com.example.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class WebstoreTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "testData")
    public void webstoreAutomationTest(String productName) {
        // Initialize Page Object classes
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // 1. Open the website
        homePage.openWebsite("https://www.webstaurantstore.com/");

        // 2. Search for the provided product name
        homePage.searchProduct(productName);

        // 3. Check the search results (verify that product titles contain "table")
        // You can add assertions here using Selenium's assertion methods or TestNG's assertions.

        // Check if the productName matches "Stainless work table"
        if (productName.equalsIgnoreCase("Stainless work table")) {
            // This is the specific case for "Stainless work table"
            // You can add specific test steps here.
            // For example, perform special actions for this product.
        } else {
            // For other products, you can add different test steps.
            // For example, add the last item to the cart and empty the cart.
            cartPage.addToCart();
            cartPage.emptyCart();
        }
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        // Specify the path to your Excel data file
        String excelFilePath = "/Users/ahmed2212/eclipse-workspace/Project_WebstaurantStore/TestData/TestData.xlsx";
        ExcelDataProvider excelDataProvider = new ExcelDataProvider(excelFilePath);
        int rowCount = excelDataProvider.getRowCount();

        Object[][] data = new Object[rowCount][1];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = excelDataProvider.getCellValue(i, 0);
        }

        return data;
    }
}