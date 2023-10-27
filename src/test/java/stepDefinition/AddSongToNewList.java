package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongsPage;

public class AddSongToNewList {
    LoginPage loginPage= new LoginPage(BaseDefinition.getThreadLocal());
    SongsPage songsPage= new SongsPage(BaseDefinition.getThreadLocal());
    HomePage homePage= new HomePage(BaseDefinition.getThreadLocal());
    PlaylistPage playlistPage= new PlaylistPage(BaseDefinition.getThreadLocal());

    @Given("I have entered the portal")
    public void iHaveEnteredThePortal() {
        BaseDefinition.getThreadLocal().get("https://qa.koel.app/");
        loginPage.successfulPortalTest();

    }

    @When("I search for the song BossStatus")
    public void iSearchForTheSong() {
        songsPage.enterTitleIntoSearch();
    }

    @And("I view all the songs with BossStatus")
    public void iViewAllTheSongsWithBossStatus() {
        songsPage.allResults();

    }

    @And("I select BossStatus")
    public void iSelectBossStatus() {
        songsPage.songResult();
    }

    @And("I click add to...")
    public void iClickAddTo() {
        songsPage.addButton();
    }

    @Then("I create a new Playlist")
    public void iCreateANewPlaylist() {
        songsPage.createPlaylist();
    }


    @When("I select the first playlist")
    public void iSelectTheFirstPlaylist() {
        homePage.firstScroll();
    }

    @And("I click on the delete playlist")
    public void iClickOnTheDeletePlaylist() {
        playlistPage.castBanishScroll();
    }

    @Then("the playlist is deleted")
    public void thePlaylistIsDeleted() {
        homePage.popUp();
    }
}
