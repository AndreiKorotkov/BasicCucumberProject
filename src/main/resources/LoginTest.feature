@LoginTest
Feature: Login to inbox
    I want to login to my mailbox

    Background: clear cache
        Given Cache is cleared
        And Login field is cleared

    @Succesfull
Scenario: Login with proper credentials
    Given I open mailbox page
    When I input login as "dfjwgge82h43g3uriy53h"
    And I choose domain as "@bk.ru"
    And I click Input password button on Login Page
    And input password as "PlOkIjUHYGC"
    And I click login button on Login Page
    Then I am on my inbox page
    And I exit account

        @WrongCredentials
Scenario: Login with wrong credentials
    Given I open mailbox page
    When I input login as "TestLogin1"
    And  I choose domain as "@list.ru"
    And I click Input password button on Login Page
    Then Wrong login message is visible

