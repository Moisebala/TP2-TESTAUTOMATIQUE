package ca.uqam.repositories;

import ca.uqam.model.Client;
import ca.uqam.model.Locations;
import ca.uqam.model.Vehicule;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */
public interface LocationsRepository extends CrudRepository<Locations , Long> {

    List<Locations> findAll();

    Locations findByClient(Client client);

    Locations findByVehicule(Vehicule voiture);


}
