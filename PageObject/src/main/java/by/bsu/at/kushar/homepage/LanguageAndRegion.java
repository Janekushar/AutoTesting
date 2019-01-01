package by.bsu.at.kushar.homepage;

import by.bsu.at.kushar.driver.Driver;

import static by.bsu.at.kushar.page.HomePage.*;

public class LanguageAndRegion {
    private Driver driver;

    public LanguageAndRegion(Driver driver) {
        this.driver = driver;
    }

    public void openLanguageSelector() {
        driver.clickByClassName(getLanguageSelectorClass());
    }

    public void selectLanguage(int i) {
        driver.clickByXpath(getLanguageXpath(i));
    }

    public void changeLanguage() {
        driver.clickByXpath(getChaneLanguageXpath());
    }
}
