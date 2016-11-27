package ca.uqam.acceptancetests.steps;

import ca.uqam.model.Client;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class ListeVoituresDisponibleSteps {
    ConfigurableApplicationContext context;
    VehiculeRepository vehiculeRepository;
    List<Vehicule> vehicules = null;

    @Given("il y a 2 voitures disponibles")
    public void givenIlYA2VoituresDisponibles() {

    }

    @Given("la voiture A2 est disponible")
    public void givenLaVoitureA2EstDisponible() {

    }

    @When("je veux afficher la liste des voitures disponibles")
    public void whenJeVeuxAfficherLaListeDesVoituresDisponibles() {
        // PENDING
    }


    @When("je demande l\u2019affichage de la liste de toutes les voitures")
    public void whenJeDemandeLaffichageDeLaListeDeToutesLesVoitures() {
        this.vehicules=vehiculeRepository.findAll();
    }

    @Then("la voiture A1 est indiqu\u00E9e comme louee a Paul")
    public void thenLaVoitureA1EstIndiquéeCommeLoueeAPaul() {
        // PENDING
    }

    @Then("la voiture A3 est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA3EstIndiquéeCommeÉtantDisponible() {
        // PENDING
    }
    @Then("la voiture A1 est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA1EstIndiquéeCommeÉtantDisponible() {
        // PENDING
    }

    @Then("la voiture A2 est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA2EstIndiquéeCommeÉtantDisponible() {
        // PENDING
    }



}
