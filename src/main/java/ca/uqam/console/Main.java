package ca.uqam.console;

import ca.uqam.config.Config;
import ca.uqam.model.Client;
import ca.uqam.model.Vehicule;
import ca.uqam.repositories.ClientRepository;
import ca.uqam.repositories.LocationsRepository;
import ca.uqam.repositories.VehiculeListRepository;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


/**
 * Created by Mo-is-Balla on 2016-12-01.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ClientRepository clientRepository=context.getBean(ClientRepository.class);
        VehiculeListRepository vehiculeListRepository=context.getBean(VehiculeListRepository.class);
        LocationsRepository locationsRepository=context.getBean(LocationsRepository.class);
        App.initialisationBase1();

         //System.out.println("\nVeuillez saisir votre numero de permis de conduire :");
        //String numeroPermis = sc.nextLine();
        //Vehicule vehicule =App.Retourlocation(numeroPermis);
        //App.Locations1();

   
        try {
            CommandLine line = new DefaultParser().parse(optionsCreations(), args);
            if( line.hasOption( "voituredisponible" ) ){
               Vehicule vdip = App.recherchevoiture(line.getOptionValue( "voituredisponible"));
                System.out.println();
                System.out.println(vdip.toString());
            }
            else if(line.hasOption( "client" )) {
                Client clt =App.rechercheClient1( line.getOptionValue( "client" ) );
                System.out.println(clt.toString());
            }
            else if(line.hasOption( "louerE" )) {
                Vehicule vtl =App.LocationVoiture(line.getOptionValue( "louerE"));
                System.out.println();
                System.out.println("Location Enregistrée..." +vtl.toString());
            }
            else if(line.hasOption( "ajouter" )) {
                App.ajouterClient1(line.getOptionValue( "ajouter"));
            }
            else if(line.hasOption( "retour" )) {
                Vehicule vtr =App.Retourlocation(line.getOptionValue("retour"));
                System.out.println();
                System.out.println("La voiture est maintenant disponible :\n "+vtr.toString());
            }
            else if (line.hasOption("help")){ aide();}

           }catch(ParseException exp ) {System.out.println("Unexpected exception: " + exp.getMessage());}
       }

    private static Options optionsCreations(){
        Options options = new Options();

        options.addOption("h", "help", false, "Affiche l'aide" );
        options.addOption("v", "voituredisponible",true , "Rechercher voiture " );
        options.addOption("t", "client",true, "Rechercher un client existant" );
        options.addOption("r", "louerE", true, "Pour louer une voiture" );
        options.addOption("s", "ajouter", true, "Pour louer une voiture" );
        options.addOption("e", "retour", true, "Pour retourner une voiture" );

        return options;

        }
    private static void aide() {

        System.out.println(
                " - h : Affiche l'aide \n " +
                        "- v : Affiche les voitures disponibles \n " +
                        "- c : Affiche les voitures louees \n " +
                        "- t : Rechercher un client existant \n " +
                        "- r : Pour louer une voiture existant \n " +
                        "- s : Pour louer une voiture client non existant \n " +
                        "- e : Pour retourner une voiture \n ");

    }
}
