package com.example.petter.assignment_4;

import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.petter.assignment_4.Questions.Qfour;
import com.example.petter.assignment_4.Questions.Qone;
import com.example.petter.assignment_4.Questions.Qthree;
import com.example.petter.assignment_4.Questions.Qtwo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Petter on 04-10-2015.
 */

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        com.google.android.gms.location.LocationListener{

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "MapsActivity";

    private ArrayList<LatLng> markerLatLng = new ArrayList<>();
    private ArrayList<Marker> markerPos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();

        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        MarkerClickDialog dialogStart = new MarkerClickDialog();
        dialogStart.show(fT, "");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        UiSettings mUISettings = mMap.getUiSettings();
        mUISettings.setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);

        // Lat, Long locations
        LatLng start = new LatLng(55.606716, 12.987827);
        LatLng home = new LatLng(55.600148, 12.979925);
        LatLng casino = new LatLng(55.615583, 12.985307);
        LatLng ubaten = new LatLng(55.602590, 12.992510);
        LatLng niagara = new LatLng(55.609134, 12.994425);

        markerLatLng.add(home);
        markerLatLng.add(ubaten);
        markerLatLng.add(casino);
        markerLatLng.add(niagara);

        //Markers
        Marker homeM = mMap.addMarker(new MarkerOptions().position(home).title("Marker at home"));
        Marker ubatenM = mMap.addMarker(new MarkerOptions().position(casino).title("Marker at Ubaten"));
        Marker casinoM = mMap.addMarker(new MarkerOptions().position(ubaten).title("Marker at Casino"));
        Marker niagaraM = mMap.addMarker(new MarkerOptions().position(niagara).title("Marker in Niagra"));

        markerPos.add(homeM);
        markerPos.add(ubatenM);
        markerPos.add(casinoM);
        markerPos.add(niagaraM);

        //Camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(start));//Flyttar kameran till kordinaten
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));//Zooma in 1-20

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
                MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(), R.raw.horn);
                mPlayer.start();
                switch (marker.getTitle()) {
                    case "Q-1":
                        Qone dialog1 = new Qone();
                        dialog1.show(fT, "");
                        break;
                    case "Q-2":
                        Qtwo dialog2 = new Qtwo();
                        dialog2.show(fT, "");
                        break;
                    case "Q-3":
                        Qthree dialog3 = new Qthree();
                        dialog3.show(fT, "");
                        break;
                    case "Q-4":
                        Qfour dialog4 = new Qfour();
                        dialog4.show(fT, "");
                        break;

                }
                return true;
            }
        });
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Connected");
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
     public void onLocationChanged(Location location) {
        Vibrator mVib = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        Location mLocation = new Location("marker");

        for (int i = 0; i < markerPos.size(); i++) {

            mLocation.setLongitude(markerLatLng.get(i).longitude);
            mLocation.setLatitude(markerLatLng.get(i).latitude);

            float distance = location.distanceTo(mLocation);

            if(distance < 80){
                mVib.vibrate(1000);
                markerPos.get(i).setTitle("Q-"+(i+1));
                markerPos.get(i).setSnippet("Click to answer question!!");
                markerPos.get(i).showInfoWindow();
            }
        }
    }
}
