package co.com.siigo.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheUserDeleteResponse implements Question<Boolean> {

    private final int expectedStatusCode;

    public TheUserDeleteResponse(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int actualStatusCode = actor.recall("deleteStatusCode");
        return actualStatusCode == expectedStatusCode;
    }

    public static TheUserDeleteResponse matches(int expectedStatusCode) {
        return new TheUserDeleteResponse(expectedStatusCode);
    }
}
