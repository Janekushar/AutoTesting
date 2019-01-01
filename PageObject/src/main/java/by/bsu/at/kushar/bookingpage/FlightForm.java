package by.bsu.at.kushar.bookingpage;

import by.bsu.at.kushar.driver.Driver;
import org.openqa.selenium.WebElement;

public class FlightForm {
    private Driver driver;

    public FlightForm(Driver driver) {
        this.driver = driver;
    }

    public void disebleTab() {
        driver.clickByXpath("//*[@id=\"no-stopover\"]");
    }

    public WebElement getDepartureAirport() {
        return driver.byID("departureAirport");
    }

    public WebElement getArrivalAirport() {
        return driver.byID("arrivalAirport");
    }

    public void clickSubmit() {
        driver.clickByID("submit-book");
    }

    public void oneWay() {
        driver.clickByXpath("//*[@id=\"book-form\"]/div[1]/ul/li[1]");
    }

    public void clickCalendar() {
        driver.clickByXpath("//*[@id=\"book-form\"]/div[2]/ul/li[3]/div/label[1]");
    }

    public WebElement getDate() {
        return driver.byXpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/div/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[4]/td[6]/a");
    }

    public void clickSecondCalendar() {
        driver.clickByXpath("//*[@id=\"book-form\"]/div[2]/ul/li[3]/div/label[2]");
    }

    public WebElement getSecondDate() {
        return driver.byXpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/div/div[3]/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/a");
    }

    public int[] getFligthDates() {
        return new int[]{Integer.valueOf(getCurrentDate(1).getText()),
                Integer.valueOf(getCurrentDate(2).getText())};
    }

    private WebElement getCurrentDate(int i) {
        return driver.byXpath("//*[@id=\"book-form\"]" +
                "/div[2]/ul/li[3]/div/label[" + i + "]/label/span[2]");
    }

    public void selectPassengers() {
        driver.clickByXpath("//*[@id=\"passcntbtn\"]");
    }

    public void addAdult() {
        driver.clickByXpath("//*[@id=\"passcntpop\"]/ul/li[2]/div[3]/button[2]");
    }

    public void addChild() {
        driver.clickByXpath("//*[@id=\"passcntpop\"]/ul/li[3]/div[3]/button[2]");
    }

    public void addInfant() {
        driver.clickByXpath("//*[@id=\"passcntpop\"]/ul/li[4]/div[3]/button[2]");
    }

    public void minusAdult() {
        driver.clickByXpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[2]/div[3]/button[1]");
    }

    public int getAdultAmount() {
        return Integer.valueOf(driver.byXpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[2]/div[1]/label").getText());
    }

    public int getChildAmount() {
        return Integer.valueOf(driver.byXpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[3]/div[1]/label").getText());
    }

    public int getInfantAmount() {
        return Integer.valueOf(driver.byXpath("//*[@id=\"passcntpop\"]" +
                "/ul/li[4]/div[1]/label").getText());
    }

    public String getAlertMessage() {
        return driver.byXpath("//*[@id=\"dxp-shared-flight-selection\"]" +
                "/div/div[1]/div/div/div/span[2]/span").getText();
    }

    public void setOffer(int i) {
        driver.sleep();
        driver.sleep();
        driver.sleep();
        driver.wait(getSelectOffer(i));
        getSelectOffer(i).click();
    }

    public void clickSelectOffer(int j) {
        driver.sleep();
        driver.sleep();
        driver.sleep();
        driver.wait(getSelectButton(j));
        try {
            getSelectButton(j).click();
        } catch (Exception e) {
//            something
        }
        try {
            getSelectButton(j).click();
        } catch (Exception e) {
//            something
        }
    }

    private WebElement getSelectOffer(int i) {
        return driver.byXpath("//*[@id=\"offer-container-" + i + "-0\"]/button");
    }

    private WebElement getSelectButton(int j) {
        return driver.byXpath("//*[@id=\"dxp-flight-offers-comparison-0-0\"]" +
                "/td/table/tbody/tr[7]/td["+j+"]/button");
    }


    public double getTotalPrice() {
        waitPrice();
        return Double.valueOf(driver.byXpath("//*[@id=\"dxp-flight-selection-trip-total-content\"]" +
                "/div/table/tbody[2]/tr/td[2]/span/div/span/span/span[1]/span")
                .getText().replace(',', '.'));
    }

    public void waitPrice() {
        driver.sleep();
        driver.sleep();
        driver.sleep();
        driver.wait(driver.byXpath("//*[@id=\"dxp-flight-selection-trip-total-content\"]/div"));
    }

    public void changeOrder() {
        driver.clickByXpath("//*[@id=\"dxp-selected-flight-0\"]/div/div/div[2]/button[2]");
    }

    public void clickContinue() {
        driver.sleep();
        driver.sleep();
        driver.sleep();
        driver.clickByXpath("//*[@id=\"dxp-page-navigation-continue-button\"]");
    }

    public WebElement getInputField() {
        return driver.byXpath("//*[@id=\"passenger-item-ADT-1-basic-info\"]" +
                "/div/div[1]/div[2]/div");
    }

    public void waitFinalForm() {
        driver.wait(driver.byXpath("//*[@id=\"dxp-passenger-list\"]"));
    }
}
