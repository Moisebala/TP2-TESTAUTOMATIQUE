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
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        help(); }
    static void help() {
        System.out.println("\n Faites votre choix : \n");
        System.out.println(
                "1 : Affiche les voitures disponibles\n " +
                        "2 : Affiche les voitures louees \n " +
                        "3 : Louer une voiture \n " +
                        "4 : Affiche les clients existants \n " +
                        "5 : Retourner une voiture \n " +
                        "6 : Quitter\n ");
        //initialisationBase();
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
                afficherVoitureslouees();
                appChoice();
                break;
            case 3:
                afficherVoituresDisponibles();
                long choiceUser;
                do{
                    System.out.println("Veuillez choisir une voiture");
                    choiceUser = sc.nextLong();
                } while (!(choiceUser>0&&choiceUser<=allCars().size()));
                Vehicule voitures2 = rechercheVehicule(choiceUser);
                System.out.println("\n vous avez choisi : " +voitures2);
                System.out.println("\n veuillez entrer votre numero de permis de conduire : \n");
                sc.nextLine();
                String numeroPermis = sc.nextLine();
                Client client = rechercheClient(numeroPermis);
                Client nouveauClient =new Client();
                if (client == null){
                    ajouterClient(nouveauClient,numeroPermis);
                    System.out.println("identite du client = " +nouveauClient.getId());
                    System.out.println("identite de la voiture = " +voitures2.getId());
                    saveLocation(nouveauClient,voitures2);
                    App.saveClient(nouveauClient);

                } else {

                    //creer une ligne dans la table location
                    System.out.println("identite du client = " +client.getId());
                    System.out.println("identite de la voiture = " +voitures2.getId());
                    saveLocation(client,voitures2);
                    App.saveClient(client);
                }
                //changer l etat de la voiture
                voitures2 =App.changeretat(voitures2);
                System.out.println("Location enregistré avec sucess");
                appChoice();
                break;
            case 4:
                System.out.println("Customer Found : ");
                afficherClient();
                appChoice();
                break;
            case 5:
                System.out.println("Entrer le numero de votre permis SVP: ");
                sc.nextLine();
                String permisRetour = sc.nextLine();
                 Vehicule voiture =App.verifierlocation(permisRetour);
                System.out.println("la " +voiture.toString() +"a ete retourné");
                System.out.println("Merci pour votre confiance renouvellee");
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
    //afficher la liste des voitures disponibles
    static void afficherVoituresDisponibles(){
        List<Vehicule> voitures =App.allCars();
            System.out.println("\nListe des voitures disponibles :");
            for (Vehicule voiture : voitures){
                if(voiture.getState()==Etatvoiture.Disponile && voitures.toString()!="[]") {
                    System.out.println(voiture);
                }
            }
        }
    //afficher la liste des voitures louees
    static void afficherVoitureslouees(){
        List<Vehicule> voitures =App.allCars();
        System.out.println("\nListe des voitures louees :");
        for (Vehicule voiture : voitures){
            if(voiture.getState()==Etatvoiture.Louer && voitures.toString()!="[]") {
                System.out.println(voiture);
            }
        }
    }

    static Client ajouterClient(Client A ,String B){
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
        return A;

    }
    static void quitter () {
        System.out.println("Etes vous sure de vouloir quitter ? O ou N");
        String reponse = sc.next();
        if (reponse.equals("O") || reponse.equals("o")){
            System.exit(0);}
        else{appChoice();}
    }
    }





