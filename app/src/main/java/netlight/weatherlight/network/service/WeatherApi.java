package netlight.weatherlight.network.service;

import netlight.weatherlight.model.weather.OfficeWeather;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


public interface WeatherApi {

    static final String WEATHER_URL = "/weather";


    @GET (WEATHER_URL)
    void fetchOfficeWeather (

            @Query ("q") String city,
            Callback<OfficeWeather> callback
    );
}
