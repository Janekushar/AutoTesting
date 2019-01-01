package by.bsu.at.kushar.bookingpage;

import com.sun.imageio.plugins.wbmp.WBMPImageWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FlightForm {
    private WebDriver driver;

    public FlightForm(WebDriver driver) {
        this.driver = driver;
    }

    public void disebleTab() {
        driver.findElement(By.xpath("//*[@id=\"no-stopover\"]")).click();
    }

    public WebElement getDepartureAirport() {
        return driver.findElement(By.id("departureAirport"));
    }

    public WebElement getArrivalAirport() {
        return driver.findElement(By.id("arrivalAirport"));
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit-book")).click();
    }

    public void oneWay() {
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[1]/ul/li[1]")).click();
    }

    public void clickCalendar() {
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[2]/ul/li[3]/div/label[1]")).click();
    }

    public WebElement getDate() {
        return driver.findElement(By.xpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/div/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[4]/td[6]/a"));
    }

    public void clickSecondCalendar() {
        driver.findElement(By.xpath("//*[@id=\"book-form\"]/div[2]/ul/li[3]/div/label[2]")).click();
    }

    public WebElement getSecondDate() {
        return driver.findElement(By.xpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/div/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/a"));
    }

    public int[] getFligthDates() {
        return new int[]{Integer.valueOf(getCurrentDate(1).getText()),
                Integer.valueOf(getCurrentDate(2).getText())};
    }

    private WebElement getCurrentDate(int i) {
        return driver.findElement(By.xpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/li[3]/div/label[" + i + "]/label/span[2]"));
    }

    public void selectPassengers() {
        driver.findElement(By.xpath("//*[@id=\"passcntbtn\"]")).click();
    }

    public void addAdult() {
        driver.findElement(By.xpath("//*[@id=\"passcntpop\"]/ul/li[2]/div[3]/button[2]")).click();
    }

    public void addChild() {
        driver.findElement(By.xpath("//*[@id=\"passcntpop\"]/ul/li[3]/div[3]/button[2]")).click();
    }

    public void addInfant() {
        driver.findElement(By.xpath("//*[@id=\"passcntpop\"]/ul/li[4]/div[3]/button[2]")).click();
    }

    public void minusAdult() {
        driver.findElement(By.xpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[2]/div[3]/button[1]")).click();
    }

    public int getAdultAmount() {
        return Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[2]/div[1]/label")).getText());
    }

    public int getChildAmount() {
        return Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[3]/div[1]/label")).getText());
    }

    public int getInfantAmount() {
        return Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[4]/div[1]/label")).getText());
    }

    public String getAlertMessage() {
        return driver.findElement(By.xpath("//*[@id=\"dxp-shared-flight-selection\"]" +
                "/div/div[1]/div/div/div/span[2]/span")).getText();
    }

    public void setOffer(int i) {
        sleep();
        sleep();
        sleep();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(getSelectOffer(i)));
        getSelectOffer(i).click();
    }

    public void clickSelectOffer(int i) {
        sleep();
        sleep();
        sleep();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(getSelectButton(i)));
        try {
            getSelectButton(i).click();
        } catch (Exception e) {
//            something
        }
        try {
            getSelectButton(i).click();
        } catch (Exception e) {
//            something
        }
    }

    private WebElement getSelectOffer(int i) {
        return driver.findElement(By.xpath("//*[@id=\"offer-container-0-" + i + "\"]/button"));
    }

    private WebElement getSelectButton(int i) {
        return driver.findElement(By.className("offer-select-button"));
    }

    public double getTotalPrice() {
        waitPrice();
        return Double.valueOf(driver.findElement(By.xpath("//*[@id=\"dxp-flight-selection-trip-total-content\"]" +
                "/div/table/tbody[2]/tr/td[2]/span/div/span/span/span[1]/span"))
                .getText().replace(',', '.'));
    }

    public void waitPrice() {
        sleep();
        sleep();
        sleep();
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath("//*[@id=\"dxp-flight-selection-trip-total-content\"]/div"))));
    }

    public void changeOrder() {
        driver.findElement(By.xpath("//*[@id=\"dxp-selected-flight-0\"]/div/div/div[2]/button[2]")).click();
    }

    public void clickContinue() {
        sleep();
        sleep();
        sleep();
        driver.findElement(By.xpath("//*[@id=\"dxp-page-navigation-continue-button\"]")).click();
    }


    public void setAccept() {
        sleep();
        sleep();
        sleep();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath("//*[@id=\"specialFareModal\"]/div/div"))));
        driver.findElement(By.xpath("//*[@id=\"specialFareModal\"]/div/div/div[2]/div[2]/label[1]")).click();
        sleep();
        sleep();
        sleep();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.
                        attributeToBe(By.xpath("//*[@id=\"ethiopian\"]"), "value", "YES"));
        sleep();
        sleep();
        sleep();
        driver.findElement(By.xpath("//*[@id=\"submit-btn\"]")).click();
    }

    public WebElement getInputField() {
        return driver.findElement(By.xpath("//*[@id=\"passenger-item-ADT-1-basic-info\"]" +
                "/div/div[1]/div[2]/div"));
    }

    public void waitFinalForm() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath("//*[@id=\"dxp-passenger-list\"]"))));
    }

    private void sleep() {
        long timeout = 30;
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
