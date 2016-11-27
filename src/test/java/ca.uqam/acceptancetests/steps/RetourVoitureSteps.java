package ca.uqam.acceptancetests.steps;

import ca.uqam.model.Client;
import ca.uqam.model.Locations;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import net.thucydides.core.annotations.Pending;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class RetourVoitureSteps {
    ConfigurableApplicationContext context;
    LocationsRepository locationsRepository;
    List<Locations> locations = null;
    @Given("la voiture A1 est lou\u00E9e \u00E0 Paul")
    public void givenLaVoitureA1EstLouéeÀPaul() {
        // PENDING
    }

    @When("Paul retourne la voiture A1")
    public void whenPaulRetourneLaVoitureA1(Long clientID) {
        this.locations=locationsRepository.findByClientID(clientID);
    }

    @Then("A1 est disponible")
    public void thenA1EstDisponible() {
        System.out.println(this.locations.toString());
    }
}
