@GoogleTrends
Feature: As a user, I should be able to search and compare 2 different topics in google trends

  Scenario: I should be able to see the percentual ratio of comparing 2 different item for the last 90 days in compared breakdown by metro section
    Given I am on the google trends page
    When I enter first topic to the enter search term or a topic input box
    Then You should be redirected to the explore page
    And I enter second topic to the compare field
    Then I should be on the compare page
    And I select US, New York from the filters
    And I select 'Past 90 days' from the filters
    Then I should be able to get the percentual ratio from the Compared breakdown by metro section


