package netlight.weatherlight.network.client;

import com.squareup.otto.Bus;

import netlight.weatherlight.model.weather.OfficeWeather;
import netlight.weatherlight.network.event.OnHttpFailedEvent;
import netlight.weatherlight.network.event.OnHttpSuccessEvent;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by amgh on 18/02/15.
 */
public class WeatherClient {

    private static final String TAG = WeatherClient.class.getSimpleName() + " -> ";
    private static final String WEATHER_URL =  "/weather";

    public interface WeatherApi {

        @GET(WEATHER_URL)
        void fetchOfficeWeather(

                @Query("q") String city,
                Callback<OfficeWeather> callback
        );
    }


    private Bus eventBus;
    private WeatherApi weatherApi;

    public WeatherClient(Bus eventBus, WeatherApi weatherApi) {

        this.eventBus = eventBus;
        this.weatherApi = weatherApi;

    }

    public void onFetchOfficeWeather(String city) {
        this.weatherApi.fetchOfficeWeather(city, ON_FETCH_OFFICE_WEATHER_CALLBACK);
    }

    private final Callback<OfficeWeather> ON_FETCH_OFFICE_WEATHER_CALLBACK = new Callback<OfficeWeather>() {

        @Override
        public void success (OfficeWeather weather, Response response) {
            eventBus.post(new OnHttpSuccessEvent(response, weather));
        }

        @Override
        public void failure (RetrofitError error) {
            eventBus.post(new OnHttpFailedEvent(error));
        }
    };
}
