package by.bsu.at.kushar.bookingpage;

import static by.bsu.at.kushar.page.HomePage.*;

import by.bsu.at.kushar.driver.Driver;
import org.openqa.selenium.WebElement;

public class FlightForm {
    private Driver driver;

    public FlightForm(Driver driver) {
        this.driver = driver;
    }

    public void disebleTab() {
        driver.clickByXpath(getDisableTadXpath());
    }

    public WebElement getDepartureAirport() {
        return driver.byID(getDepartureAirportId());
    }

    public WebElement getArrivalAirport() {
        return driver.byID(getArrivalAirportId());
    }

    public void clickSubmit() {
        driver.clickByID(getSubmitId());
    }

    public void oneWay() {
        driver.clickByXpath(getOneWayXpath());
    }

    public void clickCalendar(int i) {
        driver.clickByXpath(getCalendarXpath(i));
    }

    public WebElement getDate(int i, int j) {
        return driver.byXpath(getDateXpath(i, j));
    }

    public int[] getFligthDates() {
        return new int[]{Integer.valueOf(getCurrentDate(1).getText()),
                Integer.valueOf(getCurrentDate(2).getText())};
    }

    private WebElement getCurrentDate(int i) {
        return driver.byXpath(getCurrentDateXpath(i));
    }

    public void selectPassengers() {
        driver.clickByXpath(getSelectPassengersXpath());
    }

    public void addAdult() {
        driver.clickByXpath(getChangePassengersXpath(2, 2));
    }

    public void addChild() {
        driver.clickByXpath(getChangePassengersXpath(3, 2));
    }

    public void addInfant() {
        driver.clickByXpath(getChangePassengersXpath(4, 2));
    }

    public void minusAdult() {
        driver.clickByXpath(getChangePassengersXpath(2, 1));
    }

    public int getAdultAmount() {
        return Integer.valueOf(driver.byXpath(getPassengersAmountXpath(2)).getText());
    }

    public int getChildAmount() {
        return Integer.valueOf(driver.byXpath(getPassengersAmountXpath(3)).getText());
    }

    public int getInfantAmount() {
        return Integer.valueOf(driver.byXpath(getPassengersAmountXpath(4)).getText());
    }

    public String getAlertMessage() {
        return driver.byXpath(getAlertXpath()).getText();
    }

    public void setOffer(int i) {
//        driver.sleep();
        driver.wait(getSelectOffer(i));
        getSelectOffer(i).click();
    }

    public void clickSelectOffer(int j) {
//        driver.sleep();
        driver.wait(getSelectButton(j));
        driver.scrollDown();
//        try {
            getSelectButton(j).click();
//        } catch (Exception e) {
//            something
//        }
//        try {
//            getSelectButton(j).click();
//        } catch (Exception e) {
////            something
//        }
    }

    private WebElement getSelectOffer(int i) {
        return driver.byXpath(getSelectOfferXpath(i));
    }

    private WebElement getSelectButton(int j) {
        return driver.byXpath(getSelectButtonXpath(j));
    }


    public double getTotalPrice() {
        waitPrice();
        return Double.valueOf(driver.byXpath(getTotalPriceXpath())
                .getText().replace(',', '.'));
    }

    public void waitPrice() {
//        driver.sleep();
        driver.wait(driver.byXpath(getTotalPriceTableXpath()));
    }


    public void changeOrder() {
        driver.clickByXpath(getChangeOrderXpath());
    }

    public void clickableContinue() {
//        driver.sleep();
        driver.waitClickable(driver.byXpath(getContinueXpath()));
    }

    public void clickContinue() {
//        driver.sleep();
        driver.waitClickable(driver.byXpath(getContinueXpath()));
        driver.clickByXpath(getContinueXpath());
    }

    public WebElement getInputField() {
        return driver.byXpath(getInputFieldXpath());
    }

    public void waitFinalForm() {
        driver.wait(driver.byXpath(getFinalFormXpath()));
        driver.wait(driver.byXpath(getInputFinalForm()));
    }
}
