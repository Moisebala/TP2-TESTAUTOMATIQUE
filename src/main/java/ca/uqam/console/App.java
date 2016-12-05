package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.*;
import ca.uqam.repositories.*;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ca.uqam.console.Main.*;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */

public class App {
    static ConfigurableApplicationContext context = SpringApplication.run(Config.class);
    static ClientRepository clientrepository = context.getBean(ClientRepository.class);
    static LocationsRepository locationsRepository=context.getBean(LocationsRepository.class);
    static VehiculeListRepository vehiculeListRepository=context.getBean(VehiculeListRepository.class);
    static Etatvoiture Disponible= Etatvoiture.Disponible;
    static Etatvoiture Louer= Etatvoiture.Louer;
    static VehiculeListe vehiculeDispo = new VehiculeListe(Disponible);



    private App(){
        //Constructor par defaut
    }

    //-***************************** Methode pour menu2 en cours *********************************************************
    // sauvegarder une location
    public  static void saveLocation(Client client , Vehicule voiture){
        locationsRepository.save(new Locations(client,voiture));;
    }
   //rechercher un client
    public static Client rechercheClient1(String permis){
        Client client = clientrepository.findByPermisnumber(permis);
        return client;
    }
    // rechercher une voiture
    public static Vehicule recherchevoiture(String matricule) {
        VehiculeListe customers = vehiculeListRepository.findByEtat(Disponible);
            Vehicule v = customers.getVehicules(matricule);
        return v;
        }
     // Afficher une location
    public static void  Locations1() {
        ArrayList<Locations> list_locations;
        Iterable<Locations> locations = locationsRepository.findAll();
        for (Locations location : locations)
            System.out.println(location);

     }

    //initialiser la base de donnees
    public static void initialisationBase1() {

        vehiculeDispo.addVehicule(new Vehicule("78959600","Toyota","Camry","Sedan","2016","120",Disponible));
        vehiculeDispo.addVehicule(new Vehicule("20162009","Honda","Accord","SEDAN","2016","120",Disponible));
         vehiculeDispo.addVehicule(new Vehicule("20162010","gip","Accord","SEDAN","2016","120", Disponible));
        vehiculeDispo.addVehicule(new Vehicule("78959601","Toyota","Camry","Sedan","2016","120",Disponible));
        vehiculeDispo.addVehicule(new Vehicule("20162004","Honda","Accord","SEDAN","2016","120", Disponible));
         vehiculeDispo.addVehicule(new Vehicule("20162011","gip","Accord","SEDAN","2016","120", Disponible));
         vehiculeListRepository.save(vehiculeDispo);

        clientrepository.save(new Client("AM002300","Armelle","Tenekeu","5147718969","1345 rue saint charles"));
        clientrepository.save(new Client("AM002310","Mama","Kouboura","5146740886","1345 chemin de Chambly"));
        clientrepository.save(new Client("AM002312","Moussa","Balla","5146212124","1345 rue de la barre"));

    }
    //Retourner une voiture
    public static Vehicule Retourlocation(String infos){
        String[] retour = infos.split(",");

        VehiculeListe vehiculeListe =vehiculeListRepository.findByEtat(Disponible);
        Client client =clientrepository.findByPermisnumber(retour[0]);
        Locations locations =locationsRepository.findByClient(client);
        Vehicule voiture =vehiculeListe.getVehicules(retour[1]);
        if (locations.getIdVehicule()==voiture.getIdVehicule()){
            voiture.setState(Disponible);
            locationsRepository.delete(locations);}
        vehiculeListRepository.save(vehiculeListe);
       return voiture;
    }
    //Location d'une voiture
    public static Vehicule LocationVoiture(String infos) {
        String[] louees = infos.split(",");
        Vehicule voiture1;
        Client clientConcerne = clientrepository.findByPermisnumber(louees[0]);
        VehiculeListe vehiculeListe =vehiculeListRepository.findByEtat(Disponible);
        voiture1 =vehiculeListe.getVehicules(louees[1]);
        voiture1.setState(Louer);
        vehiculeListRepository.save(vehiculeListe);
        saveLocation(clientConcerne,voiture1);
        return voiture1;
    }
    //pour ajouter un nouveau client
    public static void ajouterClient1(String identification){
        String[] tableauSauvegarde = identification.split(",");
        clientrepository.save(new Client(tableauSauvegarde[0],tableauSauvegarde[1],tableauSauvegarde[2],tableauSauvegarde[3],tableauSauvegarde[4]));}
}




