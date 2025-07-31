Feature: Login Feature

@sanity @regression
Scenario Outline: Verify Valid Login journey
  Given User in on the login page
  And user enters valid "<username>" and valid "<password>"
  When user clicks on the login button
  Then User should see the Home page
  Examples:
    | username        | password   |
    | kafka@gmail.com | MS$2025#   |
    | mithun@ta.com   | Mithun123  |
@sanity
Scenario Outline: Verify in-Valid Login journey
  Given User in on the login page
  And user enters invalid "<username>" and valid "<password>"
  When user clicks on the login button
  Then User should see the Error message
  Examples:
    | username       | password   |
    | wrong@email.com| MS$2025#   |
    | wrong@ta.com   | Mithun123  |
    

@regression
Scenario Outline: Verify in-Valid Login journey
  Given User in on the login page
  And user enters invalid "<username>" and invalid "<password>"
  When user clicks on the login button
  Then User should see the Error message
  Examples:
    | username       | password   |
    | wrong@email.com| wrongpass  |
    | wrong@ta.com   | wrongpass  |

@regression
Scenario Outline: Verify in-Valid Login journey
  Given User in on the login page
  And user enters valid "<username>" and invalid "<password>"
  When user clicks on the login button
  Then User should see the Error message
  Examples:
    | username        | password  |
    | kafka@gmail.com | wrongpass |
    | mithun@ta.com   | wrongpass |

    