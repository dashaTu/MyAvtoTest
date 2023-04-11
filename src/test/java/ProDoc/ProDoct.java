package ProDoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProDoct {

    @Test
    public void testAboutDoctorsFind() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver();
        driver.get("https://prodoctorov.ru/");
        String title = driver.getTitle();
        Assert.assertEquals("ПроДокторов – сайт отзывов пациентов о врачах №1 в России", title);
        WebElement inputElement = driver.findElement(By.className("text-field__input"));
        WebElement submitButton = driver.findElement(By.className("base-search__button"));
        inputElement.sendKeys("Ницакова Марина Петровна");
        submitButton.click();
        WebElement link = driver.findElement(By.className("b-card__name-link"));
        link.click();
        WebElement text = driver.findElement(By.className("ui-text"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://prodoctorov.ru/krasnodar/vrach/177664-nicakova/");
        driver.quit();

    }
}
