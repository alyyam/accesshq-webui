package com.accesshq.test;

import com.acsesshq.model.FormModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUITest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.manage().window().maximize();
    }



    @Test
    public void testWebUi() {


        driver.findElement((By.id("loginButton"))).click();

    }

    @Test
    public void fillNameField() {

        driver.findElement((By.id("forename"))).sendKeys("Alysson");


    }

    @Test
    public void fillFormField() {

       FormModel form = new FormModel(driver);
        form.ge
       form.clickForm("[aria-label=forms].v-btn");
       form.setName("Alysson");
       form.setEmail("alysson-am@hotmail.com");
       form.setAgreeBtn("[for=agree]");
       form.setSubmitBtn("submit");

       var popup =  driver.findElement(By.className("popup-message"));
       new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(popup));

        Assertions.assertEquals("Thanks for your feedback Alysson",popup.getText());


   /*     drive.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        drive.findElement(By.cssSelector("[aria-label=forms].v-btn")).click();
        drive.findElement(By.name("name")).sendKeys("Alysson");
        drive.findElement(By.name("email")).sendKeys("alysson-am@hotmail.com");
        drive.findElement(By.cssSelector("[for=agree]")).click();

        var buttons = drive.findElements(By.cssSelector("button"));
        for(WebElement button:buttons){
            if(button.getText().equalsIgnoreCase("submit")){
                button.click();
                break;*/

    }



}
