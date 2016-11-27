package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
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
        //repository1.save(new Vehicule("789599","Volkswagen","Passat","Sedan","2016","120","Yes"));
        help();
        System.out.println("\n Enter something here : \n");
        int choiceMenu = sc.nextInt();

                switch (choiceMenu) {
                    case 1:
                        afficherLocation();
                        break;
                    case 2:
                        afficherClient();
                        break;
                    case 3:
                        afficherVehicule();
                        break;
                    case 4:
                        afficherVehicule();
                        locationVoitures();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
        context.close();

            }
    }

