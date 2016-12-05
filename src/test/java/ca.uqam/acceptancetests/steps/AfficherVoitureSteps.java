package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Vehicule;
import ca.uqam.model.VehiculeListe;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeListRepository;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-12-05.
 */
public class AfficherVoitureSteps {
    ConfigurableApplicationContext context;
    VehiculeListRepository vehiculeListRepository;
    VehiculeListe liste=null;
    Vehicule vehicule = null;
    Etatvoiture Disponible=Etatvoiture.Disponible;

    @BeforeScenario
    public void setUp() {
        context = SpringApplication.run(Config.class);
        vehiculeListRepository=context.getBean(VehiculeListRepository.class);
    }
    @Given("Une voiture enregistre avec le matricule : $matricule")
    public void givenUneVoitureEnregistreAvecLeMatricule20162004(String matricule) {
        this.liste=vehiculeListRepository.findByEtat(Disponible);
        this.vehicule=liste.getVehicules(matricule);
    }
    @When("Je cherche la voiture")
    public void whenJeChercheLaVoiture() {
       assertEquals(this.vehicule.equals(null),false);
    }

    @Then("Je devrais avoir les detailles de la voiture : $Matricule $Marque  $Model  $Type> $Year  $Price $Etat")
    public void thenJeDevraisAvoirLesDetaillesDeLaVoitureMatriculeMarqueModelTypeYearPriceEtat(String Matricule,
                                                                                               String Marque,
                                                                                               String Model,
                                                                                               String Type,
                                                                                               String Year,
                                                                                               String Price,
                                                                                               Etatvoiture Etat) {

        assertEquals(Matricule,this.vehicule.getMatricule());
        assertEquals(Marque ,this.vehicule.getMarque());
        assertEquals(Model ,this.vehicule.getModel());
        assertEquals(Type ,this.vehicule.getType());
        assertEquals(Year ,this.vehicule.getYear());
        assertEquals(Price,this.vehicule.getPrice());
        assertEquals(Etat,this.vehicule.getState());



    }

}
