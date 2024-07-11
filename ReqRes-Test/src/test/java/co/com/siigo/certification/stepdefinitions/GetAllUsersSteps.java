package co.com.siigo.certification.stepdefinitions;

import co.com.siigo.certification.questions.TheUserResponse;
import co.com.siigo.certification.tasks.GetUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.siigo.certification.utils.Constants.BASE_URL;
import static net.bytebuddy.matcher.ElementMatchers.is;

public class GetAllUsersSteps {
    @Given("user call an api")
    public void userCallAnApi() {
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("Marlon");
        SerenityRest.useRelaxedHTTPSValidation();
    }
    @When("calls the api to get the users")
    public void callsTheApiToGetTheUsers() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUsers.getUsers()
        );
    }
    @Then("should see users summary")
    public void shouldSeeUsersSummary() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheUserResponse.matches(1, 6, 12, 2))
        );
    }
}
