Feature: Sample FB feature Test



  Scenario: Enter First and Last Name as PARAMETER
    Given FB page is in open
    When I enter values Test and User
    Then I Should see the values
    And I enter email address testmail@gmail.com
    And I reenter email address testmail@gmail.com
    And I enter new password '1234567'
    And I select month 1
    And I select day 4
    And I select year 2000
    And I select gender female
    Then I press Create account button
