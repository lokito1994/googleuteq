package com.example.googleuteq;


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

        //marcadores con sus respectivas coordenadas y títulos
        LatLng location1 = new LatLng(-1.0128716863686409, -79.46770836477866);         Marker marker1 = mMap.addMarker(new MarkerOptions()
                .position(location1)
                .title("AUDITORIO")
                .snippet("UNIVERSIDAD TÉCNICA ESTATAL DE QUEVEDO"));
        marker1.setTag(R.drawable.auditorio);

        LatLng location2 = new LatLng(-1.0124425999575206, -79.46843256127033);
        Marker marker2 = mMap.addMarker(new MarkerOptions()
                .position(location2)
                .title("BIBLIOTECA")
                .snippet("UNIVERSIDAD TÉCNICA ESTATAL DE QUEVEDO"));
        marker2.setTag(R.drawable.biblioteca);

        LatLng location3 = new LatLng(-1.0128770499441258, -79.46916212206905);
        Marker marker3 = mMap.addMarker(new MarkerOptions()
                .position(location3)
                .title("FACULTAD DE CIENCIAS ENFERMERÍA")
                .snippet("UNIVERSIDAD TÉCNCIA ESTATAL DE QUEVEDO"));
        marker3.setTag(R.drawable.enfermeria);

        LatLng location4 = new LatLng(-1.0125391444040293, -79.4702940141906);
        Marker marker4 = mMap.addMarker(new MarkerOptions()
                .position(location4)
                .title("FACULTAD DE CIENCIAS DE LA INGENIERÍA")
                .snippet("UNIVERSIDAD TÉCNICA ESTATAL DE QUEVEDO"));
        marker4.setTag(R.drawable.fci);

        // Mueve la cámara al primer marcador
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 5));
    }
}
