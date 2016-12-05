package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.console.App;
import ca.uqam.model.Client;
import ca.uqam.repositories.ClientRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mo-is-Balla on 2016-11-23.
 */
public class AfficherclientStep {
    ConfigurableApplicationContext context;
    ClientRepository clientRepository;
    Client client =null;

    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        clientRepository = context.getBean(ClientRepository.class);

    }
    @AfterScenario
    public void tearDown(){
        context.close();
    }

    @Given("On a une base de recherche de client avec un permis P1")
    public void givenLeclientExisteDansLaBase() {

    }

    @When("Je cherche le client A1 avec sont permis : $P1")
    public void whenJeChercherLeclientAvecSontPermisAM002300(String permis) {
        this.client= App.rechercheClient1(permis);
    }

    @Then("je devrais avoir les detailles de client A1: $Nom $Prenom $Numerotel $Adresse")
    public void thenJeDevraisAvoirLesDetaillesDeclient(String Nom,
                                                       String Prenom,
                                                       String Numerotel,
                                                       String Adresse) {
        assertEquals(Nom,this.client.getFirstName());
        assertEquals(Prenom,this.client.getLastName());
        assertEquals(Numerotel,this.client.getPhone());
        assertEquals(Adresse,this.client.getAdresse());
    }

}
