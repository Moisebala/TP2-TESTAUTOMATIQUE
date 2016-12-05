package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Vehicule;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class RetourVoitureSteps {
    ConfigurableApplicationContext context;
    Vehicule vehicule = null;

    @BeforeScenario
    public void setUp() {
        context = SpringApplication.run(Config.class);
    }
    @Given("La Voiture $matricule est a l'etat louer")
    public void givenLaVoitureEstALetatLouer(String matricule) {

    }

    @When("Je retourne la voiture $matricule")
    public void whenJeRetourneLaVoiture(String matrilcule) {

    }

    @Then("La voiture devrais avoir l'etat : $Disponible")
    public void thenLaVoitureDevraisAvoirLetatDisponible(String etat) {

    }

}
