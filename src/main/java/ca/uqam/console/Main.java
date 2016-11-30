package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeRepository;
import org.apache.commons.cli.Options;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ca.uqam.console.App;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ca.uqam.console.App.*;

/**
 * Created by Mo-is-Balla on 2016-11-13.
 */
public class Main {

    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static ArrayList<Vehicule> listeVoituresDisponibles = new ArrayList<Vehicule>();
    static ArrayList<Locations> listeLocations = new ArrayList<Locations>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        help();}

    static void help() {
        System.out.println("\n Faites votre choix : \n");
        System.out.println(
                "1 : Affiche les voitures disponibles\n " +
                        "2 : Affiche les voitures louees \n " +
                        "3 : Louer une voiture \n " +
                        "4 : Affiche les clients existants \n " +
                        "5 : Retourner une voiture \n " +
                        "6 : Quitter\n ");
        appChoice();
    }

    static void appChoice() {
        int choiceMenu = sc.nextInt();
        switch (choiceMenu) {
            case 1:
                afficherVoituresDisponibles();
                appChoice();
                break;
            case 2:
               System.out.println(App.voituresLouees());
                appChoice();
                break;
            case 3:
                louerVoiture();
                appChoice();
                break;
            case 4:
                System.out.println("Customer Found : ");
                afficherClient();
                appChoice();
                break;
            case 5:
                retournerVoiture();
                help();
                break;
            case 6:
                App.quitter();
                break;
            default:
                System.out.println("Mauvaise entree ! Veuillez reessayer ");
                help();
                break;
        }
        context.close();
        sc.close();
    }
    //afficher la liste des voitures disponibles
    static void afficherVoituresDisponibles(){
        List<Vehicule> voitures =App.allCars();
            System.out.println("\nListe des voitures disponibles :");
            for (Vehicule voiture : voitures){
                if(voiture.getState()==Etatvoiture.Disponile && voitures.toString()!="[]") {
                    System.out.println(voiture);
                }
                else { throw new IllegalStateException();}
            }
        }

    }





