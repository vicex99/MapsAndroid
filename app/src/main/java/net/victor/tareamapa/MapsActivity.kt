package net.victor.tareamapa

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.UiSettings
import android.widget.CheckBox


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mUiSettings: UiSettings

//    private val mMyLocationButtonCheckbox: CheckBox? = null
//
//    private val mMyLocationLayerCheckbox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

//        mMyLocationButtonCheckbox = (CheckBox) findViewById(R.id.mylocationbutton_toggle);
//        mMyLocationLayerCheckbox = (CheckBox) findViewById(R.id.mylocationlayer_toggle);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }

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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mUiSettings = mMap.uiSettings

        mUiSettings.isZoomControlsEnabled = true

//        mUiSettings.setZoomControlsEnabled(isChecked(R.id.zoom_buttons_toggle));
//        mUiSettings.setCompassEnabled(isChecked(R.id.compass_toggle));
//        mUiSettings.setMyLocationButtonEnabled(isChecked(R.id.mylocationbutton_toggle));
//        mMap.setMyLocationEnabled(isChecked(R.id.mylocationlayer_toggle));

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
