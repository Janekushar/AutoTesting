package by.bsu.at.kushar;

import static org.junit.Assert.*;


import by.bsu.at.kushar.bookingpage.FlightForm;
import by.bsu.at.kushar.driver.Driver;
import by.bsu.at.kushar.homepage.LanguageAndRegion;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.*;

import java.util.Arrays;

public class BookingPageTest {
    private static Driver driver;
    private static FlightForm form;

    @BeforeClass
    public static void setUpChromeDriver() {
        driver = new Driver("https://www.ethiopianairlines.com/AA/EN");
        form = new FlightForm(driver);
    }

    @Before
    public void setUpUrl() {
        driver.navigateTo("https://www.ethiopianairlines.com/AA/EN");
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
        lar.selectLanguage(4);
        lar.changeLanguage();
        String currUrl = "https://www.ethiopianairlines.com/AA/DE/";
        assertEquals(currUrl, driver.getCurrentURL());
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
        form.clickCalendar(1);
        form.getDate(4,6).click();
        form.clickSubmit();
        form.disebleTab();
        String expectedMess = "We couldn't find any available schedules that meet your criteria. " +
                "Please try with a different search";
        assertEquals(expectedMess, form.getAlertMessage());
    }

    @Test
    public void dateSelectTest() {
        form.clickCalendar(2);
        WebElement secondDate = form.getDate(3,4);
        WebElement firstDate = form.getDate(4,6);
        secondDate.click();
        firstDate.click();
        form.clickCalendar(2);
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
        form.getArrivalAirport().sendKeys("Paris De Gaulle (CDG), France");
        form.oneWay();
        form.clickCalendar(1);
        form.getDate(4,6).click();
        form.clickSubmit();
        form.setOffer(0);
        form.clickSelectOffer(2);
        form.waitPrice();
        driver.scrollDown();
        form.clickableContinue();
        form.clickContinue();
        form.clickContinue();
        form.waitFinalForm();
        driver.scrollDown();
        form.clickContinue();
        form.clickContinue();
        WebElement input = form.getInputField();
        assertTrue(Arrays.asList(input.getAttribute("class").split(" ")).contains("field-error"));
    }

    @Test
    public void totalPriceTest() {
        form.getDepartureAirport().sendKeys("Addis Ababa (ADD), Ethiopia");
        form.getArrivalAirport().sendKeys("Paris De Gaulle (CDG), France");
        form.oneWay();
        form.clickCalendar(1);
        form.getDate(4,6).click();
        form.clickSubmit();
        form.setOffer(0);
        form.clickSelectOffer(2);
        driver.scrollDown();
        double notExpectedAmount = form.getTotalPrice();
        driver.scrollUp();
        form.changeOrder();
        form.setOffer(1);
        form.clickSelectOffer(2);
        assertNotEquals(notExpectedAmount, form.getTotalPrice(), 1E-2);
    }
}
