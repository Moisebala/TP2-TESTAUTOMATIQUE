package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.repositories.ClientRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static ca.uqam.console.App.afficherClient;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-23.
 */
public class AfficherclientStep {
    ConfigurableApplicationContext context;
    ClientRepository clientRepository;
    Client paul =null;
    Client jean =null;
    List<Client> clientList= null;

    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        clientRepository = context.getBean(ClientRepository.class);

    }
    @AfterScenario
    public void tearDown(){
        context.close();
    }
    @Given("\"Paul\" est un client enregistr\u00E9")
    public void givenPaulEstUnClientEnregistré() {
        //paul =new Client("MA0011","paul","Baeur","5140004545","11 uqam");
       // clientList.add(paul);
    }
    @Given("\"Jean\" est un client enregistr\u00E9")
    public void givenJeanEstUnClientEnregistré() {
        //jean =new Client("MA0010","Jean","Baeur","5140004545","11 uqam");
       // clientList.add(jean);
    }
    @When("j'affiche la liste des clients")
    public void whenJafficheLaListeDesClients() {clientList =clientRepository.findAll();
    }
    @Then("\"Paul\" est dans la liste affich\u00E9e")
    public void thenPaulEstDansLaListeAffichée() {assertEquals(true ,clientList.contains(paul));
    }
    @Then("\"Jean\" est dans la liste affich\u00E9e")
    public void thenJeanEstDansLaListeAffichée() {
        assertEquals(true,clientList.contains(jean));
    }

}
