import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CookiePage;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.List;

public class AllegroSearchTest {

    private static final String SEARCH_PHRASE = "lego technics";

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkAllegroSearch() {

        driver.get("https://allegro.pl/");

        CookiePage cookiePage = new CookiePage(driver);
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        cookiePage.cookieBtnClick();

        homePage.performSearch(SEARCH_PHRASE);

        List<String> actualItems = searchResultPage.searchResultsItemsText();
        List<String> expectedItems = searchResultPage.searchResultsItemsWithText(SEARCH_PHRASE);

        Assertions.assertEquals(expectedItems,actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
