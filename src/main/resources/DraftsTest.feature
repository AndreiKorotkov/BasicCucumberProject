Feature: Saving a draft of a letter

@Drafts
  Scenario Outline:Saving drafts
Given I login to mailbox
  When I click "Write a letter" button
  And I enter <addressee> and <body> of the letter
  And I click Save a draft button
  And I click Close button
  And I click "Drafts" button
  And I click the first draft
  Then Adressee of the letter is <addressee> and body of the letter is <body>

  Examples:
  | addressee       | body                |
  | IvanIvanov      | This is test letter |
  | PetrPetrov      | This is test letter |
  | SidorSidorov    | This is test letter |