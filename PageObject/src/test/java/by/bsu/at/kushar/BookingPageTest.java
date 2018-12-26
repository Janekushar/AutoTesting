package by.bsu.at.kushar;

import static org.junit.Assert.*;


import by.bsu.at.kushar.bookingpage.FlightForm;
import by.bsu.at.kushar.homepage.LanguageAndRegion;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BookingPageTest {
    private static WebDriver driver;
    private static FlightForm form;

    @BeforeClass
    public static void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        form = new FlightForm(driver);
        driver.navigate().to("https://www.ethiopianairlines.com/AA/EN");
    }

    @Before
    public void setUpUrl() {
        driver.navigate().to("https://www.ethiopianairlines.com/AA/EN");
    }

    @AfterClass
    public static void tearDownChromeDriverQuit() {
        form = null;
        driver.quit();
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

    @Test
    public void sameLocationTest() {
        form.getDepartureAirport().sendKeys("Aarhus (AAR), Denmark");
        form.getArrivalAirport().sendKeys("Aarhus (AAR), Denmark");
        form.oneWay();
        form.clickCalendar();
        form.getDate().click();
        form.clickSubmit();
        form.disebleTab();
        String expectedMess = "We couldn't find any available schedules that meet your criteria. " +
                "Please try with a different search";
        assertEquals(expectedMess, form.getAlertMessage());
    }

    @Test
    public void dateSelectTest() {
        form.clickSecondCalendar();
        WebElement secondDate = form.getSecondDate();
        WebElement firstDate = form.getDate();
        secondDate.click();
        firstDate.click();
        form.clickSecondCalendar();
        int[] expected = {Integer.valueOf(secondDate.getText()), Integer.valueOf(firstDate.getText())};
        assertArrayEquals(expected, form.getFligthDates());
    }

    @Test
    public void maxValuePassTest() {
        form.selectPassengers();
        for (int i = 0; i < 9; i++) {
            form.addAdult();
        }
        int expectedAmount = 9;
        assertEquals(expectedAmount, form.getAdultAmount());

    }

    @Test
    public void maxSumValueTest() {
        form.selectPassengers();
        for (int i = 0; i < 4; i++) {
            form.addAdult();
            form.addChild();
        }
        form.addChild();
        int expectedAmount = 9;
        assertEquals(expectedAmount, form.getAdultAmount() + form.getChildAmount());
    }

    @Test
    public void maxInfantValueTest() {
        form.selectPassengers();
        for (int i = 0; i < 4; i++) {
            form.addAdult();
            form.addInfant();
        }
        int expectedAmount = 3;
        assertEquals(expectedAmount, form.getInfantAmount());
    }

    @Test
    public void infantWithoutAdultTest() {
        form.selectPassengers();
        form.addInfant();
        form.addAdult();
        form.addInfant();
        int notExpectedAmount = form.getInfantAmount();
        form.minusAdult();
        assertNotEquals(notExpectedAmount, form.getInfantAmount());
    }

    @Test
    public void finalFormNotEmptyTest() {
        form.getDepartureAirport().sendKeys("Addis Ababa (ADD), Ethiopia");
        form.getArrivalAirport().sendKeys("Bahar Dar (BJR), Ethiopia");
        form.oneWay();
        form.clickCalendar();
        form.getDate().click();
        form.clickSubmit();
        form.setAccept();
        form.setOffer(0);
        form.clickSelectOffer(0);
        form.waitPrice();
        form.clickContinue();
        form.waitFinalForm();
        form.clickContinue();
        WebElement input = form.getInputField();
        assertTrue(Arrays.asList(input.getAttribute("class").split(" ")).contains("field-error"));
    }

    @Test
    public void totalPriceTest() {
        form.getDepartureAirport().sendKeys("Addis Ababa (ADD), Ethiopia");
        form.getArrivalAirport().sendKeys("Bahar Dar (BJR), Ethiopia");
        form.oneWay();
        form.clickCalendar();
        form.getDate().click();
        form.clickSubmit();
        form.setAccept();
        form.setOffer(0);
        form.clickSelectOffer(0);
        double notExpectedAmount = form.getTotalPrice();
        form.changeOrder();
        form.setOffer(3);
        form.clickSelectOffer(3);
        assertNotEquals(notExpectedAmount, form.getTotalPrice(), 1E-2);
    }
}
