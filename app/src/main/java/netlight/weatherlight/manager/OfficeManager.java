package netlight.weatherlight.manager;

import java.util.ArrayList;
import java.util.List;

import netlight.weatherlight.model.Office;

/**
 * Created by olak on 17.02.15.
 */
public class OfficeManager {


    private List<Office> mOffices;

    public static Office getOfficeAt(int pos) {
        return getNetlightOffices().get(pos);
    }


    public static List<Office> getNetlightOffices() {
        List<Office> offices = new ArrayList<>();
        offices.add(new Office("Oslo", "Norway"));
        offices.add(new Office("Stockholm", "Sweden"));
        offices.add(new Office("Helsinki", "Finland"));
        offices.add(new Office("London", "United Kingdom"));
        offices.add(new Office("München", "Germany"));
        return offices;
    }

}
