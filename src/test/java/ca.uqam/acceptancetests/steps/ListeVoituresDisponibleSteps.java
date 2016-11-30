package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class ListeVoituresDisponibleSteps {
    ConfigurableApplicationContext context;
    VehiculeRepository vehiculeRepository;
    Vehicule A1 =null;
    Vehicule A2 =null;
    List<Vehicule> vehiculeList =null;
    @BeforeScenario
    public void setUp(){
        context = SpringApplication.run(Config.class);
        vehiculeRepository = context.getBean(VehiculeRepository.class);

    }

    @Given("il y a 2 voitures disponibles")
    public void givenIlYA2VoituresDisponibles() {

    }

    @Given("la voiture \"A1\" est disponible")
    public void givenLaVoitureA1EstDisponible() {
        this.A1= vehiculeRepository.findByState(Etatvoiture.Disponile);

    }

    @Given("la voiture \"A2\" est disponible")
    public void givenLaVoitureA2EstDisponible() {
        this.A2= vehiculeRepository.findByState(Etatvoiture.Disponile);
    }
    @Given("la voiture \"A1\" est lou\u00E9e \u00E0 Paul")
    public void givenLaVoitureA1EstLouéeÀPaul() {
        this.A1= vehiculeRepository.findByState(Etatvoiture.Louer);
    }
    @When("je veux afficher la liste des voitures disponibles")
    public void whenJeVeuxAfficherLaListeDesVoituresDisponibles() {
        vehiculeList=vehiculeRepository.findAll();
        for (Vehicule temp:vehiculeList){
            if (temp.getState()==Etatvoiture.Disponile);
            {  vehiculeList.add(temp);}
        }

    }
    @When("je demande l\u2019affichage de la liste de toutes les voitures")
    public void whenJeDemandeLaffichageDeLaListeDeToutesLesVoitures() {
        // PENDING
    }

    @Then("la voiture \"A1\" est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA1EstIndiquéeCommeÉtantDisponible() {
        // PENDING
    }

    @Then("la voiture \"A2\" est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA2EstIndiquéeCommeÉtantDisponible() {
        // PENDING
    }


    @Then("la voiture \"A1\" est indiqu\u00E9e comme louee a Paul")
    public void thenLaVoitureA1EstIndiquéeCommeLoueeAPaul() {
        // PENDING
    }

    @Then("la voiture \"A2\"est indiqu\u00E9e comme \u00E9tant disponible")
    public void thenLaVoitureA2estIndiquéeCommeÉtantDisponible() {
        // PENDING
    }





}
