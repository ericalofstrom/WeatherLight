package netlight.weatherlight.network.event;

import retrofit.RetrofitError;

public class OnHttpFailedEvent extends BasicHttpEvent {

    public OnHttpFailedEvent(RetrofitError error) {
        super(error);
    }
}
