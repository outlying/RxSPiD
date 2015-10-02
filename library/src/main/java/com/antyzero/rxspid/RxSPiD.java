package com.antyzero.rxspid;

import com.spid.android.sdk.SPiDClient;
import com.spid.android.sdk.listener.SPiDRequestListener;
import com.spid.android.sdk.response.SPiDResponse;

import rx.Observable;

/**
 * Main wrapper for SPiD client
 */
public class RxSPiD {

    private SPiDClient sPiDClient;

    public RxSPiD( SPiDClient sPiDClient ) {
        this.sPiDClient = sPiDClient;
    }

    public Observable<SPiDResponse> getCurrentUser() {
        return new SPiDRequestObservable( sPiDClient );
    }
}
