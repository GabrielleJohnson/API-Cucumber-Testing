package com.testing.utils;

import io.cucumber.java.en.*;
import com.POJOClasses.models.Board;
import org.testng.Assert;

public class ApiStepDefinitions {

    private final TestSteps steps = new TestSteps();
    private Board board;

    @Given("I build a request")
    public void i_build_a_request() {
        steps.buildRequest();
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        steps.sendGetRequest(endpoint);
        steps.checkResponseIsValid();
        board = steps.getResponse().as(Board.class);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer expected) {
        steps.checkStatusCode(expected);
    }

    @Then("the response should not be empty")
    public void the_response_should_not_be_empty() {
        Assert.assertNotNull(board);
    }

    @Then("the board should have valid label names")
    public void board_has_valid_label_names() {
        Assert.assertNotNull(board.getLabelNames(), "LabelNames object should not be null");

        Assert.assertNotNull(board.getLabelNames().getGreen(), "Green label should not be null");
        Assert.assertNotNull(board.getLabelNames().getBlue(), "Blue label should not be null");
        Assert.assertNotNull(board.getLabelNames().getRed(), "Red label should not be null");
    }

    @Then("the board should have valid preferences")
    public void board_has_valid_preferences() {
        Assert.assertNotNull(board.getPrefs(), "Prefs should not be null");
        Assert.assertNotNull(board.getPrefs().getPermissionLevel(), "Permission level should not be null");
        Assert.assertNotNull(board.getPrefs().getVoting(), "Voting should not be null");
        Assert.assertNotNull(board.getPrefs().getBackground(), "Background should not be null");
    }
}
