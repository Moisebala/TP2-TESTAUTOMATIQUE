package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static ca.uqam.console.Main.*;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */

public class App {

    static Scanner sc = new Scanner(System.in);

    static void help() {
        System.out.println("\n Faites votre choix : \n");
        System.out.println(
                        "1 : Affiche les voitures disponibles\n " +
                        "2 : Affiche les voitures louees \n " +
                        "3 : Louer une voiture \n " +
                        "4 : Louer une voiture \n " +
                        "5 : Retourner une voiture \n " +
                        "6 : Quitter\n ");
        appChoice();
    }
    static void appChoice(){
        int choiceMenu = sc.nextInt();
        switch (choiceMenu) {
            case 1:
                afficherVoituresDisponibles();
                appChoice();
                break;
            case 2:
               afficherVoituresLouees();
                appChoice();
                break;
            case 3:
                louerVoiture();
                appChoice();
                break;
            case 4:
                afficherClient();
                appChoice();
                break;
            case 5:
               // retournerVoiture();
                help();
                break;
            case 6:
                quitter();
                break;
            default:
                System.out.println("Mauvaise entree ! Veuillez reessayer ");
                help();
                break;
        }
        context.close();
        sc.close();
    }

    public static void afficherClient() {
        Iterable<Client> customers = repository.findAll();
        System.out.println("Customers found:");
        System.out.println("-------------------------------");
        for (Client customer : customers){
            System.out.println(customer);
        }

    }
    //afficher la liste des voitures disponibles
    public static  void afficherVoituresDisponibles(){
        List<Vehicule> voitures = repository1.findByState(Etatvoiture.Disponile);
        if (voitures.toString()=="[]") {
            System.out.println(" \n Aucune voiture n'est disponible!!\n");
        }
        else {
            System.out.println("\nListe des voitures disponibles :");
            for (Vehicule voiture : voitures){
                System.out.println(voiture);
            }
        }
    }
    //afficher la liste des voitures louees
    static void afficherVoituresLouees(){
        List<Vehicule> voitures = repository1.findByState(Etatvoiture.Louer);
        if (voitures.toString()=="[]") {
            System.out.println(" \n Aucune voiture n'a ete louee!!");
        }
        else {
            System.out.println("\nListe des voitures louees :");
            for (Vehicule voiture : voitures){
                System.out.println(voiture);
            }
        }
    }

    public static  void afficherVehicule(){
        Iterable<Vehicule> voitures = repository1.findAll();
        System.out.println("\n Vehicule found:");
        System.out.println("-------------------------------");
        for (Vehicule voiture : voitures){
            System.out.println(voiture);
        }
    }
    //methode pour louer une voiture
    static void louerVoiture(){
        long choiceUser;
        afficherVoituresDisponibles();
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
}

