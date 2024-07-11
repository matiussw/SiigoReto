Feature: call api successfully
  I need to call the get API to delete users
  to validate the users is delete

  Background: call endpoint
    Given user call an api

  Scenario: call api employee create
    When calls the api to delete the users
    Then should see users delete