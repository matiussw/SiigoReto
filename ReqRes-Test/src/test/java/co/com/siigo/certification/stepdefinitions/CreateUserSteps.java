package co.com.siigo.certification.stepdefinitions;

import co.com.siigo.certification.questions.TheUserCreationResponse;
import co.com.siigo.certification.questions.TheUserResponse;
import co.com.siigo.certification.tasks.CreateUser;
import co.com.siigo.certification.tasks.GetUsers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class CreateUserSteps {

    @When("calls the api to create a user")
    public void callsTheApiToCreateAUser() {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.createUser("morpheus2", "leader")
        );
    }
    @Then("should see the users create")
    public void shouldSeeTheUsersCreate() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheUserCreationResponse.matches("morpheus2", "leader"))
        );
    }

}
