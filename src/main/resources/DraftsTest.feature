@DraftsTest
Feature: Saving a draft of a letter

  @All
  Scenario: Login to mailbox
    Given I login to mailbox
    When I go to Drafts folder
    Then I am on my inbox page

  @Drafts
  Scenario Outline:Saving drafts
    Given I am on my inbox page
    When I click Write a letter button
    And I enter <addressee> and <body> of the letter
    And I click Save a draft button
    And I click Close button
    And I go to Drafts folder
    And I click the first draft
    Then I check <addressee> and <body> of the letter

    Examples:
      | addressee            | body                |
      | IvanIvanov@mail.ru   | This is test letter |
      | PetrPetrov@mail.ru   | This is test letter |
      | SidorSidorov@mail.ru | This is test letter |

  Scenario:  Delete all drafts
    Given There is at least one draft
    When I click Select all button
    And Click Delete
    Then I check there is no drafts in the Drafts folder