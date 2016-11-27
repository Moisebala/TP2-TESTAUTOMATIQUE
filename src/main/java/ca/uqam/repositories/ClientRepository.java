package ca.uqam.repositories;

import ca.uqam.model.Client;
import org.hibernate.type.LongType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Mo-is-Balla on 2016-11-14.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client[]> findByPermisnumber(@Param("permisnumber") String permisnumber);
    List<Client> findAll();


}