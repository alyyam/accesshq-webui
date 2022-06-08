package com.acsesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormModel {

    WebDriver driver ;

    public FormModel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForm(String btnName){
        driver.findElement(By.cssSelector("[aria-label=forms].v-btn")).click();
    }


    public void setName(String name) {

        driver.findElement(By.name("name")).sendKeys(name);
    }

    public void setEmail(String email) {

        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void setAgreeBtn(String agreePath) {

        driver.findElement(By.cssSelector(agreePath)).click();
    }

    public void setSubmitBtn(String btnName) {
        var buttons = driver.findElements(By.cssSelector("button"));
        for (WebElement button : buttons) {
            if (button.getText().equalsIgnoreCase(btnName)) {
                button.click();
                break;
            }
        }
    }
}
