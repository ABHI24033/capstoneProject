package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage {

    WebDriver driver;
    WebDriverWait wait;
    
 // ---------- Constructor ----------
    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Locators ----------
        
    @FindBy(xpath = "//div[@class='sc-1or3vea-13 kbbBtJ']")
    WebElement searchBox;
    @FindBy(xpath = "//input[@type='text']")
    WebElement inputBox;
    @FindBy(xpath = "//div[@class='sc-f42fb7-0 NuxLD']")
    List<WebElement> suggestedMovieLists;


    // ---------- Page Methods ----------
    public void searchMovie(String movieName) {
        // Wait for search box and click
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
        System.out.println("Search box clicked");

        // Enter movie name
        wait.until(ExpectedConditions.visibilityOf(inputBox)).sendKeys(movieName);
        System.out.println("Movie name entered: " + movieName);

        // Wait until at least one suggestion appears
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestedMovieLists));
        
        if (!suggestedMovieLists.isEmpty()) {
            suggestedMovieLists.get(0).click();
            System.out.println("First suggested movie clicked");
        } else {
            System.out.println("No suggestions found for: " + movieName);
        }
    }

}
