package com.example.ipeliculas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.Adapter rva;
    RecyclerView.LayoutManager lm;
    ArrayList<Pelicula> listaPelicula = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        llenarListaPeliculas();

        // Enlazamos la interfaz gráfica del RecyclerView con el código
        rv = findViewById(R.id.rv);
        // Establecemos que los elementos del RecyclerView se apilen verticalmente
        lm = new LinearLayoutManager(this);
        // Creamos un adaptador para el RecyclerView
        rva = new AdaptadorPeliculas(this, Pelicula.listaPelicula);
        // Enlazamos el adaptador con el objeto RecyclerView
        rv.setAdapter(rva);
        rv.setLayoutManager(lm);

        // Aplicar la animación
        Context context = rv.getContext();
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        rv.setLayoutAnimation(animation);
        rv.scheduleLayoutAnimation();



    }


    //Este método es necesario para incluir el menú en la Activity
    //Hereda de Activity, por eso es Override
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAcercade) {
            Intent intent = new Intent(this, AcercaDeActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void llenarListaPeliculas(){

            Calendar cal = Calendar.getInstance();
            cal.set(2025, Calendar.NOVEMBER, 20); // Mes empieza en 0
            Date fecha = cal.getTime();
            Pelicula avatar = new Pelicula(
                    "Avatar",
                    "Ciencia ficción",
                    4.5f,
                    "En el año 2154, un exmarine parapléjico es enviado al planeta Pandora, donde deberá decidir entre seguir las órdenes humanas o proteger a los nativos Na'vi.",
                    "Un exmarine llega a Pandora y se involucra con los Na'vi.",
                    R.drawable.avatar,
                    "James Cameron",
                    fecha
            );
            Pelicula avatar1 = new Pelicula(
                    "Avatar 2",
                    "Ciencia ficción",
                    4.5f,
                    "En el año 2154, un exmarine parapléjico es enviado al planeta Pandora, donde deberá decidir entre seguir las órdenes humanas o proteger a los nativos Na'vi.",
                    "Un exmarine llega a Pandora y se involucra con los Na'vi.",
                    R.drawable.avatar,
                    "James Cameron",
                    fecha
            );

            Pelicula.listaPelicula.add(avatar1);
            Pelicula.listaPelicula.add(avatar);
        }
    }
