package by.bsu.at.kushar.homepage;

import by.bsu.at.kushar.driver.Driver;

public class LanguageAndRegion {
    private Driver driver;

    public LanguageAndRegion(Driver driver) {
        this.driver = driver;
    }

    public void openLanguageSelector() {
        driver.clickByClassName("dropdown-toggle");
    }

    public void selectLanguage() {
        driver.clickByXpath("//*[@id=\"language\"]/option[4]");
    }

    public void changeLanguage() {
        driver.clickByXpath("//*[@id=\"searchForm\"]/input");
    }
}
