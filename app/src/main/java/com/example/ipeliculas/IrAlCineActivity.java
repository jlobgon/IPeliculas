    package com.example.ipeliculas;

    import androidx.fragment.app.FragmentActivity;

    import android.os.Bundle;

    import com.example.ipeliculas.databinding.ActivityIrAlCineBinding;
    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.MarkerOptions;
    import com.google.android.gms.maps.model.LatLngBounds;

    public class IrAlCineActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private ActivityIrAlCineBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityIrAlCineBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Coordenadas del Cine Yelmo Premium Lagoh
            LatLng lagohCine = new LatLng(37.34149, -5.98642);

            mMap.addMarker(new MarkerOptions()
                    .position(lagohCine)
                    .title("Yelmo Premium Lagoh"));

            // Ajustar la cámara para que el marcador se vea centrado y con zoom apropiado
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(lagohCine);
            LatLngBounds bounds = builder.build();
            int padding = 100; // margen en píxeles alrededor del borde de mapa
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lagohCine, 16f));
        }
    }
