package netlight.weatherlight.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import netlight.weatherlight.R;

public class OfficeDetailFragment extends Fragment {

    private static final String OFFICE_CITY = "city";
    private static final String OFFICE_COUNTRY = "country";

    private static final String imageUrl = "http://openweathermap.org/img/w/";

    private String mOfficeCity;
    private String mOfficeCountry;


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
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
