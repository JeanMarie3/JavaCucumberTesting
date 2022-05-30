package features;

Feature: Login
  I login to the page: "https://www.demoblaze.com/index.html"
  Scenario: Login to the page before buying the phone
    Given I have the login
    And I have the password
    When I login to the page
    Then I am successfully logged in