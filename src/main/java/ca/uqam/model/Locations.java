package ca.uqam.model;

import org.dom4j.tree.AbstractEntity;
import ca.uqam.model.Client;
import ca.uqam.model.Vehicule;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    //location est lié à un client
    @ManyToOne(fetch = FetchType.EAGER , targetEntity=Client.class)
    @JoinColumn(name = "IDClient")
    private Client client;
    //location est lié à un vehicule
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity=Vehicule.class)
    @JoinColumn(name = "IDVehicule")
    private Vehicule vehicule;
    @Column(name = "IDClient", insertable = false, updatable = false ,unique = true)
    private Long idClient;
    @Column(name = "IDVehicule", insertable = false, updatable = false, unique = true)
    private Long  idVehicule;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_rent")
    private Date date_of_rent;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_return")
    private Date date_of_return;

    public Locations() {

    }

    public Locations( Client client, Vehicule vehicule) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date_of_rent = new Date();
        this.client = client;
        this.vehicule = vehicule;
        this.date_of_return = new Date();

    }
    @Override
    public String toString() {
        return String.format("Location[IdClient='%d', IdVehicule= '%d', DateOfRent='%s', DateOfReturn='%s',]",idClient , idVehicule, date_of_rent, date_of_return);
    }
    public Long getIdClient() {
        return idClient;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setDateOfReturn(Date date) {
        this.date_of_return = date;
        ;
    }
    public Date getDateOfReturn(){
        return date_of_return;
    }

    public  Client getClient(){ return  client;}

}

