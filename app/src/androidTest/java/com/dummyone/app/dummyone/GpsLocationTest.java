package com.dummyone.app.dummyone;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.test.AndroidTestCase;

/**
 * Created by yair.carreno on 04/04/2015.
 */
public class GpsLocationTest extends AndroidTestCase {

    private LocationManager locationManager;

    /**
     * Prior to running this test the GPS location must be set to the following
     * longitude and latitude coordinates via the geo fix command
     */
    private static final double LONGITUDE = -74.05513773005812;
    private static final double LATITUDE = 4.7509141860682425;
    @Override
    protected void setUp() throws Exception {
        locationManager = (LocationManager) getContext().
                getSystemService(Context.LOCATION_SERVICE);
        assertNotNull(locationManager);
    }
    /**
     * verify that the last location equals to the location set
     * via geo fix command
     */
    public void testCurrentLocationGivenLocation(){
        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        assertNotNull(lastLocation);
        assertEquals(lastLocation.getLongitude(), LONGITUDE);
        assertEquals(lastLocation.getLatitude(), LATITUDE);
    }
}
