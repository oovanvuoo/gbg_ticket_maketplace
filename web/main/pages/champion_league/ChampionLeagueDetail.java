package pages.champion_league;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class ChampionLeagueDetail extends BasePage {

    private final By detailPathTitle = By.xpath("//div[@class=\"breadcrumb_inner\"]//p[last()]");
    private final By btnAcceptCookies = By.xpath("//button[starts-with(@class, 'iubenda-cs-accept-btn') and normalize-space(text()) = 'Acceptt']");
    private final By btnRejectCookies = By.xpath("//button[starts-with(@class, 'iubenda-cs-reject-btn') and normalize-space(text()) = 'Reject']");
    private final By titleTeam1RelatedTickets = By.xpath("(//div[@class=\"ticket_head\"]//p)[2]");

    // Constructor to initialize the WebDriver
    public ChampionLeagueDetail(WebDriver driver) {
        super(driver);
    }

    // Void functions
    public void acceptCookies() {
        if (driver.findElements(btnAcceptCookies).size() > 0) {
            driver.findElement(btnAcceptCookies).click();
        }
    }

    public void rejectCookies() {
        if (driver.findElements(btnRejectCookies).size() > 0) {
            driver.findElement(btnRejectCookies).click();
        }
    }

    // Get data functions
    public String getDetailPathTitle() {
        return driver.findElement(detailPathTitle).getText();
    }

    public String getTeam1RelatedTitkets(){
        scrollDownUntilElementVisible(titleTeam1RelatedTickets);
        return driver.findElement(titleTeam1RelatedTickets).getText();
    }


    // Set data functions

}
