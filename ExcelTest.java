package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class ExcelTest {
    //creating object of ExcelUtils class
    static Excel_Util excelUtils = new Excel_Util();

    //using the Constants class values for excel file path
    static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;

    @Test
    public void test() throws IOException {
        //set the Chrome Driver path
        System.setProperty("webdriver.chrome.driver", "/Users/chathurajayasinghe/Downloads/chromedriver 2");

        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();

        //launching the specified URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Identify the WebElements for the student registration form
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));


        //calling the ExcelUtils class method to initialise the workbook and sheet
        excelUtils.setExcelFile(excelFilePath, "Sheet1");

        //iterate over all the row to print the data present in each cell.
        for (int i = 1; i <= excelUtils.getRowCountInSheet(); i++) {

            firstName.clear();
            firstName.sendKeys(excelUtils.getCellData(i, 0));
            lastName.clear();
            lastName.sendKeys(excelUtils.getCellData(i, 1));

        }
        //closing the driver
        driver.quit();
    }
}
