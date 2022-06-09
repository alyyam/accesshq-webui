package com.accesshq.test;

import com.acsesshq.model.FormModel;
import com.acsesshq.model.PlanetPage;
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

       form.clickForm("[aria-label=forms]");
       form.setName("Alysson");
       form.setEmail("alysson-am@hotmail.com");
       form.setAgreeBtn("[for=agree]");
       form.setSubmitBtn("submit");
       form.assertPopup("popup-message", "Thanks for your feedback Alysson");

       //var popup =  driver.findElement(By.className("popup-message"));
       //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(popup));

       // Assertions.assertEquals("Thanks for your feedback Alysson",popup.getText());


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

    @Test
    public void accessPlanetEarth(){
        PlanetPage planetPage =  new PlanetPage(driver);
        planetPage.acessAnyPlanet(planetPage, "Earth");

    }


    @Test
    public void clickFurthestPlanet(){
        PlanetPage planetPage = new PlanetPage(driver);
        planetPage.clickPlanetPage();
        var planetList = planetPage.getPlanetList();

        long min = Integer.MIN_VALUE;
        var name = "";

        for(var planet:planetList){
            var value =  planetPage.gecurrenttDistance(planet);
            long distance = Long.parseLong(value);
            if(distance > min){
                min = distance;
                name = planet.findElement(By.tagName("h2")).getText();

            }
        }
        for(var planet: planetList){
            if(planet.findElement(By.tagName("h2")).getText().equalsIgnoreCase(name)){
                planet.findElement(By.tagName("Button")).click();
            }
        }



    }

    @Test
    public void findPlanetByDistance(){
        PlanetPage planetPage = new PlanetPage(driver);
        driver.findElement(By.cssSelector("[aria-label=planets")).click();
        var planets = driver.findElements(By.className("planet"));
        long distance = 4495000;

        for(var planet : planets){
            var value =  planetPage.gecurrenttDistance(planet);
            long planetdistance = Long.parseLong(value);

            if(planetPage.compare(planetdistance,distance)){
                planet.findElement(By.tagName("Button")).click();
            }
        }






    }






}
