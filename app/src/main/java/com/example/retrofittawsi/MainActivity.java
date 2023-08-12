package com.example.retrofittawsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnAjouter,btnModifier,btnSupprimer,btnAfficherTous;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        onclickMidifier(btnModifier);


    }
    private void init(){
        btnAjouter = findViewById(R.id.ajouter);
        btnModifier = findViewById(R.id.modifier);
        btnSupprimer = findViewById(R.id.suprimer);
        btnAfficherTous = findViewById(R.id.afficherTout);
        id = findViewById(R.id.id);
    }
    public void onclickAjouter(View view){
        Intent intent = new Intent(this, Ajout.class);
        startActivity(intent);
    };
    public void onclickMidifier(View view){
        Intent intent = new Intent(this, Modification.class);
        startActivity(intent);
    };
    public void onclickSupprimer(View view){
        Intent intent = new Intent(this, Supression.class);
        startActivity(intent);
    };
    public void onclickAfficher(View view){
        Intent intent = new Intent(this, Affichage.class);
        intent.putExtra("id", id.getText().toString());
        startActivity(intent);
    };
}