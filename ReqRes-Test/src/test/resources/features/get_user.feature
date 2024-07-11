Feature: call api successfully
  I need to call the get API to get users
  to validate the users exist

  Background: call endpoint
    Given user call an api

  Scenario: call api employee create
    When calls the api to get the users
    Then should see users summary