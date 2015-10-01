package com.antyzero.rxspid;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.spid.android.sdk.SPiDClient;

import static org.assertj.core.api.Assertions.assertThat;


public class RxSPiDTest extends ApplicationTestCase<Application> {

    public RxSPiDTest() {
        super( Application.class );
    }

    public void testWrapperCreation() throws Exception {

        // given
        SPiDClient sPidClient = SPiDClient.getInstance();

        // when
        RxSPiD rxSPiD = new RxSPiD( sPidClient );

        // then
        assertThat( rxSPiD ).isNotNull();
    }
}