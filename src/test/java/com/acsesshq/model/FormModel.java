package com.acsesshq.model;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormModel {

    private WebDriver driver;

    public FormModel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForm(String btnName){
        driver.findElement(By.cssSelector(btnName)).click();
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

    public void assertPopup(String popName, String msgContent){

        var popup =  driver.findElement(By.className(popName));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(popup));

        Assertions.assertEquals(msgContent,popup.getText());

    }


}
