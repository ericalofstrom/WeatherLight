package netlight.weatherlight.model.weather;

import java.util.List;

import netlight.weatherlight.model.weather.details.*;

public class OfficeWeather {

    public Coordination coord;
    public netlight.weatherlight.model.weather.details.System sys;
    public List<Weather> weather;
    public String base;
    public Main main;
    public Wind wind;
    public Cloud clouds;
    public int dt;
    public int id;
    public String name;
    public int cod;
}
