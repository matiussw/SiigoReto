Feature: call api successfully
  I need to call the get API to post users
  to create the a users

  Background: call endpoint
    Given user call an api

  Scenario: call api employee create
    When calls the api to create a user
    Then should see the users create