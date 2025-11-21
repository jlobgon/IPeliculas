package com.example.ipeliculas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcercaDeActivity extends AppCompatActivity {

    /**
     * Método llamado al crear la actividad.
     * Configura el layout, habilita Edge-to-Edge y ajusta el padding según los insets del sistema.
     * También configura la ActionBar para mostrar el botón de volver.
     *
     * @param savedInstanceState Bundle con el estado previo de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca_de);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuramos actionBar para que tenga un botón de volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Acerca de");
    }

    /**
     * Maneja el evento del botón de volver en la ActionBar.
     *
     * @return true indicando que el evento ha sido consumido.
     */
    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed(); // vuelve a la activity anterior
        return true;
    }
}
