Feature: Trello Board API Testing

  Scenario: Create a new board
    Given I build a request for the Trello API
    When I send a POST request to "/boards/" with name "New Board"
    Then the status code should be 200
    And the response should not be empty

  Scenario: Get an existing board
    Given I build a request for the Trello API
    When I send a GET request to "/boards/675abc123xyz"
    Then the status code should be 200
    And the response should not be empty

  Scenario: Update a board name
    Given I build a request for the Trello API
    When I send a PUT request to "/boards/675abc123xyz" with name "Updated Board"
    Then the status code should be 200
    And the response should not be empty

  Scenario: Delete a board
    Given I build a request for the Trello API
    When I send a DELETE request to "/boards/675abc123xyz"
    Then the status code should be 200
