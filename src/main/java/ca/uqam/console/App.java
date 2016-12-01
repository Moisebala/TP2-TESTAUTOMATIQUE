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
    static ClientRepository clientrepository = context.getBean(ClientRepository.class);
    static VehiculeRepository vehiculeRepository= context.getBean(VehiculeRepository.class);
    static LocationsRepository locationsRepository=context.getBean(LocationsRepository.class);
    static ArrayList<Locations> listeLocations = new ArrayList<Locations>();
    private App(){
        //Constructor par defaut
    }
    //initialiser la base de donnees
    public static void initialisationBase() {
        vehiculeRepository.save(new Vehicule("78959600","Toyota","Camry","Sedan","2016","120",Etatvoiture.Disponile));
        vehiculeRepository.save(new Vehicule("20162009","Honda","Accord","SEDAN","2016","120", Etatvoiture.Disponile));
        vehiculeRepository.save(new Vehicule("20162010","gip","Accord","SEDAN","2016","120", Etatvoiture.Disponile));

        clientrepository.save(new Client("AM002300","Armelle","Tenekeu","5147718969","1345 rue saint charles"));
        clientrepository.save(new Client("AM002310","Mama","Kouboura","5146740886","1345 chemin de Chambly"));
        clientrepository.save(new Client("AM002312","Moussa","Balla","5146212124","1345 rue de la barre"));

    }

    public static ArrayList<Vehicule> allCars() {
        ArrayList<Vehicule> list_voitures = new ArrayList<Vehicule>();
        Iterable<Vehicule> voitures = vehiculeRepository.findAll();
        for (Vehicule voiture : voitures)
            list_voitures.add(voiture);
        return list_voitures;
    }

    public static ArrayList<Locations> allLocations() {
        ArrayList<Locations> list_locations = new ArrayList<Locations>();
        Iterable<Locations> locations = locationsRepository.findAll();
        for (Locations location : locations)
            list_locations.add(location);
        return list_locations;
    }


    public static void afficherClient() {
        List<Client> customers = clientrepository.findAll();
        for (Client customer : customers){
            System.out.println(customer);
        }
    }

    //methode verification de location
   public static Vehicule verifierlocation(String permis){
        Client clientConcerne = rechercheClient(permis);
        Locations locations =locationsRepository.findByClient(clientConcerne);
        Vehicule voitureConcerne = vehiculeRepository.findOne(locations.getIdVehicule());
       if (locations.getIdVehicule()==voitureConcerne.getIdVehicule()){
            changeretat(voitureConcerne);
            locations.setDateOfReturn(new Date());
           locationsRepository.delete(locations);
        }
        return  voitureConcerne;
    }
    public  static void saveLocation(Client client , Vehicule voiture){
        Locations location =locationsRepository.save(new Locations(client,voiture));;
    }


    public static Vehicule changeretat(Vehicule voiture){
        if (voiture.getState()==Etatvoiture.Disponile){
            voiture.setState(Etatvoiture.Louer);
            vehiculeRepository.save(voiture);
        }else {voiture.setState(Etatvoiture.Disponile);
            vehiculeRepository.save(voiture);;}
        return voiture;
    }
    static void afficherlocation(){
        //verification des locations
        Iterable<Locations> locations = locationsRepository.findAll();
        for (Locations location : locations){
            System.out.println(location);
        }
    }

    static Locations Confirmerlocation(Vehicule voiture) {
        Locations location =locationsRepository.findByVehicule(voiture);
        if (location.getIdVehicule()==voiture.getIdVehicule()){
            changeretat(voiture);
            location.setDateOfReturn(new Date());
            locationsRepository.save(location);
        }
        return location;
    }
    static void saveClient(Client A){
        clientrepository.save(A);
    }
    static Client rechercheClient(String permis){
        Client clientConcerne = clientrepository.findByPermisnumber(permis);
        if (clientConcerne==null){
            appChoice();
        }
        return clientConcerne;
    }
    static Vehicule rechercheVehicule(Long iden){
        Vehicule voitureConcerne = vehiculeRepository.findOne(iden);
        return voitureConcerne;
    }

}

