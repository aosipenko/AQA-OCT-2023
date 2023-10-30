Feature: test combination of API, SQL and Selenium

  Scenario: retrieve and store and search for random user
    Given I retrieve 3 random users with API
    Given I store those persons in DB
    Given I load google page
    Given I pick a random person from DB
    When I google for that person
    Then I see that persons name in search results
