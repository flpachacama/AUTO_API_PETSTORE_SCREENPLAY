package automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/petstore_crud.feature",
        glue = {"automation.hooks", "automation.stepdefinitions"}
)
public class PetStoreRunner {
}
