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
                        "4 : Retourner une voiture \n " +
                        "5 : Quitter\n ");
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
                //louerVoiture();
                break;
            case 4:
               // retournerVoiture();
                help();
                break;
            case 5:
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

    static void quitter () {
        System.out.println("Etes vous sure de vouloir quitter ? O ou N");
        String reponse = sc.next();
        if (reponse.equals("O") || reponse.equals("o")){
            System.exit(0);}
        else{appChoice();}

    }
}

