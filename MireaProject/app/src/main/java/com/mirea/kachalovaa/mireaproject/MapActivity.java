package com.mirea.kachalovaa.mireaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.Manifest;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class MapActivity extends AppCompatActivity {

    private boolean canWork = false;

    private MapView mapView;
    private double latitude;
    private double longitude;

    private String title;
    private String address;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        findViewById(R.id.back).setOnClickListener(view -> finish());

        int locationPermissionStatus = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        if (locationPermissionStatus == PackageManager.PERMISSION_GRANTED) {
            canWork = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        mapView = findViewById(R.id.mapView);
        mapView.setZoomRounding(true);
        mapView.setMultiTouchControls(true);

        IMapController mapController = mapView.getController();
        mapController.setZoom(10);

        latitude = getIntent().getExtras().getDouble("lat");
        longitude = getIntent().getExtras().getDouble("long");

        GeoPoint centerPoint = new GeoPoint(latitude, longitude);
        mapController.setCenter(centerPoint);

        MyLocationNewOverlay locationNewOverlay = new MyLocationNewOverlay(new
                GpsMyLocationProvider(getApplicationContext()),mapView);
        locationNewOverlay.enableMyLocation();
        mapView.getOverlays().add(locationNewOverlay);

        CompassOverlay compassOverlay = new CompassOverlay(getApplicationContext(), new
                InternalCompassOrientationProvider(getApplicationContext()), mapView);
        compassOverlay.enableCompass();
        mapView.getOverlays().add(compassOverlay);

        final Context context = this.getApplicationContext();
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        ScaleBarOverlay scaleBarOverlay = new ScaleBarOverlay(mapView);
        scaleBarOverlay.setCentred(true);
        scaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);
        mapView.getOverlays().add(scaleBarOverlay);

        Marker marker = new Marker(mapView);

        title = getIntent().getExtras().getString("title");
        address = getIntent().getExtras().getString("address");
        description = getIntent().getExtras().getString("desc");

        marker.setPosition(new GeoPoint(latitude, longitude));
        mapView.getOverlays().add(marker);
        marker.setIcon(ResourcesCompat.getDrawable(getResources(), org.osmdroid.library.R.drawable.osm_ic_follow_me_on, null));
        marker.setTitle(title);

        marker.setOnMarkerClickListener((marker1, mapView) -> {
            createPopup();
            return true;
        });

        startDrawing();
    }

    private void createPopup() {
        View popupView = LayoutInflater.from(this).inflate(R.layout.point_description, null);

        int width = 800;
        int height = 650;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        ((TextView) popupView.findViewById(R.id.place)).setText(title);
        ((TextView) popupView.findViewById(R.id.address)).setText(this.address);
        ((TextView) popupView.findViewById(R.id.description)).setText(description);

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    private void startDrawing() {
        FusedLocationProviderClient fusedLocation = LocationServices.getFusedLocationProviderClient(this);
        fusedLocation.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location == null) {
                    Toast.makeText(getApplicationContext(), "Warning", Toast.LENGTH_SHORT).show();
                } else {
                    drawPath(new GeoPoint(latitude, longitude), new GeoPoint(location.getLatitude(), location.getLongitude()));
                }
            }
        });
    }

    private void drawPath(GeoPoint placePoint, GeoPoint userPoint) {
        Polyline polyline = new Polyline(mapView);
        polyline.addPoint(placePoint);
        polyline.addPoint(userPoint);
        polyline.setColor(Color.RED);

        mapView.getOverlays().add(polyline);
    }

    @Override
    public void onResume() {
        super.onResume();
        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Configuration.getInstance().save(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        if (mapView != null) {
            mapView.onPause();
        }
    }
}