package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText numberTxt;
    private EditText profTxt;
    private EditText sessionTxt;
    private EditText nomTxt;
    private EditText noteTxt;
    private EditText searchTxt;
    private TextView moyenneView;
    private TextView coursView;
    private List<Cours> coursList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.numberTxt = (EditText) findViewById(R.id.numberTxt);
        this.profTxt = (EditText) findViewById(R.id.profTxt);
        this.sessionTxt = (EditText) findViewById(R.id.sessionTxt);
        this.nomTxt = (EditText) findViewById(R.id.nomTxt);
        this.noteTxt = (EditText) findViewById(R.id.noteTxt);
        this.searchTxt = (EditText) findViewById(R.id.searchTxt);
        this.moyenneView = (TextView) findViewById(R.id.moyenneView);
        this.coursView = (TextView) findViewById(R.id.coursView);
    }

    public void save(View view) {
        Integer number = Integer.parseInt(numberTxt.getText().toString());
        String prof = profTxt.getText().toString();
        String session = sessionTxt.getText().toString();
        String nom = nomTxt.getText().toString();
        Integer note = Integer.parseInt(noteTxt.getText().toString());

        Cours cours = new Cours(number, prof, session, nom, note);
        coursList.add(cours);

        Integer moyenne = calculateAverage();
        moyenneView.setText(moyenne);

        clearFields();
    }

    private Integer calculateAverage() {
        if (coursList.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Cours cours : coursList) {
            sum += cours.note;
        }

        return sum / coursList.size();
    }

    public void edit(View view) {
        String query = searchTxt.getText().toString();

//
        Cours courseToEdit = null;
        for (Cours cours : coursList) {
            if (cours.prof.equals(query) || cours.nom.equals(query) || cours.number.toString().equals(query)) {
                courseToEdit = cours;
                break;
            }
        }

        if (courseToEdit != null) {
            Integer number = Integer.parseInt(numberTxt.getText().toString());
            String prof = profTxt.getText().toString();
            String session = sessionTxt.getText().toString();
            String nom = nomTxt.getText().toString();
            Integer note = Integer.parseInt(noteTxt.getText().toString());

            courseToEdit.number = number;
            courseToEdit.prof = prof;
            courseToEdit.session = session;
            courseToEdit.nom = nom;
            courseToEdit.note = note;

            Integer moyenne = calculateAverage();
            moyenneView.setText(moyenne);
        }
    }

    public void delete(View view) {
        String query = searchTxt.getText().toString();

        Cours courseToDelete = null;
        for (Cours cours : coursList) {
            if (cours.prof.equals(query) || cours.nom.equals(query) || cours.number.toString().equals(query)) {
                courseToDelete = cours;
                break;
            }
        }

        if (courseToDelete != null) {
            coursList.remove(courseToDelete);

            Integer moyenne = calculateAverage();
            moyenneView.setText(moyenne);

            clearFields();
        }
    }

    private void clearFields() {
        numberTxt.setText("");
        profTxt.setText("");
        sessionTxt.setText("");
        nomTxt.setText("");
        noteTxt.setText("");
    }

    public void searchProf(View view) {
        String query = searchTxt.getText().toString();

        Cours courseFound = null;
        for (Cours cours : coursList) {
            if (cours.prof.equals(query)) {
                courseFound = cours;
                break;
            }
        }

        if (courseFound != null) {
            numberTxt.setText(courseFound.number.toString());
            profTxt.setText(courseFound.prof);
            sessionTxt.setText(courseFound.session);
            nomTxt.setText(courseFound.nom);
            noteTxt.setText(courseFound.note.toString());

            coursView.setText("\nProf: " + courseFound.prof + "\nSession: " + courseFound.session + "\nNom: " + courseFound.nom + "\nNote: " + courseFound.note);
        } else {
            clearFields();
            coursView.setText("not found");
        }
    }

    public void searchNom(View view) {
        String query = searchTxt.getText().toString();

        Cours courseFound = null;
        for (Cours cours : coursList) {
            if (cours.nom.equals(query)) {
                courseFound = cours;
                break;
            }
        }

        if (courseFound != null) {
            numberTxt.setText(courseFound.number.toString());
            profTxt.setText(courseFound.prof);
            sessionTxt.setText(courseFound.session);
            nomTxt.setText(courseFound.nom);
            noteTxt.setText(courseFound.note.toString());

            coursView.setText("\nProf: " + courseFound.prof + "\nSession: " + courseFound.session + "\nNom: " + courseFound.nom + "\nNote: " + courseFound.note);
        } else {
            clearFields();
            coursView.setText("not found");
        }
    }

    public void searchNumber(View view) {
        String query = searchTxt.getText().toString();

        Cours courseFound = null;
        for (Cours cours : coursList) {
            if (cours.number.toString().equals(query)) {
                courseFound = cours;
                break;
            }
        }

        if (courseFound != null) {
            numberTxt.setText(courseFound.number.toString());
            profTxt.setText(courseFound.prof);
            sessionTxt.setText(courseFound.session);
            nomTxt.setText(courseFound.nom);
            noteTxt.setText(courseFound.note.toString());

            coursView.setText("\nProf: " + courseFound.prof + "\nSession: " + courseFound.session + "\nNom: " + courseFound.nom + "\nNote: " + courseFound.note);
        } else {
            clearFields();
            coursView.setText("not found");
        }
    }

}