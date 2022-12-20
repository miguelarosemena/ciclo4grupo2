package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import java.util.Map;

public class Maps extends AppCompatActivity {
    private MapView mapView;
    private MapController mapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapView=(MapView) findViewById(R.id.mapView);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        mapController=(MapController) mapView.getController();

        GeoPoint colombia=new GeoPoint(4.570868,-74.297333);

        mapController.setCenter(colombia);
        mapController.setZoom(10);
        mapView.setMultiTouchControls(true);

    }
}