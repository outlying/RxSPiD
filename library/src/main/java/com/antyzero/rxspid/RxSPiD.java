package com.antyzero.rxspid;

import com.spid.android.sdk.SPiDClient;
import com.spid.android.sdk.listener.SPiDRequestListener;
import com.spid.android.sdk.response.SPiDResponse;

/**
 * Main wrapper for SPiD client
 */
public class RxSPiD {

    private SPiDClient sPiDClient;

    public RxSPiD( SPiDClient sPiDClient ) {
        this.sPiDClient = sPiDClient;
    }

    public void getCurrentUser() {

        sPiDClient.getCurrentUser( new SPiDRequestListener() {
            @Override
            public void onComplete( SPiDResponse result ) {

            }

            @Override
            public void onError( Exception exception ) {

            }
        } );
    }
}
