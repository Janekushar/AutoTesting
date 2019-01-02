package by.bsu.at.kushar.page;

public class HomePage {
    public static String getDisableTadXpath() {
        return "//*[@id=\"no-stopover\"]";
    }

    public static String getOneWayXpath() {
        return "//*[@id=\"book-form\"]/div[1]/ul/li[1]";
    }

    public static String getCalendarXpath(int i) {
        return "//*[@id=\"book-form\"]/div[2]/ul/li[3]/div/label[" + i + "]";
    }

    public static String getDateXpath(int i, int j) {
        return "//*[@id=\"book-form\"]/div[2]/ul/div/div[3]/div/div/div/div[2]" +
                "/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]/a";
    }

    public static String getCurrentDateXpath(int i) {
        return "//*[@id=\"book-form\"]/div[2]/ul" +
                "/li[3]/div/label[" + i + "]/label/span[2]";
    }

    public static String getSelectPassengersXpath() {
        return "//*[@id=\"passcntbtn\"]";
    }

    public static String getChangePassengersXpath(int i, int j) {
        return "//*[@id=\"passcntpop\"]/ul/li[" + i + "]/div[3]/button[" + j + "]";
    }

    public static String getPassengersAmountXpath(int i) {
        return "//*[@id=\"passcntpop\"]/ul/li[" + i + "]/div[1]/label";
    }

    public static String getAlertXpath() {
        return "//*[@id=\"dxp-shared-flight-selection\"]" +
                "/div/div[1]/div/div/div/span[2]/span";
    }

    public static String getSelectOfferXpath(int i) {
        return "//*[@id=\"offer-container-" + i + "-0\"]/button";
    }

    public static String getSelectButtonXpath(int j) {
        return "//*[@id=\"dxp-flight-offers-comparison-0-0\"]" +
                "/td/table/tbody/tr[7]/td[" + j + "]/button";
    }

    public static String getTotalPriceXpath() {
        return "//*[@id=\"dxp-flight-selection-trip-total-content\"]" +
                "/div/table/tbody[2]/tr/td[2]/span/div/span/span/span[1]/span";
    }

    public static String getTotalPriceTableXpath(){
        return "//*[@id=\"dxp-flight-selection-trip-total-content\"]/div";
    }

    public static String getChangeOrderXpath() {
        return "//*[@id=\"dxp-selected-flight-0\"]/div/div/div[2]/button[2]";
    }

    public static String getContinueXpath() {
        return "//*[@id=\"dxp-page-navigation-continue-button\"]";
    }

    public static String getInputFieldXpath(){
        return "//*[@id=\"passenger-item-ADT-1-basic-info\"]" +
                "/div/div[1]/div[2]/div";
    }

    public static String getFinalFormXpath(){
        return "//*[@id=\"dxp-passenger-list\"]";
    }

    public static String getLanguageXpath(int i) {
        return "//*[@id=\"language\"]/option["+i+"]";
    }
    public static String getChaneLanguageXpath(){
        return "//*[@id=\"searchForm\"]/input";
    }

    public static String getDepartureAirportId() {
        return "departureAirport";
    }

    public static String getArrivalAirportId() {
        return "arrivalAirport";
    }

    public static String getSubmitId() {
        return "submit-book";
    }

    public static String getLanguageSelectorClass(){
        return "dropdown-toggle";
    }
}
