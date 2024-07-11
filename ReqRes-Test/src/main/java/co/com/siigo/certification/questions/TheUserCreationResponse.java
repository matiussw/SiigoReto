package co.com.siigo.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheUserCreationResponse implements Question<Boolean> {

    private final String expectedName;
    private final String expectedJob;

    public TheUserCreationResponse(String expectedName, String expectedJob) {
        this.expectedName = expectedName;
        this.expectedJob = expectedJob;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String responseBody = actor.recall("apiResponse");
        String actualName = SerenityRest.lastResponse().jsonPath().getString("name");
        String actualJob = SerenityRest.lastResponse().jsonPath().getString("job");

        return expectedName.equals(actualName) && expectedJob.equals(actualJob);
    }

    public static TheUserCreationResponse matches(String expectedName, String expectedJob) {
        return new TheUserCreationResponse(expectedName, expectedJob);
    }
}
