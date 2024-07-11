package co.com.siigo.certification.stepdefinitions;

import co.com.siigo.certification.questions.TheUserResponse;
import co.com.siigo.certification.questions.TheUserUpdateResponse;
import co.com.siigo.certification.tasks.GetUsers;
import co.com.siigo.certification.tasks.UpdateUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class UpdateUserStep {

    @When("calls the api to update a user")
    public void callsTheApiToUpdateAUser() {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.updateUser("1", "morpheus21", "zion resident")
        );
    }

    @Then("should see the users update")
    public void shouldSeeTheUsersUpdate() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(TheUserUpdateResponse.matches("morpheus21", "zion resident"))
        );
    }


}
