package ca.uqam.repositories;

import ca.uqam.model.Etatvoiture;
import ca.uqam.model.Vehicule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-22.
 */
public interface VehiculeRepository extends CrudRepository<Vehicule,Long> {

   // List<Vehicule> findByState(Etatvoiture state);
    Vehicule findByState(Etatvoiture state);
    List<Vehicule> findAll();

}
