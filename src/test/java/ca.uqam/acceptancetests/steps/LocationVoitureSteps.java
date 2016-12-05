package ca.uqam.acceptancetests.steps;

import ca.uqam.config.Config;
import ca.uqam.console.App;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Vehicule;
import ca.uqam.model.VehiculeListe;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeListRepository;
import org.jbehave.core.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mo-is-Balla on 2016-11-16.
 */
public class LocationVoitureSteps {
    ConfigurableApplicationContext context;
    ClientRepository clientRepository;
    VehiculeListRepository vehiculeListRepository;
    LocationsRepository locationsRepository;
    Client client=null;
    VehiculeListe liste=null;
    Vehicule vehicule = null;
    Etatvoiture Disponible=Etatvoiture.Disponible;

    @BeforeScenario
    public void setUp() {
        context = SpringApplication.run(Config.class);
        clientRepository = context.getBean(ClientRepository.class);
        vehiculeListRepository=context.getBean(VehiculeListRepository.class);
        locationsRepository=context.getBean(LocationsRepository.class);
    }
    @Given("Un client enregistre avec un permis : $permis")

    public void givenUnClientEnregistreAvecUnPermisAM002310(String permis) {
        this.client=clientRepository.findByPermisnumber(permis);
    }

    @Given("Une voiture enregistre avec le matricule : $matricule")
    public void givenUneVoitureEnregistreAvecLeMatricule20162004(String matricule) {
       this.liste=vehiculeListRepository.findByEtat(Disponible);
        this.vehicule=liste.getVehicules(matricule);
    }

    @When("Le client AM002310  loue la voiture 20162004")
    public void whenLeClientAM002310LoueLaVoiture20162004() {
        String v = this.client.getPermisnumber()+","+this.vehicule.getMatricule();
        this.vehicule=App.LocationVoiture(v);
    }
    @When("Le client AM002310 retourne la voiture 20162004")
    public void whenLeClientAM002310RetourneLaVoiture20162004() {
        String v = this.client.getPermisnumber()+","+this.vehicule.getMatricule();
        this.vehicule=App.Retourlocation(v);
    }
    @Then("L'etat de la voiture 20162004 devrais etre : $Louer")
    public void thenLetatDeLaVoiture20162004DevraisEtreLouer(Etatvoiture Etat) {
        assertEquals(Etat,this.vehicule.getState());
    }

    @Then("La voiture 20162004 devrais avoir l'etat : $Disponible")
    public void thenLaVoiture20162004DevraisAvoirLetatDisponible(Etatvoiture Etat) {
        assertEquals(Etat,this.vehicule.getState());
    }

}
