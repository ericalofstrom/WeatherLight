package netlight.weatherlight.ui.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import netlight.weatherlight.R;

public class OfficeDetailFragment extends Fragment {

    private static final String OFFICE_NAME = "name";

    private String mOfficeName;

    @InjectView(R.id.office_name_header)
    TextView officeHeader;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        officeHeader.setText(mOfficeName);
    }
}
