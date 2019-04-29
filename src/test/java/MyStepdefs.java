import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs implements En {

    private Something something;

    private String message;

    public MyStepdefs() {
        Given("^I have something$", () ->
                something = new Something());

        When("^I get a message from it$", () ->
                message = something.message());

        Then("^it should say \"([^\"]*)\"$", (String result) ->
                assertThat(message).isEqualTo(result));
    }
}
