package com.example.petter.assignment_4;

import android.app.DialogFragment;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

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

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleMap.OnMarkerClickListener,
        com.google.android.gms.location.LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "MapsActivity";


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

        //Markers
        mMap.addMarker(new MarkerOptions().position(home).title("Marker at home").snippet("YOLOSAWWWWWG"));
        mMap.addMarker(new MarkerOptions().position(casino).title("Marker at Ubaten"));
        mMap.addMarker(new MarkerOptions().position(ubaten).title("Marker at Casino"));
        mMap.addMarker(new MarkerOptions().position(niagara).title("Marker in Niagra"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(start));//Flyttar kameran till kordinaten
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));//Zooma in 1-20

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        DialogFragment newFrag = new MarkerClickDialog();
        //newFrag.show(fT, "dialog");

        //mDialog.show(ft,"dialog"
        return false;

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

    }
}
