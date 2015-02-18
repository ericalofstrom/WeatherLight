package netlight.weatherlight.manager;

import java.util.ArrayList;
import java.util.List;

import netlight.weatherlight.model.Office;

/**
 * Created by olak on 17.02.15.
 */
public class OfficeManager {


    private static List<Office> mOffices;

    public static Office getOfficeAt(int pos) {
        return mOffices.get(pos);
    }


    public static List<Office> getNetlightOffices() {
        if(mOffices == null) {
            mOffices = new ArrayList<>();
            mOffices.add(new Office("Oslo", "Norway"));
            mOffices.add(new Office("Stockholm", "Sweden"));
            mOffices.add(new Office("Helsinki", "Finland"));
            mOffices.add(new Office("London", "United Kingdom"));
            mOffices.add(new Office("München", "Germany"));
        }
        return mOffices;
    }

}
