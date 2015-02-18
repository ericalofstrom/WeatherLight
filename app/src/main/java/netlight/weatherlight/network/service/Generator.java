package netlight.weatherlight.network.service;

import com.squareup.okhttp.OkHttpClient;

import netlight.weatherlight.BuildConfig;
import netlight.weatherlight.network.jackson.JacksonConverter;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Created by amgh on 18/02/15.
 */
public class Generator {

    private static final String TAG = Generator.class.getSimpleName() + " -> ";


    public static <S> S create(Class<S> serviceClass) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint(BuildConfig.SERVER_URL)
                .setConverter(new JacksonConverter())
                //.setRequestInterceptor(requestInterceptor)
                //.setErrorHandler(errorHandler)
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("WL -#-"));

        RestAdapter restAdapter = builder.build();
        return restAdapter.create(serviceClass);
    }
}
