Feature: Movie Booking Module
  The framework will validate the core functionalities of the movie booking process.

  Background:
    Given User is on home page and select city "Delhi"

  @Movie @Search
  Scenario: Search for movies based on city and availability
    When User searches for movie "Inception"
    Then Verify that available theatres are displayed for the selected movie

  @Movie @SeatSelection
  Scenario: Select date, theatre, and seats
    Given User searches
    When User selects date "2025-08-28"
    And User chooses theatre "PVR Orion Mall"
    And User selects "2" seats
    Then Verify seats are selected successfully

  @Movie @Payment
  Scenario: Redirect to payment gateway after valid seat selection
    Given User has selected seats for a movie
    When User proceeds to booking confirmation
    Then Verify user is redirected to the Payment Gateway page

  @Movie @ErrorHandling
  Scenario: Error when booking without selecting seats
    Given User has searched for a movie "Inception"
    When User tries to proceed to booking without selecting seats
    Then Verify error message "Please select at least 1 seat" is displayed

  @Movie @Details
  Scenario: Ensure movie details are displayed correctly
    Given User has opened movie details page for "Inception"
    Then Verify cast details are visible
    And Verify genre information is visible
    And Verify synopsis is visible
