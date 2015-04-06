package com.dummyone.app.dummyone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.AndroidTestCase;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yair.carreno on 04/04/2015.
 */
public class ConnectivityTest extends AndroidTestCase {

    private ConnectivityManager connectivity;
    //Connection attempt will be made to google.com
    private static final String  URL_NAME = "http://www.google.com";
    @Override
    protected void setUp() throws Exception {
        connectivity = (ConnectivityManager) getContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        assertNotNull(connectivity);
    }
    /**
     * Test that there is an active network
     */
    public void testActiveConnectivity() {
        NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
        assertNotNull(networkInfo);
        assertEquals( NetworkInfo.State.CONNECTED, networkInfo.getState());
    }
    /**
     * Test that a connection can be made over the active network
     */
    public void testConnectionCreation() throws IOException {
        URL url = new URL(URL_NAME);
        assertNotNull(url);
        URLConnection connection = url.openConnection();
        assertNotNull(connection);
        connection.connect();
    }
}