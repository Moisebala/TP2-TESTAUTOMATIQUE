package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static ca.uqam.console.Main.*;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */

public class App {
    //static ConfigurableApplicationContext context = SpringApplication.run(Config.class);
    static ClientRepository repository = context.getBean(ClientRepository.class);
    static VehiculeRepository repository1= context.getBean(VehiculeRepository.class);
    static LocationsRepository repository2=context.getBean(LocationsRepository.class);
    static ArrayList<Locations> listeLocations = new ArrayList<Locations>();
    private App(){
        //Constructor par defaut
    }
    //initialiser la base de donnees
    public static void initialisationBase() {
        repository1.save(new Vehicule("78959600","Toyota","Camry","Sedan","2016","120",Etatvoiture.Disponile));
        repository1.save(new Vehicule("20162009","Honda","Accord","SEDAN","2016","120", Etatvoiture.Disponile));
        repository1.save(new Vehicule("20162010","gip","Accord","SEDAN","2016","120", Etatvoiture.Disponile));

        repository.save(new Client("AM002300","Armelle","Tenekeu","5147718969","1345 rue saint charles"));
        repository.save(new Client("AM002310","Mama","Kouboura","5146740886","1345 chemin de Chambly"));
        repository.save(new Client("AM002312","Moussa","Balla","5146212124","1345 rue de la barre"));

    }

    public static ArrayList<Vehicule> allCars() {
        ArrayList<Vehicule> list_voitures = new ArrayList<Vehicule>();
        Iterable<Vehicule> voitures = repository1.findAll();
        for (Vehicule voiture : voitures)
            list_voitures.add(voiture);
        return list_voitures;
    }

    public static ArrayList<Locations> allLocations() {
        ArrayList<Locations> list_locations = new ArrayList<Locations>();
        Iterable<Locations> locations = repository2.findAll();
        for (Locations location : locations)
            list_locations.add(location);
        return list_locations;
    }


    public static void afficherClient() {
        List<Client> customers = repository.findAll();
        for (Client customer : customers){
            System.out.println(customer);
        }
    }

    //methode verification de location
    static Vehicule verifierlocation(String permis){
        Client clientConcerne = rechercheClient(permis);
        Locations locations =repository2.findByClient(clientConcerne);
        Vehicule voitureConcerne = repository1.findOne(locations.getIdVehicule());
        afficherlocation();
       if (locations.getIdVehicule()==voitureConcerne.getIdVehicule()){
            changeretat(voitureConcerne);
            locations.setDateOfReturn(new Date());
            repository2.delete(locations);
        }
        return  voitureConcerne;
    }
    static void saveLocation(Client client , Vehicule voiture){
        Locations location =repository2.save(new Locations(client,voiture));;
    }


    static Vehicule changeretat(Vehicule voiture){
        if (voiture.getState()==Etatvoiture.Disponile){
            voiture.setState(Etatvoiture.Louer);
            repository1.save(voiture);
        }else {voiture.setState(Etatvoiture.Disponile);
            repository1.save(voiture);;}
        return voiture;
    }
    static void afficherlocation(){
        //verification des locations
        Iterable<Locations> locations = repository2.findAll();
        for (Locations location : locations){
            System.out.println(location);
        }
    }

    static void retournerVoiture() {


    }
    static void saveClient(Client A){
        repository.save(A);
    }
    static Client rechercheClient(String permis){
        Client clientConcerne = repository.findByPermisnumber(permis);
        if (clientConcerne==null){
            appChoice();
        }
        return clientConcerne;
    }
    static Vehicule rechercheVehicule(Long iden){
        Vehicule voitureConcerne = repository1.findOne(iden);
        return voitureConcerne;
    }

}

