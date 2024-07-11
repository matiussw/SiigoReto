package co.com.siigo.certification.tasks;

import co.com.siigo.certification.utils.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static co.com.siigo.certification.utils.Constants.USERS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GetUsers implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Get.resource(String.format(USERS)).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue())
                )
        );
        int page = lastResponse().jsonPath().getInt("page");
        int perPage = lastResponse().jsonPath().getInt("per_page");
        int total = lastResponse().jsonPath().getInt("total");
        int totalPages = lastResponse().jsonPath().getInt("total_pages");

        t.remember("page", page);
        t.remember("perPage", perPage);
        t.remember("total", total);
        t.remember("totalPages", totalPages);
    }

    public static GetUsers getUsers() {
        return Tasks.instrumented(GetUsers.class);
    }
}
