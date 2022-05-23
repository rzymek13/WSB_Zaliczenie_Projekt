package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiePage {

    @FindBy(xpath = "//*[@id=\"opbox-gdpr-consents-modal\"]/div/div[2]/div[2]/button[1]")
    private WebElement cookieAccptBtn;

    public CookiePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void cookieBtnClick() {
        try {
            cookieAccptBtn.click();
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    }

