Feature: Bonusprint simple test

  Scenario: Verify that saved projects is restricted to logged in users
    Given the Bonusprint home page is open
#    And I am not logged in
    And I click on the My Account link
    When I click on the Saved projects link
    Then I expect to see the login form

#  Scenario: Verify that saved projects is available for logged in users
#    Given the Bonusprint home page is open and I am logged in
#    When I click on the Saved projects link
#    Then I expect to see the Saved projects
#
#  Scenario: Verify that I can access saved project after registering as a new user
#    Given the Bonusprint home page is open and I am not logged in
#    When I click on the login link
#    Then I expect to see the login form
#    When I click on the "continue as new customer button"
#    Then I I expect to see the create account form
#    When I enter credentials
#    And I click register
#    Then I expect to see the My accounts section


