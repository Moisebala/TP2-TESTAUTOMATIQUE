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

import java.util.Scanner;

import static ca.uqam.console.App.*;

/**
 * Created by Mo-is-Balla on 2016-11-13.
 */
public class Main {
    static  ConfigurableApplicationContext context = SpringApplication.run(Config.class);
    static ClientRepository repository = context.getBean(ClientRepository.class);
    static VehiculeRepository repository1= context.getBean(VehiculeRepository.class);
    static LocationsRepository repository2=context.getBean(LocationsRepository.class);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       // repository1.save(new Vehicule("789591","Mercedes","C220","Sedan","2016","120", Etatvoiture.Disponile));
        help();
    }

}

