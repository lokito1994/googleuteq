package com.example.googleuteq;
package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MainActivity.this));

        // Añade los marcadores con sus respectivas coordenadas y títulos
        LatLng location1 = new LatLng(40.7128, -74.0060); // Nueva York
        Marker marker1 = mMap.addMarker(new MarkerOptions()
                .position(location1)
                .title("Nueva York")
                .snippet("La Gran Manzana"));
        marker1.setTag(R.drawable.auditorio);

        LatLng location2 = new LatLng(51.5074, -0.1278); // Londres
        Marker marker2 = mMap.addMarker(new MarkerOptions()
                .position(location2)
                .title("Londres")
                .snippet("La ciudad de la niebla"));
        marker2.setTag(R.drawable.biblioteca);

        LatLng location3 = new LatLng(48.8566, 2.3522); // París
        Marker marker3 = mMap.addMarker(new MarkerOptions()
                .position(location3)
                .title("París")
                .snippet("La ciudad del amor"));
        marker3.setTag(R.drawable.enfermeria);

        LatLng location4 = new LatLng(-33.8688, 151.2093); // Sídney
        Marker marker4 = mMap.addMarker(new MarkerOptions()
                .position(location4)
                .title("Sídney")
                .snippet("La ciudad de las playas"));
        marker4.setTag(R.drawable.fci);

        // Mueve la cámara al primer marcador
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 5));
    }
}
