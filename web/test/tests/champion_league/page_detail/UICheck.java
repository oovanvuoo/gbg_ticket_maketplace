package tests.champion_league.page_detail;

import org.testng.Assert;
import org.testng.annotations.Test;
// import io.qameta.allure.*;

import base.BaseTest;
import pages.champion_league.ChampionLeagueDetail;

public class UICheck extends BaseTest {

    @Test(description = "Verify Champion League detail page path title")
    public void checkPathTitle() {
        navigateTo("champions-league/champions-league-final-2025");
        ChampionLeagueDetail detailPage = new ChampionLeagueDetail(driver);
        detailPage.acceptCookies();
        String actualTitle = detailPage.getDetailPathTitle();
        Assert.assertEquals(actualTitle, "Champions League Final 2025", "Detail page title mismatch");
    }
    
    @Test(description = "Verify Champion League detail page team 1 related tickets title")
    public void checkTeam1RelatedTicketsSection() {
        navigateTo("champions-league/champions-league-final-2025");
        ChampionLeagueDetail detailPage = new ChampionLeagueDetail(driver);
        detailPage.acceptCookies();
        String team1SectionTitle = detailPage.getTeam1RelatedTitkets();
        Assert.assertEquals(team1SectionTitle, "MORE PARIS SAINT-GERMAIN MATCHES", "Team 1 related tickets section title mismatch");
    }
}
