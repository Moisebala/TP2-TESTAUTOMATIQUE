package ca.uqam.model;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Mo-is-Balla on 2016-11-14.
 */
@Table
@Entity(name = "Vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Matricule",unique = true)
    private String matricule;
    @Column(name = "Marque")
    private String Marque;
    @Column(name = "Model")
    private String Model;
    @Column(name = "Type")
    private String Type;
    @Column(name = "Year")
    private String Year;
    @Column(name = "Price_per_day")
    private String price;
    @Column(name = "State")
    @Enumerated(EnumType.STRING)
    private Etatvoiture state;

    public Vehicule() {

        // Default constructor
    }

    public Vehicule(String matricule, String marque, String model, String type, String year, String price, Etatvoiture state) {
        this.matricule = matricule;
        this.Marque = marque;
        this.Model = model;
        this.Type = type;
        this.Year = year;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("[%dL - Matricule=%s, Marque='%s', Model='%s', Type ='%s' , Year ='%s' ,prix ='%s',Etat ='%s']", id,matricule, Marque, Model, Type, Year, price, getState());
    }

    public Long getIdVehicule(){ return  id;}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        matricule = matricule;
    }

    public Long getId() {
        return id;
    }

    public Etatvoiture getState() {
        return state;
    }

    public void setState(Etatvoiture etat) {
        this.state = etat; }


}

