package ca.uqam.model;

import org.dom4j.tree.AbstractEntity;
import ca.uqam.model.Client;
import ca.uqam.model.Vehicule;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mo-is-Balla on 2016-11-26.
 */
@Table
@Entity(name = "Location")
public class Locations extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLocation;
    @Temporal(TemporalType.DATE)
    private Date date_of_rent;

    //location est lié à un client
    @ManyToOne(fetch = FetchType.LAZY , targetEntity=Client.class)
    @JoinColumn(name = "IDClient")
    private Client client;
    //location est lié à un vehicule
    @ManyToOne(fetch = FetchType.LAZY ,targetEntity=Vehicule.class)
    @JoinColumn(name = "IDVehicule")
    private Vehicule vehicule;

    @Column(name = "IDClient", insertable = false, updatable = false)
    private Long idClient;
    @Column(name = "IDVehicule", insertable = false, updatable = false)
    private Long  idVehicule;

    public Locations(String format, String numeroPermis, String matricule) {
        // Default constructor
            }
    public Locations(Date date_of_rent, Client client, Vehicule vehicule) {
         this.date_of_rent = date_of_rent;
         this.client = client;
         this.vehicule = vehicule;

      }

    @Override
    public String toString() {
        return String.format("Location[Date='%s',IdClient='%d',IdVehicule= '%d']",date_of_rent,idClient ,idVehicule);
    }
    public Long getIdClient() {
        return idClient;
    }

    public Long getIdVehicule() {
        return idVehicule
                ;
    }
}


