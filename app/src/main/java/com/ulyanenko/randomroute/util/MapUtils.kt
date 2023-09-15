package com.ulyanenko.randomroute.util

import android.graphics.Color
import org.osmdroid.util.GeoPoint
import java.util.*

object MapUtils {

    fun getRandomDestination(currentLocation: GeoPoint): GeoPoint {
        val random = Random()
        val randomLatitude = currentLocation.latitude + (random.nextDouble() - 0.5) * 0.2
        val randomLongitude = currentLocation.longitude + (random.nextDouble() - 0.5) * 0.2
        return GeoPoint(randomLatitude, randomLongitude)
    }

    fun getRandomRouteColor(): Int {
        val colors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN)
        val random = Random()
        return colors[random.nextInt(colors.size)]
    }
}