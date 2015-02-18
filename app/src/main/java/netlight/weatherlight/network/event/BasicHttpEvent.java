package netlight.weatherlight.network.event;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class BasicHttpEvent {

    private Response response;
    private RetrofitError error;

    public BasicHttpEvent(RetrofitError error) {
        this.error = error;
    }
    public BasicHttpEvent(Response response) {
        this.response = response;
    }

    public boolean isSuccessful () { return this.response != null && this.response.getStatus() <= 209 && this.response.getStatus() >= 200; }

}
