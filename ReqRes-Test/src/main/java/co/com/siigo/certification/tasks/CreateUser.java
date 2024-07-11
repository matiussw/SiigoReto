package co.com.siigo.certification.tasks;

import co.com.siigo.certification.utils.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.siigo.certification.utils.Constants.USERS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CreateUser implements Task {

    private final String name;
    private final String job;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Post.to(String.format(USERS)).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue())
                        .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                )
        );

        // Guardar la respuesta de la API
        String responseBody = lastResponse().getBody().asString();
        t.remember("apiResponse", responseBody);
    }

    public static CreateUser createUser(String name, String job) {
        return Tasks.instrumented(CreateUser.class, name, job);
    }

}
