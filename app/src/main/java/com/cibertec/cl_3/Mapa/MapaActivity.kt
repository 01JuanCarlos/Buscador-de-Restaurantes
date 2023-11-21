package com.cibertec.cl_3.Mapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.cl_3.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private var latitud: String = ""
    private var longitud: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)
        latitud = intent.getStringExtra("lat") ?: ""
        longitud = intent.getStringExtra("long") ?: ""
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        val positionMarker = LatLng(latitud.toDouble(), longitud.toDouble())

        map.addMarker(
            MarkerOptions()
                .position(positionMarker)
                .title("titulo")
        )

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(positionMarker, 18f),
            4000,
            null
        )

        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isRotateGesturesEnabled = false
    }
}