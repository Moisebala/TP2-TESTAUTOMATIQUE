package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Locations;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Mo-is-Balla on 2016-11-13.
 */
public class locationstep {

    ConfigurableApplicationContext context;
    LocationsRepository locationsRepository;
    ClientRepository clientRepository;

    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        locationsRepository = context.getBean(LocationsRepository.class);
        clientRepository=context.getBean(ClientRepository.class);
    }

    @Given("\"Paul\" est un nouveau client")
    public void givenPaulEstUnNouveauClient() {

    }
    @Given("\"Paul\"est un ancien client")
    public void givenPaulestUnAncienClient() {
    }
    @Given("la voiture \"A1\" est d\u00E9j\u00E0 lou\u00E9e \u00E0 \"Jean\"")
    public void givenLaVoitureA1EstDéjàLouéeÀJean() {

    }
    @When("\"Paul\" s\u00E9lectionne la voiture \"A1\"")
    public void whenPaulSélectionneLaVoitureA1() {

    }

    @Then("\"Paul\" est un client actif")
    public void thenPaulEstUnClientActif() {

    }

    @Then("la voiture \"A1\" est lou\u00E9e par \"Paul\"")
    public void thenLaVoitureA1EstLouéeParPaul() {
    }


    @Then("la voiture \"A1\" est lou\u00E9e par \"Jean\"")
    public void thenLaVoitureA1EstLouéeParJean() {
    }


}
