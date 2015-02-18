package netlight.weatherlight.model;

/**
 * Created by olak on 17.02.15.
 */
public class Office {

    private String city;
    private String country;

    public Office(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
