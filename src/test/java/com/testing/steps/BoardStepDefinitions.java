package com.testing.steps;

import com.testing.utils.TestSteps;
import com.POJOClasses.models.Board;
import io.cucumber.java.en.*;

public class BoardStepDefinitions {

    private final TestSteps ts = new TestSteps();

    @Given("I build a request for the Trello API")
    public void buildRequest() {
        ts.buildRequest();
    }

    @When("I send a GET request to {string}")
    public void sendGet(String endpoint) {
        ts.sendGetRequest(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void sendDelete(String endpoint) {
        ts.sendDeleteRequest(endpoint);
    }

    @When("I send a POST request to {string} with name {string}")
    public void sendPost(String endpoint, String name) {
        Board board = new Board();
        board.setName(name);
        ts.buildRequestWithBody(board);
        ts.sendPostRequest(endpoint);
    }

    @When("I send a PUT request to {string} with name {string}")
    public void sendPut(String endpoint, String name) {
        Board board = new Board();
        board.setName(name);
        ts.buildRequestWithBody(board);
        ts.sendPutRequest(endpoint);
    }

    @Then("the status code should be {int}")
    public void checkStatus(int statusCode) {
        ts.checkStatusCode(statusCode);
    }

    @Then("the response should not be empty")
    public void responseShouldNotBeEmpty() {
        ts.checkResponseIsValid();
    }
}
