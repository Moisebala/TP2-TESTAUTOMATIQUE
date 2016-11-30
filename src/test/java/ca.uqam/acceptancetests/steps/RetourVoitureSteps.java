package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import net.thucydides.core.annotations.Pending;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class RetourVoitureSteps {
    ConfigurableApplicationContext context;
    VehiculeRepository vehiculeRepository;
    ClientRepository  clientRepository;
    LocationsRepository locationsRepository;
    Locations location =null;
    Client client =null;
    Vehicule vehicule =null;


    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        vehiculeRepository = context.getBean(VehiculeRepository.class);

    }

    @Given("Voiture \"A1\" est a l'etat louer")
    public void givenVoitureA1EstALetatLouer(Long id) {
        this.vehicule=locationsRepository.findByIdVehicule(id);
    }

    @Given("\"Paul\" est locataire de voiture \"A1\"")
    public void givenPaulEstLocataireDeVoitureA1(String permis) {
        this.client=clientRepository.findByPermisnumber(permis);
    }

    @When("J'entre le numero de permis de \"Paul\"")
    public void whenJentreLeNumeroDePermisDePaul(String permis) {

    }

    @Then("Voite \"A1\" est l'etat disponible")
    public void thenVoiteA1EstLetatDisponible() {
        assertEquals("Disponible",vehicule.getState());
    }

}
