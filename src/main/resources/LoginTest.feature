Feature: Login to inbox
    I want to login to my mailbox
# Tags: optional
    @Succesfull
Scenario: Login with proper credentials
    Given I open mailbox page
    When I input login as "dfjwgge82h43g3uriy53h"
    And I choose domain as "@bk.ru"
    And I click Input password button
    And input password as "PlOkIjUHYGC"
    And I click login button
    Then I am on my inbox page

Scenario: Login with wrong credentials
    Given I open mailbox page
    When I input login as "TestLogin1"
    And  I choose domain as "@list.ru"
    And I click Input password button
    Then "Wrong login message" is visible

