package co.com.siigo.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheUserResponse implements Question<Boolean> {

    private final int expectedPage;
    private final int expectedPerPage;
    private final int expectedTotal;
    private final int expectedTotalPages;

    public TheUserResponse(int expectedPage, int expectedPerPage, int expectedTotal, int expectedTotalPages) {
        this.expectedPage = expectedPage;
        this.expectedPerPage = expectedPerPage;
        this.expectedTotal = expectedTotal;
        this.expectedTotalPages = expectedTotalPages;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int actualPage = actor.recall("page");
        int actualPerPage = actor.recall("perPage");
        int actualTotal = actor.recall("total");
        int actualTotalPages = actor.recall("totalPages");

        return actualPage == expectedPage &&
                actualPerPage == expectedPerPage &&
                actualTotal == expectedTotal &&
                actualTotalPages == expectedTotalPages;
    }

    public static TheUserResponse matches(int expectedPage, int expectedPerPage, int expectedTotal, int expectedTotalPages) {
        return new TheUserResponse(expectedPage, expectedPerPage, expectedTotal, expectedTotalPages);
    }
}
