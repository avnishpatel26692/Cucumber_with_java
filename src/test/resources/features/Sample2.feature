Feature: Check Age page functionality

@Sample2
Scenario: Check Age page functionality for Adult
When User navigates to Age page
  And User enter name "ABC"
  And User enter age "40"
  And User clicks on submit button
Then User see message "Hello, ABC, you are an adult"