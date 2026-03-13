package automation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class UpdatePet implements Task {

    private final long petId;
    private final String petName;
    private final String status;

    public UpdatePet(long petId, String petName, String status) {
        this.petId = petId;
        this.petName = petName;
        this.status = status;
    }

    public static UpdatePet withData(long petId, String petName, String status) {
        return Tasks.instrumented(UpdatePet.class, petId, petName, status);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> requestBody = Map.of(
                "id", petId,
                "name", petName,
                "status", status
        );

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/v2/pet");
    }
}
