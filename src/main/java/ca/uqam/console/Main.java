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

import java.util.Scanner;

import static ca.uqam.console.App.*;

/**
 * Created by Mo-is-Balla on 2016-11-13.
 */
public class Main {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       //repository1.save(new Vehicule("789593","Pontiag","C220","Sedan","2016","120", Etatvoiture.Disponile));
       //repository1.save(new Vehicule("788593","Toyota","C220","Sedan","2016","120", Etatvoiture.Disponile));
        help();
    }

}

