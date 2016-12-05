package ca.uqam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Mo-is-Balla on 2016-12-03.
 */
@Table
@Entity(name = "VehiculeList")
public class VehiculeListe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Version
    private long verion;
    @Column(name = "State_fk")
    @Enumerated(EnumType.STRING)
    private Etatvoiture etat;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Listvehicule_fk")
    private List<Vehicule> listvehicules;

    public  VehiculeListe(){
        // Default constructor
    }
   public VehiculeListe(Etatvoiture etat){
        this.etat=etat;
        listvehicules = new ArrayList<Vehicule>();
    }
    @Override
    public String toString() {
        String Infos ="";
        for(Vehicule v : listvehicules)
            Infos = " " + v.toString() + "\n";
        return  Infos ;
    }

    public void addVehicule (Vehicule...vehicule) {
        for (Vehicule  v : vehicule)
           this.listvehicules.add(v);
    }

    public void setVehileLists(List<Vehicule> vehicule) {
        this.listvehicules = vehicule;
    }

    public List<Vehicule> VehiculeLists() {return  listvehicules;
    }
    public Vehicule getEtat(Etatvoiture etat) {
        List<Vehicule> results = this.listvehicules
                .stream()
                .filter(c -> c.getState().equals(etat))
                .collect(Collectors.toList());
        if(results.size() != 1)
            throw new IllegalStateException();
        return results.get(0);

    }
    public Vehicule getVehicules(String matricule) {
        List<Vehicule> results = this.listvehicules
                .stream()
                .filter(c -> c.getMatricule().equals(matricule))
                .collect(Collectors.toList());
        if(results.size() != 1)
            throw new IllegalStateException();
        return results.get(0);

    }

}
