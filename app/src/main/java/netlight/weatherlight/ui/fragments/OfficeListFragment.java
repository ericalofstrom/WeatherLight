package netlight.weatherlight.ui.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import netlight.weatherlight.R;
import netlight.weatherlight.manager.OfficeManager;
import netlight.weatherlight.model.Office;
import netlight.weatherlight.model.OfficeClickedListener;
import netlight.weatherlight.ui.adapters.OfficeAdapter;


public class OfficeListFragment extends Fragment {


    @InjectView(R.id.office_recycler_view)
    RecyclerView mRecyclerView;

    private OfficeAdapter mAdapter;

    public OfficeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Office> offices = OfficeManager.getNetlightOffices();
        mAdapter = new OfficeAdapter(getActivity(), offices);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_office_list, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }


}
