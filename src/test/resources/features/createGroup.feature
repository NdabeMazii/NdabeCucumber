@createGroup @Regression
Feature: createGroup

  Scenario Outline: as admin user i want to login to ndosi website
    Given i am on the login page
    And i enter my email <email>
    And i enter my password <password>
    When i click on the login button
    Then i should be logged in successfully
    And I click on the logged user
    And I click on the admin panel
    And I click on the groups button
    And I click on the create new group button
    And I enter group name <groupName>
    And I enter group description <groupDescription>
    And I enter year <year>
    And I enter max capacity <maxCapacity>
    And I enter start date <startDate>
    And I enter end date <endDate>
    When I click on the create group button
    Then i should see the group created successfully
    Examples:
      | email           | password  | groupName   | groupDescription | year | maxCapacity | startDate | endDate |
      | admin@gmail.com | @12345678 | NdabeGroup1 | Cucumber         | 2026 | 50          | 12345     | 54321   |


