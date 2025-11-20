package com.example.ipeliculas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DetailActivity extends AppCompatActivity {
    TextView titulo,genero,sinopsis,director,fecha;
    ImageView imagen;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        //Configuramos actionBar para que tenga un botón de volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Recuperamos la información de la película seleccionada
        Intent intent = getIntent();
        Pelicula p = (Pelicula) intent.getSerializableExtra("pelicula");

        //Traemos los elementos del xml
        titulo = findViewById(R.id.activity_detail_titulo);
        genero = findViewById(R.id.activity_detail_genero);
        sinopsis = findViewById(R.id.activity_detail_sinopsis);
        director = findViewById(R.id.activity_detail_director);
        ratingBar = findViewById(R.id.activity_detail_rating_bar);
        fecha = findViewById(R.id.activity_detail_fecha_estreno);
        imagen = findViewById(R.id.detail_activity_imageview);

        //Introducimos la información a cada elemento
        titulo.setText(p.getTitulo());
        genero.setText(p.getGenero());
        sinopsis.setText(p.getDescricionLarga());
        director.setText(p.getDirector());
        ratingBar.setRating(p.getValoracion());
        imagen.setImageResource(p.getImagenResID());

        Date fechaDate = p.getFechaDeEstreno();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        fecha.setText(sdf.format(fechaDate));



    }

    //Función que maneja el botón de volver
    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed(); // vuelve a la activity anterior
        return true;
    }
}