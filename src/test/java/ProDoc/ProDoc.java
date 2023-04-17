package ProDoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProDoc {

    @Test
    public void testAboutDoctorsFind() throws InterruptedException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver();
        driver.get("https://prodoctorov.ru/");
        String title = driver.getTitle();
        Assert.assertEquals("ПроДокторов – сайт отзывов пациентов о врачах №1 в России", title);
        WebElement urlElement = driver.findElement(By.className("b-choose-town-btn-v2"));
        urlElement.click();
        WebElement inputElementSearch = driver.findElement(By.className("b-choose-town-popup__search-input"));
        Thread.sleep(2000);
        inputElementSearch.sendKeys("Краснодар");
        inputElementSearch.click();
        Thread.sleep(2000);
        WebElement SearchBoxElement = driver.findElement(By.xpath("//strong[@class='b-town-search__highlight']"));
        SearchBoxElement.click();
        Thread.sleep(2000);
        WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder = 'Врачи, клиники, услуги']"));
        Thread.sleep(2000);
        inputElement.sendKeys("Ницакова Марина Петровна");
        WebElement submitButton = driver.findElement(By.className("base-search__button"));
        submitButton.click();
        WebElement link = driver.findElement(By.className("b-card__name-link"));
        link.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://prodoctorov.ru/krasnodar/vrach/177664-nicakova/");
        driver.quit();

    }
}
