package com.pro1.login_reg.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private String username;

    private String passwort;


    private String name;
    private String nachName;
    private String adresse;
    private int hausNr;
    private int postleitzahl;

    // Standard-Konstruktor für Hibernate
    public User() {
    }

    // Konstruktor mit Parametern
    public User(String username, String passwort, String nachName, String adresse, int hausNr, int postleitzahl) {
        this.username = username;
        this.passwort = passwort;
        this.nachName = nachName;
        this.adresse = adresse;
        this.hausNr = hausNr;
        this.postleitzahl = postleitzahl;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getHausNr() {
        return hausNr;
    }

    public void setHausNr(int hausNr) {
        this.hausNr = hausNr;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
