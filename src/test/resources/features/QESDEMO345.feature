Feature: Registration

  Scenario Outline:Valid Registration

    Given I am on the home page DEMO
    When I click on 'My Account' button on top right side
    And In dropdown I click on 'Register' button
    And I am fill the registration form: "<name>", "<surname>", "<telephone>", "<password>", "<password confirm>"
    And I am fill email field "random"
    And I am click on 'Subscribe' radio button
    And I am click on 'Privacy Policy' checkbox button
    And I click on 'Continue' button
    And I click on next 'Continue' button
    Then On the left side I see 'My Account' block, 'My Orders' block and below 'My Account' is 'Edit your account information'
    Examples:
    |name  |surname|telephone|password|password confirm|
    |Arturs| Afa   |22334455 |Artur30 |Artur30         |