package com.antyzero.rxspid;

import com.spid.android.sdk.SPiDClient;
import com.spid.android.sdk.listener.SPiDRequestListener;
import com.spid.android.sdk.response.SPiDResponse;

import rx.Observable;
import rx.Subscriber;

/**
 *
 */
public class SPiDRequestObservable implements Observable.OnSubscribe<SPiDResponse> {

    private final SPiDClient sPiDClient;

    public SPiDRequestObservable( SPiDClient sPiDClient ) {
        this.sPiDClient = sPiDClient;
    }

    @Override
    public void call( final Subscriber<? super SPiDResponse> subscriber ) {

        SPiDRequestListener sPiDRequestListener = new SPiDRequestListener() {

            @Override
            public void onComplete( SPiDResponse result ) {
                subscriber.onNext( result );
                subscriber.onCompleted();
            }

            @Override
            public void onError( Exception exception ) {
                subscriber.onError( exception );
            }
        };

        sPiDClient.getCurrentUser( sPiDRequestListener );
    }
}
