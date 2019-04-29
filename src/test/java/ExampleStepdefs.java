import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleStepdefs implements En {

    private Example example;

    private String message;

    public ExampleStepdefs() {
        Given("^I have something$", () ->
                example = new Example());

        When("^I get a message from it$", () ->
                message = example.message());

        Then("^it should say \"([^\"]*)\"$", (String result) ->
                assertThat(message).isEqualTo(result));
    }
}
