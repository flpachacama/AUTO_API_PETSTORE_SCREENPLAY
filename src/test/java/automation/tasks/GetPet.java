package automation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetPet implements Task {

    private final long petId;

    public GetPet(long petId) {
        this.petId = petId;
    }

    public static GetPet byId(long petId) {
        return Tasks.instrumented(GetPet.class, petId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .pathParam("id", petId)
                .when()
                .get("/v2/pet/{id}");
    }
}
