package netlight.weatherlight.network.provider;

import netlight.weatherlight.network.service.WeatherService;

public class ServiceProvider {

    public static WeatherService getWeatherService() {
        return new WeatherService(BusProvider.getBus(), ClientProvider.getWeatherApi());
    }
}
