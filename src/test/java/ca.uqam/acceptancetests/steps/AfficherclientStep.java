package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.repositories.ClientRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-23.
 */
public class AfficherclientStep {
    ConfigurableApplicationContext context;
    ClientRepository clientRepository;
    List<Client> client = null;

    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        clientRepository = context.getBean(ClientRepository.class);
    }
    @AfterScenario
    public void tearDown(){
        context.close();
    }

    @Given("il y a 2 clients enregistr\u00E9s PAUL et JEAN")
    public void givenIlYA2ClientsEnregistrésPAULEtJEAN() {

    }

    @When("je veux afficher la liste de nos clients")
    public void whenJeVeuxAfficherLaListeDeNosClients() {
        this.client =clientRepository.findAll();
    }

    @Then("PAUL et JEAN sont afficher")
    public void thenPAULEtJEANSontAfficher() {
        System.out.println(this.client.toString());
    }
}
