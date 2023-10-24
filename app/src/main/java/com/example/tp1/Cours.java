package com.example.tp1;

public class Cours {
    Integer number;
    String prof;
    String session;
    String nom;
    Integer note;

    public Cours (Integer number,
                  String prof,
                  String session,
                  String nom,
                  Integer note){
        this.number = number;
        this.prof = prof;
        this.session = session;
        this.nom = nom;
        this.note = note;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

}
