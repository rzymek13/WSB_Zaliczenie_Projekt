package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends WebPage {

    @FindBy(className = "opbox-listing")
    private List<WebElement> searchResultItems;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    public List<String> searchResultsItemsText() {
        return searchResultItems.stream()
                .map(element -> element.getText().toLowerCase())
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchText) {
        return searchResultsItemsText().stream()
                .filter(item -> item.contains(searchText))
                .collect(Collectors.toList());

    }



}
