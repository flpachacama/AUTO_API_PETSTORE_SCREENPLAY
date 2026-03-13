package automation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DeletePet implements Task {

    private final long petId;

    public DeletePet(long petId) {
        this.petId = petId;
    }

    public static DeletePet byId(long petId) {
        return Tasks.instrumented(DeletePet.class, petId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .pathParam("id", petId)
                .when()
                .delete("/v2/pet/{id}");
    }
}
