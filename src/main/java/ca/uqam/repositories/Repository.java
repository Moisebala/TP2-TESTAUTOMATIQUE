package ca.uqam.repositories;

import ca.uqam.model.Client;
import ca.uqam.model.Vehicule;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mo-is-Balla on 2016-11-29.
 */
public class Repository {

    private final static Logger LOGGER = Logger.getLogger(Repository.class.getName());

    public Repository(){
        // Default constructor
    }

    public static List<Vehicule> VehiculeList() {
        List<Vehicule>  VehiculeList = new ArrayList<Vehicule>();
        for (Vehicule voiture : VehiculeList){
           VehiculeList.add(voiture);
        }
        return VehiculeList;
    }

    public static List<Client> clientList() {
        List<Client>  clientList = new ArrayList<Client>();
        for (Client clients : clientList){
            clientList.add(clients);
        }
        return clientList;
    }


}
