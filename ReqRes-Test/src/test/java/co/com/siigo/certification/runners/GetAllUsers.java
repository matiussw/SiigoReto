package co.com.siigo.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/get_user.feature",
        glue = "co.com.siigo.certification.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class GetAllUsers {
}
