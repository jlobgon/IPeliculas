package com.example.ipeliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.Adapter rva;
    RecyclerView.LayoutManager lm;
    ArrayList<Pelicula> listaPelicula = new ArrayList<>();

    /**
     * Método llamado al crear la actividad.
     * Configura el layout, habilita Edge-to-Edge, inicializa y configura el RecyclerView
     * con la lista de películas.
     *
     * @param savedInstanceState Bundle con el estado previo de la actividad, si existe.
     */
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
    }

    /**
     * Crea el menú de opciones de la actividad.
     *
     * @param menu Menú que se mostrará en la ActionBar.
     * @return true indicando que el menú ha sido creado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    /**
     * Maneja la selección de un ítem del menú de opciones.
     *
     * @param item Ítem del menú seleccionado.
     * @return true si el evento fue manejado, false de lo contrario.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAcercade) {
            Intent intent = new Intent(this, AcercaDeActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menuIrAlCine) {
            Intent intent = new Intent(this, IrAlCineActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Llena la lista de películas con datos de ejemplo.
     * Se agregan varias películas con su título, género, valoración, sinopsis,
     * descripción corta, imagen, director y fecha de estreno.
     */
    public void llenarListaPeliculas() {
        Calendar cal = Calendar.getInstance();

        // Ejemplo: Avatar
        cal.set(2025, Calendar.NOVEMBER, 20);
        Date fechaAvatar = cal.getTime();
        Pelicula avatar = new Pelicula(
                "Avatar",
                "Ciencia ficción",
                4.5f,
                "En el año 2154, un exmarine parapléjico es enviado al planeta Pandora, donde deberá decidir entre seguir las órdenes humanas o proteger a los nativos Na'vi.",
                "Un exmarine llega a Pandora y se involucra con los Na'vi.",
                R.drawable.avatar,
                "James Cameron",
                fechaAvatar
        );
        Pelicula.listaPelicula.add(avatar);

        // Ejemplo: Interestelar
        cal.set(2014, Calendar.NOVEMBER, 7);
        Date fechaInterestelar = cal.getTime();
        Pelicula interestelar = new Pelicula(
                "Interestelar",
                "Ciencia ficción",
                5.0f,
                "Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.",
                "Una misión espacial busca salvar a la humanidad.",
                R.drawable.interestelar,
                "Christopher Nolan",
                fechaInterestelar
        );
        Pelicula.listaPelicula.add(interestelar);

        // Ejemplo: Joker
        cal.set(2019, Calendar.OCTOBER, 4);
        Date fechaJoker = cal.getTime();
        Pelicula joker = new Pelicula(
                "Joker",
                "Drama / Thriller",
                4.7f,
                "Arthur Fleck, un comediante fallido, cae lentamente en la locura hasta convertirse en el Joker.",
                "La transformación de Arthur en el villano Joker.",
                R.drawable.joker,
                "Todd Phillips",
                fechaJoker
        );
        Pelicula.listaPelicula.add(joker);

        // Ejemplo: El Señor de los Anillos
        cal.set(2001, Calendar.DECEMBER, 19);
        Date fechaLOTR = cal.getTime();
        Pelicula lotr = new Pelicula(
                "El Señor de los Anillos",
                "Fantástico",
                5.0f,
                "Un hobbit recibe un anillo maligno que debe destruir para salvar la Tierra Media.",
                "Frodo inicia una misión épica para destruir el Anillo Único.",
                R.drawable.el_senor_de_los_anillos,
                "Peter Jackson",
                fechaLOTR
        );
        Pelicula.listaPelicula.add(lotr);

        // Ejemplo: Spider-Man
        cal.set(2002, Calendar.MAY, 3);
        Date fechaSpiderman = cal.getTime();
        Pelicula spiderman = new Pelicula(
                "Spider-Man",
                "Acción",
                4.3f,
                "Peter Parker obtiene habilidades arácnidas y lucha contra el crimen en Nueva York.",
                "El origen del héroe Spider-Man.",
                R.drawable.spiderman,
                "Sam Raimi",
                fechaSpiderman
        );
        Pelicula.listaPelicula.add(spiderman);

        // Ejemplo: Toy Story
        cal.set(1995, Calendar.NOVEMBER, 22);
        Date fechaToyStory = cal.getTime();
        Pelicula toyStory = new Pelicula(
                "Toy Story",
                "Animación",
                4.9f,
                "Woody debe lidiar con la llegada de Buzz Lightyear, un nuevo juguete con actitud.",
                "Aventura animada sobre juguetes que cobran vida.",
                R.drawable.toy_story,
                "John Lasseter",
                fechaToyStory
        );
        Pelicula.listaPelicula.add(toyStory);
    }
}
