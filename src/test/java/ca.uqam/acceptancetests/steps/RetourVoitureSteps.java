package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.console.App;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import net.thucydides.core.annotations.Pending;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class RetourVoitureSteps {
    ConfigurableApplicationContext context;
    LocationsRepository locationsRepository;
    ClientRepository clientRepository;
    VehiculeRepository vehiculeRepository;
    Locations location =null;

    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        locationsRepository =context.getBean(LocationsRepository.class);


    }
    @Given("Une voiture $A1 louee par un $client")
    public void givenUneVoitureA1LoueeParUnclientavecidentifiant(Vehicule voiture ,Client client) {
       this.location = new Locations(client,voiture);

    }

    @When("\"client\" retourne la voiture $A1 avec son $Permit")
    public void whenclientRetourneLaVoitureA1AvecSonPermit(Vehicule voiture ,String permit) {
     voiture =App.verifierlocation(permit);

    }

    @Then("l'etat de la voiture $A1 est a Disponible")
    public void thenLetatDeLaVoitureA1EstADisponible(Vehicule voiture) {
       assertEquals(Etatvoiture.Disponile,voiture.getState());
    }


}
