Feature: ToDo App Tests

  Background:
#  Given I'm on todo app page

  Scenario: Todo items and filter preferences are preserved
    Given todo list is empty
    When I add todo "test"
    And I set filter to "active"
    And I refresh page
    Then todo "test" is in the list
    And filter remains "active"

  Scenario Outline: Newly added todo is in active status
    When I add todo "<label>"
    Then todo "<label>" is "active"

    Examples:
    |label                  |
    |awesome idea           |
    |yet another thing to do|

  Scenario Outline: Existing todo can be updated
    Given I add todo "<new>"
    When I update todo "<new>" to "<updated>"
    Then todo "<updated>" is in the list
    And todo "<new>" is not in the list

    Examples:
    |new              |updated          |
    |Meeting on Monday|Meeting on Friday|

  Scenario Outline: Existing todo can be deleted
    Given I add todo "<label>"
    When I delete todo "<label>"
    Then todo "<label>" is not in the list

    Examples:
    |label         |
    |take some rest|

  Scenario: empty todo cannot be added
    When I add todo ""
    Then todo "" is not in the list


  Scenario: Mark all todo as completed
    Given todo list is empty
    And I add todo "1st"
    And I add todo "2nd"
    And I add todo "3rd"
    When I complete todo "2nd"
    And I mark all as completed
    Then all todos in the list are "completed"

  Scenario: ToDo list can be filtered by status
    Given todo list is empty
    When I add todo "1st"
    And I add todo "2nd"
    And I add todo "3rd"
    Then there are 3 todos are displayed

    When I complete todo "1st"
    And I set filter to "active"
    Then there are 2 todos are displayed
    And todo "2nd" is in the list
    And todo "3rd" is in the list
    But todo "1st" is not in the list

    When I set filter to "completed"
    Then there are 1 todos are displayed
    And todo "1st" is in the list
    But todo "2nd" is not in the list
    And todo "3rd" is not in the list

    




