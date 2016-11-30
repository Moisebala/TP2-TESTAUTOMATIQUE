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
    Client paul =null;
    Client jean =null;
    List<Client> clientList=null;


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
    public void givenPaulEstUnClientEnregistré(String permisnumber) {
      this.paul=clientRepository.findByPermisnumber(permisnumber);
    }
    @Given("\"Jean\" est un client enregistr\u00E9")
    public void givenJeanEstUnClientEnregistré(String permisnumber) {
      this.jean=clientRepository.findByPermisnumber(permisnumber) ;

    }
    @When("j'affiche la liste des clients")
    public void whenJafficheLaListeDesClients() {
        this.clientList =clientRepository.findAll();

    }
    @Then("\"Paul\" est dans la liste affich\u00E9e")
    public void thenPaulEstDansLaListeAffichée() {assertEquals(true ,this.clientList.contains(this.paul));
    }
    @Then("\"Jean\" est dans la liste affich\u00E9e")
    public void thenJeanEstDansLaListeAffichée() {
        assertEquals(true,this.clientList.contains(this.jean));
    }

}
