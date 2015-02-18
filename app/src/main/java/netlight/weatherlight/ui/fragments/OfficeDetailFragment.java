package netlight.weatherlight.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    private static final String OFFICE_NAME = "name";

    private String mOfficeName;

    @InjectView(R.id.office_name_header) TextView officeHeader;
    @InjectView(R.id.weather_name) TextView weatherName;
    @InjectView(R.id.weather_description) TextView watherDescription;
    @InjectView(R.id.weather_image) ImageView weatherIcon;

    public static OfficeDetailFragment newInstance(String name) {
        OfficeDetailFragment fragment = new OfficeDetailFragment();
        Bundle args = new Bundle();
        args.putString(OFFICE_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    public OfficeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mOfficeName = getArguments().getString(OFFICE_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
        ServiceProvider.getWeatherService().onFetchOfficeWeather(mOfficeName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        officeHeader.setText(mOfficeName);
    }

    @Subscribe
    public void onFethcOfficeWeather(OnHttpSuccessEvent event) {
        setupForecast(event.getOfficeWeather());
    }

    @Subscribe
    public void onFethcOfficeWeatherFailed(OnHttpFailedEvent event) {

    }

    public void setupForecast(OfficeWeather forecast) {
        weatherName.setText(forecast.weather.get(0).main);
        watherDescription.setText(forecast.weather.get(0).description);

    }
}
