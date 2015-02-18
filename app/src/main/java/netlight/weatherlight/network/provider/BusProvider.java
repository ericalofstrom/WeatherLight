package netlight.weatherlight.network.provider;

import com.squareup.otto.Bus;

public class BusProvider {

    private static final Bus BUS = new Bus();

    private BusProvider () {
    }

    public static Bus getBus () {
        return BUS;
    }
}
