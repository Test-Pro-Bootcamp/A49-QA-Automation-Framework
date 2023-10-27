package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest_threads{
    HomePage homePage= new HomePage(getThreadLocal());
    BasePage basePage= new BasePage(getThreadLocal());
    LoginPage loginPage = new LoginPage(getThreadLocal());
    public String myNewSpellbook = "SpellBook summoning 101";
    public String newSpellbookTitle = "Crios's" + myNewSpellbook;

    @Test(priority = 1, description = "Creating a new spellbook")
    public void createSpellbook(){
        loginPage.successfulPortalTest();
        homePage.createNewSpellBook(myNewSpellbook);
        String expectedMessage = "Created playlist \"" + myNewSpellbook +".\"";
        Assert.assertEquals(homePage.verifySpellResult(), expectedMessage);

        basePage.waitForSpellFade();
    }
    @Test(priority = 2, description = "Add song to new SpellBook")
    public void addSongtoSpellbook(){
        loginPage.successfulPortalTest();
        homePage.createNewSpellBook("Crios Spellbook");
        basePage.waitForSpellFade();
        homePage.newRitual("Way of the Samurai")
                .allResults()
                .firstSongInList()
                .clickAddToBtn()
                .addSongToCriosPlaylist();
        String expectedSpellResult = "Added 1 song into \"Crios Spellbook.\"";
        Assert.assertEquals(homePage.verifySpellResult(), expectedSpellResult);
    }
    @Test(priority = 3, description = "Delete playlist")
    public void banishSpellBook(){
        loginPage.successfulPortalTest();
        homePage.banishCreatedSpellbook();
        String expectedMessage = "Deleted playlist \"" + newSpellbookTitle + ".\"";
        Assert.assertEquals(homePage.verifySpellResult(), expectedMessage);
    }
}
