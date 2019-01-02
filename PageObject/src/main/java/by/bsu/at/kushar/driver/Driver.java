package by.bsu.at.kushar.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    private WebDriver driver;

    public Driver() {
        driver = new ChromeDriver();
        new ChromeOptions().addArguments("--window-size=1920,1080");
        driver.manage().timeouts().implicitlyWait(85, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public Driver(String url) {
        driver = new ChromeDriver();
        new ChromeOptions().addArguments("--window-size=1920,1080");
        driver.manage().timeouts().implicitlyWait(85, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        navigateTo(url);
    }

    public void quit() {
        driver.quit();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public WebElement byXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public WebElement byClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className)).click();
    }

    public WebElement byID(String id) {
        return driver.findElement(By.id(id));
    }

    public void clickByID(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void wait(WebElement element) {
        new WebDriverWait(driver, 80)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickable(WebElement element) {
        new WebDriverWait(driver, 80)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)");
    }



    public void sleep() {
        long timeout = 80;
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
