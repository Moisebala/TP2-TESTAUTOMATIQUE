package ca.uqam.repositories;

import ca.uqam.model.Etatvoiture;
import ca.uqam.model.VehiculeListe;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-12-03.
 */
public interface VehiculeListRepository extends CrudRepository <VehiculeListe ,Long> {

    VehiculeListe findByEtat (Etatvoiture etat);
    List<VehiculeListe> findAll();
}
