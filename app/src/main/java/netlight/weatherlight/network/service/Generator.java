package netlight.weatherlight.network.service;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import netlight.weatherlight.BuildConfig;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by amgh on 18/02/15.
 */
public class Generator {

    private static final String TAG = Generator.class.getSimpleName() + " -> ";


    public static <S> S create(Class<S> serviceClass) {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint(BuildConfig.SERVER_URL)
                .setConverter(new GsonConverter(new Gson()))
                //.setRequestInterceptor(requestInterceptor)
                //.setErrorHandler(errorHandler)
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("WL -#-"));

        RestAdapter restAdapter = builder.build();
        return restAdapter.create(serviceClass);
    }
}
