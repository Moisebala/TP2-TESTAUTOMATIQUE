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


    //afficher la liste des voitures louees
    public static  ArrayList<Vehicule> voituresLouees(){
        ArrayList<Vehicule> voitures = allCars();
        for(Vehicule voiture :voitures)
        {  if(voiture.getState()==Etatvoiture.Louer) {
            voitures.add(voiture);
        }
        }
        return  voitures;
    }

    //methode pour louer une voiture
    static void louerVoiture(){
        long choiceUser;
        //afficherVoituresDisponibles();
        //recuperer le choix de l'utilisateur
        do{
            System.out.println("\n veuillez entrer votre choix : \n");
            choiceUser = sc.nextLong();
        } while (!(choiceUser>0&&choiceUser<=repository1.count()));
        Vehicule voitures2 = repository1.findOne(choiceUser);
        System.out.println("\n vous avez choisi : " +voitures2);
        //entrer le numero de permis de conduire
        System.out.println("\n veuillez entrer votre numero de permis de conduire : \n");
        sc.nextLine();
        String numeroPermis = sc.nextLine();

        Client client = repository.findByPermisnumber(numeroPermis);
        System.out.println(numeroPermis);
        //inscrire le client dans la base de donnees
        String numeroClient ;
        Client nouveauClient = new Client();
        if (client == null){
            ajouterClient(nouveauClient,numeroPermis);
            System.out.println("identite du client = " +nouveauClient.getId());
            System.out.println("identite de la voiture = " +voitures2.getId());
            repository2.save(new Locations(nouveauClient, voitures2));

    } else {

            //creer une ligne dans la table location
            System.out.println("identite du client = " +client.getId());
            System.out.println("identite de la voiture = " +voitures2.getId());
            repository2.save(new Locations(client, voitures2));
        }
        //changer l etat de la voiture

        voitures2.setState(Etatvoiture.Louer);
        repository1.save(voitures2);
        System.out.println("\n votre location a ete enregistree!! \n");
        System.out.println("Souhaitez vous continuer? O ou N");
        String reponse = sc.nextLine();
        if(reponse.equals("O") || reponse.equals("o"))
            help();
        else {
            System.out.println("Merci pour cette confiance renouvellee. Au plaisir de vous revoir!");
            System.exit(0);
        }

    }
    static void afficherlocation(){
        //verification des locations
        Iterable<Locations> locations = repository2.findAll();
        System.out.println("Locations found:");
        System.out.println("-------------------------------");
        for (Locations location : locations){
            System.out.println(location);
        }
    }

    static void quitter () {
        System.out.println("Etes vous sure de vouloir quitter ? O ou N");
        String reponse = sc.next();
        if (reponse.equals("O") || reponse.equals("o")){
            System.exit(0);}
        else{appChoice();}

    }
    static void retournerVoiture() {
        System.out.println("Entrer le numero de votre permis SVP: ");
        sc.nextLine();
        String permisRetour = sc.nextLine();
        // verifier si le client a deja louer une voiture ou pas
        Client clientConcerne = repository.findByPermisnumber(permisRetour);

        Locations locationConcerne = repository2.findByClient(clientConcerne);
        Vehicule voitureConcerne = repository1.findOne(locationConcerne.getIdVehicule());
        System.out.println("S'agit il de la " +voitureConcerne.toString() +" ? O ou N");
        String reponse = sc.nextLine();
        if (reponse.equals("O") || reponse.equals("o")){
            voitureConcerne.setState((Etatvoiture.Disponile));
            repository1.save(voitureConcerne);
            repository.save(clientConcerne);
            locationConcerne.setDateOfReturn(new Date());
            repository2.save(locationConcerne);
            System.out.println("Merci pour votre confiance renouvellee");
            appChoice();
        }else {
            System.out.println("Un probleme quelque part!! Verifier le numero de permis entre!");
            retournerVoiture();
        }

    }
    static void ajouterClient(Client A ,String B){
        String numeroClient;
        System.out.println("\n IDENTIFICATION : \n");
        System.out.println("Entrez votre prenom :\n");
        String nomClient = sc.nextLine();

        System.out.println("Entrez votre nom :\n");
        String prenomClient = sc.nextLine();

        do {
            System.out.println("Entrez votre numero de telephone :\n");
            //	sc.nextLine();
            numeroClient = sc.nextLine();
        } while (numeroClient.length() != 10);

        System.out.println("Entrez votre addresse :\n");
        String adresseClient = sc.nextLine();

        A.setPermisnumber(B);
        A.setFirstName(prenomClient);
        A.setLastName(nomClient);
        A.setPhone(numeroClient);
        A.setAdresse(adresseClient);
        repository.save(A);
    }
    static Client rechercheClient(String permis){
        Client clientConcerne = repository.findByPermisnumber(permis);

        return clientConcerne;
    }
    static Vehicule rechercheVehicule(Long iden){
        Vehicule voitureConcerne = repository1.findOne(iden);
        return voitureConcerne;
    }

}

