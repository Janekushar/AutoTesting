package by.bsu.at.kushar.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageAndRegion {
    private WebDriver driver;

    public LanguageAndRegion(WebDriver driver) {
        this.driver = driver;
    }

    public void openLanguageSelector() {
        driver.findElement(By.className("dropdown-toggle")).click();
    }

    public void selectLanguage() {
        driver.findElement(By.xpath("//*[@id=\"language\"]/option[4]")).click();
    }

    public void changeLanguage() {
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/input")).click();
    }
}
