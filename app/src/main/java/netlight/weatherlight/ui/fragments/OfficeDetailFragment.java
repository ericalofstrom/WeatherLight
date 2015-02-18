package netlight.weatherlight.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import netlight.weatherlight.R;
import netlight.weatherlight.model.weather.OfficeWeather;
import netlight.weatherlight.network.event.OnHttpFailedEvent;
import netlight.weatherlight.network.event.OnHttpSuccessEvent;
import netlight.weatherlight.network.provider.BusProvider;
import netlight.weatherlight.network.provider.ServiceProvider;

public class OfficeDetailFragment extends Fragment {

    private static final String OFFICE_CITY = "city";
    private static final String OFFICE_COUNTRY = "country";


    private String mOfficeCity;
    private String mOfficeCountry;

    @InjectView(R.id.office_name_header) TextView officeHeader;
    @InjectView(R.id.weather_name) TextView weatherName;
    @InjectView(R.id.weather_description) TextView watherDescription;
    @InjectView(R.id.weather_image) ImageView weatherIcon;

    public static OfficeDetailFragment newInstance(String city, String country) {
        OfficeDetailFragment fragment = new OfficeDetailFragment();
        Bundle args = new Bundle();
        args.putString(OFFICE_CITY, city);
        args.putString(OFFICE_COUNTRY, country);

        fragment.setArguments(args);
        return fragment;
    }

    public OfficeDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOfficeCity = getArguments().getString(OFFICE_CITY);
            mOfficeCountry = getArguments().getString(OFFICE_COUNTRY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getBus().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getBus().register(this);
        ServiceProvider.getWeatherService().onFetchOfficeWeather(mOfficeCity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        officeHeader.setText(mOfficeCity+", "+mOfficeCountry);
    }

    @Subscribe
    public void onFethchOfficeWeather(OnHttpSuccessEvent event) {
        setupForecast(event.getOfficeWeather());
    }

    @Subscribe
    public void onFethcOfficeWeatherFailed(OnHttpFailedEvent event) {
        Toast.makeText(getActivity(), getString(R.string.failed_response_message), Toast.LENGTH_LONG).show();
    }

    public void setupForecast(OfficeWeather forecast) {
        weatherName.setText(forecast.weather.get(0).main);
        watherDescription.setText(forecast.weather.get(0).description);

    }
}
