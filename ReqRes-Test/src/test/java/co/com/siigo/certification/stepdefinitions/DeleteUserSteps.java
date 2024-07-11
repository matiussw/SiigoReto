package co.com.siigo.certification.stepdefinitions;

import co.com.siigo.certification.questions.TheUserDeleteResponse;
import co.com.siigo.certification.questions.TheUserResponse;
import co.com.siigo.certification.tasks.CreateUser;
import co.com.siigo.certification.tasks.DeleteUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class DeleteUserSteps {
    @When("calls the api to delete the users")
    public void callsTheApiToDeleteTheUsers() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.withId("1")
        );
    }
    @Then("should see users delete")
    public void shouldSeeUsersDelete() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheUserDeleteResponse.matches(201))
        );
    }
}
