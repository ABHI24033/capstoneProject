package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

import java.util.List;

public class MoviePage {

    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'sc-133848s-3')]//a[@class='sc-133848s-11 sc-lnhrs7-5 ctsexn bHVBt']")
    private List<WebElement> recommendedMovies;

    @FindBy(xpath = "//h1[@class='movie-title']")
    private WebElement movieName;

    @FindBy(xpath = "//img[@class='movie-poster']")
    private WebElement moviePoster;

    @FindBy(xpath = "//button[contains(text(),'Book Tickets')]")
    private WebElement bookingOption;

    @FindBy(xpath = "//a[text()='Movies']")
    private WebElement moviesTab;

    @FindBy(xpath = "//img[@alt='Coming Soon']")
    private WebElement exploreUpcomingMoviesImgLink;

    @FindBy(xpath = "//img[@alt='Now Showing']")
    private WebElement inCinemasNearYouImgLink;

    // Constructor
    public MoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Select first movie from recommended list
    public void selectFirstRecommendedMovie() {
        if (!recommendedMovies.isEmpty()) {
            recommendedMovies.get(0).click();
        } else {
            throw new RuntimeException("No recommended movies found!");
        }
    }

//    // Get movie name
    public boolean isMovieNameDisplayed() {
        return movieName.isDisplayed();
    }

    // Check if poster is visible
    public boolean isPosterDisplayed() {
        return moviePoster.isDisplayed();
    }

    // Check if booking option is available
    public boolean isBookingOptionAvailable() {
        return bookingOption.isDisplayed();
    }

    // Navigate to Movies tab
    public void clickMoviesTab() {
        moviesTab.click();
    }

    // Navigate to Explore Upcoming Movies
    public void clickExploreUpcomingMovies() {
    	WaitUtils.waitForClickability(driver, exploreUpcomingMoviesImgLink).click();
//    	exploreUpcomingMoviesImgLink.click();
    }

    // Validate "In Cinemas Near You" link
    public boolean isInCinemasNearYouLinkDisplayed() {
    	return WaitUtils.waitForVisibility(driver, inCinemasNearYouImgLink).isDisplayed();
    }
}
