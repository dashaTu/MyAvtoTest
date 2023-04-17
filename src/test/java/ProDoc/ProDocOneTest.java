package ProDoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProDocOneTest extends BaseTest {

    @Test
    public void testAboutDoctorsFind() throws InterruptedException {
        getDriver().get("https://prodoctorov.ru/");
        String title = getDriver().getTitle();
        Assert.assertEquals("ПроДокторов – сайт отзывов пациентов о врачах №1 в России", title);

        WebElement urlElement = getDriver().findElement(By.className("b-choose-town-btn-v2"));
        urlElement.click();
        WebElement inputElementSearch = getDriver().findElement(By.className("b-choose-town-popup__search-input"));
        inputElementSearch.sendKeys("Краснодар");
        inputElementSearch.click();
        WebElement SearchBoxElement = getDriver().findElement(By.xpath("//div[@role='listbox']"));
        SearchBoxElement.click();
        Thread.sleep(2000);
        WebElement inputElement = getDriver().findElement(By.xpath("//input[@placeholder = 'Врачи, клиники, услуги']"));
        Thread.sleep(2000);
        inputElement.sendKeys("Ницакова Марина Петровна");
        WebElement submitButton = getDriver().findElement(By.className("base-search__button"));
        submitButton.click();
        WebElement link = getDriver().findElement(By.className("b-card__name-link"));
        link.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://prodoctorov.ru/krasnodar/vrach/177664-nicakova/");
    }

}
