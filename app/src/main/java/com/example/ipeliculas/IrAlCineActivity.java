package com.example.ipeliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ipeliculas.databinding.ActivityIrAlCineBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class IrAlCineActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityIrAlCineBinding binding;

    // Coordenadas del cine
    private final LatLng lagohCine = new LatLng(37.34149, -5.98642);

    /**
     * Método llamado al crear la actividad.
     * Configura el layout, inicializa el mapa y asigna el botón para abrir Google Maps con la ruta.
     *
     * @param savedInstanceState Bundle con el estado previo de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Configuramos actionBar para que tenga un botón de volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Ir al Cine");


        binding = ActivityIrAlCineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Configurar botón para abrir Google Maps
        binding.activityIrAlCineButton.setOnClickListener(v -> abrirGoogleMaps());
    }

    /**
     * Método llamado cuando el mapa está listo.
     * Agrega un marcador del cine y centra la cámara en su ubicación.
     *
     * @param googleMap Instancia del mapa de Google.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregar marcador del cine
        mMap.addMarker(new MarkerOptions()
                .position(lagohCine)
                .title("Yelmo Premium Lagoh"));

        // Centrar cámara en el cine
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lagohCine, 16f));
    }

    /**
     * Abre Google Maps mostrando la ruta hacia el cine.
     * Usa el nombre completo del cine para asegurar que la ubicación sea correcta.
     */
    public void abrirGoogleMaps() {
        String destino = "Yelmo Premium Lagoh, Sevilla, España";
        String uri = "https://www.google.com/maps/dir/?api=1&destination=" + Uri.encode(destino) + "&travelmode=driving";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
