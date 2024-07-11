package co.com.siigo.certification.tasks;

import co.com.siigo.certification.utils.Headers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.siigo.certification.utils.Constants.USERS;

public class DeleteUser implements Task {
    private final String userId;

    public DeleteUser(String userId) {
        this.userId = userId;
    }
    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Post.to(String.format(USERS) + userId).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue()))
        );
        int statusCode = SerenityRest.lastResponse().statusCode();
        t.remember("deleteStatusCode", statusCode);
        System.out.println("Delete Status Code: " + statusCode);
    }
    public static DeleteUser withId(String userId) {
        return Tasks.instrumented(DeleteUser.class, userId);
    }
}
