package automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ApiHooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @After
    public void drawTheCurtain() {
        OnStage.drawTheCurtain();
    }
}
