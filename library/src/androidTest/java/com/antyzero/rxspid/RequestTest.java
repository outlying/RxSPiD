package com.antyzero.rxspid;


import android.app.Application;
import android.test.ApplicationTestCase;

import com.spid.android.sdk.SPiDClient;
import com.spid.android.sdk.configuration.SPiDConfigurationBuilder;
import com.spid.android.sdk.configuration.SPiDEnvironment;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.mockwebserver.MockWebServer;

public class RequestTest extends ApplicationTestCase<Application> {

    private RxSPiD rxSPiD;
    private MockWebServer server;

    public RequestTest() {
        super( Application.class );
    }

    public void testCurrentUser() throws Exception {

        // given


        // when
        rxSPiD.getCurrentUser();

        // then

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        createApplication();

        server = new MockWebServer();
        HttpUrl httpUrl = server.url( "" );
        String serverUrl = httpUrl.toString();

        SPiDConfigurationBuilder sPiDConfigurationBuilder = new SPiDConfigurationBuilder(
                getApplication(),
                SPiDEnvironment.NORWEGIAN_STAGE,
                "",
                "",
                "" );

        sPiDConfigurationBuilder
                .authorizationURL( serverUrl )
                .registrationURL( serverUrl )
                .tokenURL( serverUrl );

        SPiDClient sPiDClient = SPiDClient.getInstance();
        sPiDClient.configure( sPiDConfigurationBuilder.build() );
        rxSPiD = new RxSPiD( sPiDClient );
    }

    @Override
    public void tearDown() throws Exception {
        rxSPiD = null;
        super.tearDown();
    }
}
