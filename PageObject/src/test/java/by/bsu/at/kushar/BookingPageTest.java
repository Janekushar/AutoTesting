package by.bsu.at.kushar;

import static org.junit.Assert.*;


import by.bsu.at.kushar.bookingpage.FlightForm;
import by.bsu.at.kushar.homepage.LanguageAndRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BookingPageTest {
    private WebDriver driver;
    private FlightForm form;

    @Before
    public void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ethiopianairlines.com/AA/EN");
        form = new FlightForm(driver);
    }

    @After
    public void tearDownChromeDriverQuit() {
        form = null;
        driver.quit();
        driver = null;
    }

    @Test
    public void changeRegionTest() {
        LanguageAndRegion lar = new LanguageAndRegion(driver);
        lar.openLanguageSelector();
        lar.selectLanguage();
        lar.changeLanguage();
        String currUrl = "https://www.ethiopianairlines.com/AA/DE/";
        assertEquals(currUrl, driver.getCurrentUrl());
    }

    @Test
    public void emptyFieldTest() {
        WebElement dep = form.getDepartureAirport();
        dep.click();
        form.clickSubmit();
        assertTrue(Arrays.asList(dep.getAttribute("class").split(" ")).contains("error-value"));
    }
}
