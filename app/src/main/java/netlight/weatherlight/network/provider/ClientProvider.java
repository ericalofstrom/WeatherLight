package netlight.weatherlight.network.provider;

import netlight.weatherlight.network.service.Generator;
import netlight.weatherlight.network.service.WeatherApi;

public class ClientProvider {


    private static WeatherApi weatherApi;

    private ClientProvider(){
        //Keep it single!
    }

    public static WeatherApi getWeatherApi() {

        if (weatherApi == null) {
            weatherApi = Generator.create(WeatherApi.class);
        }
        return weatherApi;
    }
}
