package ca.uqam.model;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
/**
 * Created by Mo-is-Balla on 2016-11-14.
 */
@Table
@Entity(name = "Client")
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name ="Permit_number",unique = true)
    private String permisnumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "Adresse")
    private String adresse;
    public Client(){

        // Default constructor
    }
    public Client(String Permit, String firstName, String lastName,String phone,String adresse) {
        this.permisnumber = Permit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone=phone;
        this.adresse=adresse;

    }

    @Override
    public String toString() {
        return String.format("Client[Permis=%s, firstName='%s', lastName='%s', phone ='%s' , adresse ='%s']", getPermisnumber(), firstName, lastName,phone,adresse);
    }

    //getters et setters
    public String getPermisnumber(){ return permisnumber;}

    public void setPermisnumber(String permit){  this.permisnumber = permit;}

    public Long getId(){ return  id;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



}
