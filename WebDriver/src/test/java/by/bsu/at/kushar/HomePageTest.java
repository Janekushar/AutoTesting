package by.bsu.at.kushar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomePageTest {
    private WebDriver driver;

    @Before
    public void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ethiopianairlines.com/AA/EN");
    }

    @After
    public void tearDownChromeDriverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    public void changeRegionTest() {
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("//*[@id=\"language\"]/option[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/input")).click();
        String currUrl = "https://www.ethiopianairlines.com/AA/DE/";
        assertEquals(currUrl,driver.getCurrentUrl());
    }
}
