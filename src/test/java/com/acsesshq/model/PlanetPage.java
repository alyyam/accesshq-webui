package com.acsesshq.model;

import com.acsesshq.strategies.MatchingStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetPage implements MatchingStrategies {


    private WebDriver driver;


    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlanetPage() {
        driver.findElement(By.cssSelector("[aria-label=planets")).click();

    }

    public List<WebElement> getPlanetList() {
        return driver.findElements(By.className("planet"));

    }

    public String gecurrenttDistance(WebElement planet) {
        return planet.findElement(By.className("distance")).getText().replaceAll("km", "").replaceAll(",", "").replaceAll(" ", "");
    }

    public void acessAnyPlanet(PlanetPage planet, String planetName) {
        planet.clickPlanetPage();
        planet.getPlanetList();
        for (var planets : planet.getPlanetList()) {
            if (planets.findElement(By.tagName("h2")).getText().equalsIgnoreCase(planetName)) {
                planets.findElement(By.tagName("Button")).click();
                break;

            }


        }
    }

    @Override
    public boolean compare(long distance, long value) {
        return false;
    }
}
