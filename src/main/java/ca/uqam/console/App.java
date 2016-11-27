package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
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

import static ca.uqam.console.Main.repository;
import static ca.uqam.console.Main.repository1;
import static ca.uqam.console.Main.repository2;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void help() {
        System.out.println(" \n Mon program fonction comme il faut \n ");
        System.out.println(
                         "- 0 : Afficher l'aide \n " +
                        "- 1 : Afficher les voitures disponibles\n " +
                        "- 2 : Afficher  les Clients \n " +
                        "- 3 : Louer une voiture \n " +
                        "- 4 : Retourner une voiture  \n " +
                        "- 5 : Quitter\n ");
    }

    public static void afficherClient() {
        Iterable<Client> customers = repository.findAll();
        System.out.println("Customers found:");
        System.out.println("-------------------------------");
        for (Client customer : customers){
            System.out.println(customer);
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
    public static void locationVoitures(){
        System.out.println("\n veuillez entrer votre choix : \n");
        Long choiceUser = sc.nextLong();
        Vehicule voitures2 = repository1.findOne(choiceUser);
        System.out.println("\n vous avez choisi : " +voitures2);
        //entrer le numero de permis de conduire
        System.out.println("\n veuillez entrer votre numero de permis de conduire : \n");
        sc.nextLine();
        String numeroPermis = sc.nextLine();
        //verifier que le permis est dans la base de donnees
        List<Client[]> client = repository.findByPermisnumber(numeroPermis);
        //inscrire le client dans la base de donnees
        System.out.println(client.get(0));
        if (client.isEmpty()){
            ajouterClient();
        }
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            //repository2.save(new Locations(dateFormat.format(date),"",voitures2.getID()));
            System.out.println("\n votre location a ete enregistree!! \n");
    }
    public static void ajouterClient(){
        System.out.println("\n identifiez vous sous le format \"prenom,nom,numero de telephone,adresse\" : \n");
        String identification = sc.nextLine();
        String[] tableauSauvegarde = identification.split(",");
        repository.save(new Client(tableauSauvegarde[0],tableauSauvegarde[1],tableauSauvegarde[2],tableauSauvegarde[3],tableauSauvegarde[4]));
    }
    public static  void afficherLocation() {
        Iterable<Locations> louees = repository2.findAll();
        System.out.println("\n Rental found:");
        System.out.println("-------------------------------");
        for (Locations loue : louees) {
            System.out.println(loue);
        }
    }

}

