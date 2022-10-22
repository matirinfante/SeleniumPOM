Feature: Automation practice Rahul Shetty

  Background:
    Given User is on homepage

  Scenario: User interacts with radio buttons
    When user clicks on a radio button
    Then radio button status is changed

  Scenario Outline: User search
    When user types and selects "<partialText>"
    Then search box should contain "<countryText>"
    Examples:
      | partialText | countryText |
      | el sal      | El Salvador |

  Scenario Outline: User interacts with dropdown and selects an option
    When user selects "<option>"
    Then selection must be "<optionText>"
    Examples:
      | option  | optionText |
      | option2 | Option2    |
      | option3 | Option3    |

  Scenario Outline: User interacts with nav bar
    When user clicks on "<button>"
    Then user is redirected to "<button>" page
    Examples:
      | button   |
      | Home     |
      | Practice |
      | Login    |
      | Signup   |

  Scenario Outline:
    When user clicks new tab button <times> times
    Then a <times> new tab is opened
    Examples:
      | times |
      | 9     |