package co.com.siigo.certification.tasks;

import co.com.siigo.certification.utils.Headers;
import io.cucumber.java.be.I;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.siigo.certification.utils.Constants.USERS;

public class UpdateUser implements Task {
    private final String userId;
    private final String name;
    private final String job;

    public UpdateUser(String userId, String name, String job) {
        this.userId = userId;
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Post.to(String.format(USERS) + userId).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue())
                        .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                )
        );
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        t.remember("apiResponse", responseBody);
    }


    public static UpdateUser updateUser(String userId, String name, String job) {
        return Tasks.instrumented(UpdateUser.class, userId, name, job);
    }
}
