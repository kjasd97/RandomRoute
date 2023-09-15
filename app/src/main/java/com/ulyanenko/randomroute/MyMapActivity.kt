package com.ulyanenko.randomroute

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulyanenko.randomroute.databinding.ActivityMyMapBinding
import com.ulyanenko.randomroute.util.MapUtils
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Polyline

class MyMapActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMyMapBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Configuration.getInstance().load(applicationContext, getPreferences(MODE_PRIVATE))
        setupMapView()
        displayRandomRoute()


    }

    private fun setupMapView() {
        val mapView = binding.mapView
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(12.5)

        val currentLocation = GeoPoint(50.4501, 30.5234)
        mapController.setCenter(currentLocation)
    }

    private fun displayRandomRoute() {
        val currentLocation = GeoPoint(50.4501, 30.5234)
        val randomDestination = MapUtils.getRandomDestination(currentLocation)

        val route = Polyline()
        route.addPoint(currentLocation)
        route.addPoint(randomDestination)
        route.color =  MapUtils.getRandomRouteColor()
        route.width = 5f

        binding.mapView.overlays.add(route)
        binding.mapView.invalidate()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, MyMapActivity::class.java)
        }
    }


}