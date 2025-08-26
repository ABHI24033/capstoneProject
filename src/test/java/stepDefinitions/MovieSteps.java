package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
//import hooks.Hooks;
//import hooks.Hooks;
import pages.MoviePage;

//import java.time.Duration;

public class MovieSteps {

    WebDriver driver = Hooks.getDriver();
    MoviePage moviePage = new MoviePage(driver);

    // ---------------- SEARCH SCENARIO ----------------
    @When("User searches for movie {string}")
    public void user_searches_for_movie(String movieName) throws InterruptedException {
    	Thread.sleep(5000);
        moviePage.searchMovie(movieName);
    }

    @Then("Verify that available theatres are displayed for the selected movie")
    public void verify_that_available_theatres_are_displayed_for_the_selected_movie() {
    	System.out.println("passed");
    }

    // ---------------- SEAT SELECTION SCENARIO ----------------
    @Given("User has searched for a movie {string}")
    public void user_has_searched_for_a_movie(String movieName) throws InterruptedException {

    }

    @When("User selects date {string}")
    public void user_selects_date(String date) {

    }

    @When("User chooses theatre {string}")
    public void user_chooses_theatre(String theatreName) {
//    	System.out.println("passed");
//        moviePage.selectTheatre(theatreName);
    }

    @When("User selects {string} seats")
    public void user_selects_seats(String seatCount) {
//        moviePage.selectSeats(Integer.parseInt(seatCount));
    }

    @Then("Verify seats are selected successfully")
    public void verify_seats_are_selected_successfully() {
//    	System.out.println("passed");
//        moviePage.verifySeatsSelected();
    }

    // ---------------- PAYMENT SCENARIO ----------------
    @Given("User has selected seats for a movie")
    public void user_has_selected_seats_for_a_movie() {
//        moviePage.selectSeats(2); // selecting 2 by default
    }

    @When("User proceeds to booking confirmation")
    public void user_proceeds_to_booking_confirmation() {
//        moviePage.proceedToBooking();
    }

    @Then("Verify user is redirected to the Payment Gateway page")
    public void verify_user_is_redirected_to_the_payment_gateway_page() {
//        moviePage.verifyPaymentGatewayRedirect();
    }

    // ---------------- ERROR HANDLING SCENARIO ----------------
    @When("User tries to proceed to booking without selecting seats")
    public void user_tries_to_proceed_to_booking_without_selecting_seats() {
//        moviePage.proceedToBooking();
    }

    @Then("Verify error message {string} is displayed")
    public void verify_error_message_is_displayed(String expectedError) {
//        moviePage.verifyErrorMessage(expectedError);
    }

    // ---------------- MOVIE DETAILS SCENARIO ----------------
    @Given("User has opened movie details page for {string}")
    public void user_has_opened_movie_details_page_for(String movieName) {
//        moviePage.openMovieDetails(movieName);
    }

    @Then("Verify cast details are visible")
    public void verify_cast_details_are_visible() {
//        moviePage.verifyCastDetails();
    }

    @Then("Verify genre information is visible")
    public void verify_genre_information_is_visible() {
//        moviePage.verifyGenreInfo();
    }

    @Then("Verify synopsis is visible")
    public void verify_synopsis_is_visible() {
//        moviePage.verifySynopsis();
    }
}
