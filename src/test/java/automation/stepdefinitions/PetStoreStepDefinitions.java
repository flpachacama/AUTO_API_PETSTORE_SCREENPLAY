package automation.stepdefinitions;

import automation.questions.LastResponseStatusCode;
import automation.tasks.CreatePet;
import automation.tasks.DeletePet;
import automation.tasks.GetPet;
import automation.tasks.UpdatePet;
import automation.util.PetData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PetStoreStepDefinitions {

    private static final String PET_NAME = "Firulais";
    private static final String UPDATED_PET_NAME = "FirulaisActualizado";
    private static final String PET_STATUS = "available";

    private Actor actor;
    private long petId;

    @Given("que el usuario crea una mascota")
    public void queElUsuarioCreaUnaMascota() {
        actor = OnStage.theActorCalled("api-user");
        petId = PetData.randomPetId();

        actor.attemptsTo(CreatePet.withData(petId, PET_NAME, PET_STATUS));

        assertThat("El POST debe responder 200", actor.asksFor(LastResponseStatusCode.value()), is(200));
    }

    @When("consulta la mascota creada")
    public void consultaLaMascotaCreada() {
        actor.attemptsTo(GetPet.byId(petId));

        assertThat("El GET debe responder 200", actor.asksFor(LastResponseStatusCode.value()), is(200));
        assertThat("El nombre de la mascota debe ser Firulais",
                SerenityRest.lastResponse().jsonPath().getString("name"),
                is(PET_NAME));
    }

    @And("actualiza la mascota")
    public void actualizaLaMascota() {
        actor.attemptsTo(UpdatePet.withData(petId, UPDATED_PET_NAME, PET_STATUS));

        assertThat("El PUT debe responder 200", actor.asksFor(LastResponseStatusCode.value()), is(200));
        assertThat("El nombre de la mascota debe actualizarse",
                SerenityRest.lastResponse().jsonPath().getString("name"),
                is(UPDATED_PET_NAME));
    }

    @And("elimina la mascota")
    public void eliminaLaMascota() {
        actor.attemptsTo(DeletePet.byId(petId));

        assertThat("El DELETE debe responder 200", actor.asksFor(LastResponseStatusCode.value()), is(200));
    }

    @Then("valida que la mascota ya no existe")
    public void validaQueLaMascotaYaNoExiste() {
        actor.attemptsTo(GetPet.byId(petId));

        assertThat("El GET posterior al DELETE debe responder 404",
                actor.asksFor(LastResponseStatusCode.value()),
                is(404));
    }
}
