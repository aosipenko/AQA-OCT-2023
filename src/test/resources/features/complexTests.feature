#Feature: test combination of API, SQL and Selenium
#
#  Background:
#    Given I load google page
#
#  Scenario Outline: retrieve and store and search for random user
#    Given I retrieve <amount> random users with API
#    Given I store those persons in DB
#    Given I pick a random person from DB
#    When I google for that person
#    Then I see that persons name in search results
#    Then I check my holder "userDto"
#    Then I check my holder "randomUser"
#    Examples:
#      | amount |
#      | 1      |
#      | 2      |
#      | 3      |


#  Scenario Outline: retrieve and store and search for random user
#    Given I retrieve <amount> random users with API as "mob_1"
#    Given I retrieve <amount> random users with API as "mob_2"
#    Given I retrieve <amount> random users with API as "mob_3"
#    Given I store persons from "mob_2" in DB
#    Given I pick a random person from DB as "randomUser_1"
#    Given I pick a random person from DB as "randomUser_2"
#    Given I pick a random person from DB as "randomUser_3"
#    Then I check my holder "mob_1"
#    Then I check my holder "mob_2"
#    Then I check my holder "mob_3"
#    Then I check my holder "randomUser_1"
#    Then I check my holder "randomUser_2"
#    Then I check my holder "randomUser_3"
#    When I google for person "randomUser_3"
#    Then I see that person "randomUser_3" name in search results
#    Examples:
#      | amount |
#      | 2      |
