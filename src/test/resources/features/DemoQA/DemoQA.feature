Feature: User sign up form

  @demoqa
  Scenario: User wants to go to Forms page
    Given user is in DemoQA page
    When user clicks on Forms card
    Then user should be redirected to Forms page

  @demoqa
  Scenario: User selects practice form from menu
    Given user is in DemoQA Forms page
    When user clicks on practice form
    Then user is should be redirected to Practice Form page

  @form @demoqa
  Scenario Outline: User fills the sign up form
    Given user is in DemoQA Practice Form page
    When user enters "<firstName>" and "<lastName>"
    And user enters "<email>" in email
    And user enters "<mobileNumber>" in mobile
    And user enters "<address>" in current address
    And user enters "<subjects>" in subject
    And user selects "<gender>" in gender
    And user selects "<day>" "<month>" "<year>" in calendar
    And user selects "<hobbiesRef>" in hobbies
    And user uploads "<imagePath>"
    And user selects <stateRef> and <cityRef>
    And user clicks submit button
    Then modal shows data
      | <firstName> <lastName> | <email> | <gender> | <mobileNumber> | <birthDate> | <subjects> | <hobbies> | <imageRef> | <address> | <stateCity> |
    Examples:
      | firstName | lastName | email           | mobileNumber | address        | gender | birthDate       | hobbiesRef | hobbies       | imagePath                        | stateRef | cityRef | stateCity | day | month | year | imageRef | subjects               |
      | Matias    | Inf      | unMail@mail.com | 1234567890   | An address 123 | Male   | 07 January,2022 | 3,1        | Music, Sports | C:\Users\Matias\Desktop\bird.jpg | 1        | 3       | NCR Noida | 07  | 1     | 1997 | bird.jpg | Arts, Computer Science |

