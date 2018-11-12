package by.bsu.at.kushar.bookingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightForm {
    private WebDriver driver;

    public FlightForm(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getDepartureAirport() {
        return driver.findElement(By.id("departureAirport"));
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit-book")).click();
    }
}
