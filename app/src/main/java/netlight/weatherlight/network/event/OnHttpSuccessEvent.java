package netlight.weatherlight.network.event;

import netlight.weatherlight.model.weather.OfficeWeather;
import retrofit.client.Response;

public class OnHttpSuccessEvent extends BasicHttpEvent {


    private OfficeWeather officeWeather;

    public OnHttpSuccessEvent (Response response, OfficeWeather officeWeather) {
        super(response);
        this.officeWeather = officeWeather;
    }

    public OfficeWeather getOfficeWeather () {
        return this.officeWeather;
    }
}
