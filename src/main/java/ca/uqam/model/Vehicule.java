package ca.uqam.model;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Mo-is-Balla on 2016-11-14.
 */
@Table
@Entity(name = "Vehucile")
public class Vehicule extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    public String Matricule;
    @Column(name = "Marque")
    public String Marque;
    @Column(name = "Model")
    public String Model;
    @Column(name = "Type")
    public String Type;
    @Column(name = "Year")
    public String Year;
    @Column(name = "Price_per_day")
    public String price;
    @Column(name = "State")
    public String State;
    public Vehicule(){

        // Default constructor
    }
    public Vehicule(String matricule, String marque, String model, String type, String year, String price, String state) {
        this.Matricule = matricule;
        this.Marque = marque;
        this.Model = model;
        this.Type=type;
        this.Year= year;
        this.price=price;
        this.State=state;

    }
    @Override
    public String toString() {
        return String.format("[%dL - Matricule=%s, Marque='%s', Model='%s', Type ='%s' , Year ='%s' ,prix ='%s',Etat ='%s']",id , getMatricule(), Marque, Model,Type,Year,price,State);
    }
    public String getMatricule() {
        return Matricule;
    }
    public void setMatricule(String matricule) {
        Matricule = matricule;
    }
    public  Long getID(){ return  id;}
}

