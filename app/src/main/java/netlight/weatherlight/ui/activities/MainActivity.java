package netlight.weatherlight.ui.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import netlight.weatherlight.R;
import netlight.weatherlight.model.Office;
import netlight.weatherlight.model.OfficeClickedListener;
import netlight.weatherlight.ui.fragments.OfficeDetailFragment;
import netlight.weatherlight.ui.fragments.OfficeListFragment;


public class MainActivity extends ActionBarActivity implements OfficeClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new OfficeListFragment())
                    .commit();
        }
    }

    @Override
    public void officeClicked(Office office) {
        getFragmentManager().beginTransaction()
                .add(R.id.container, OfficeDetailFragment.newInstance(office.getCity() + ", " + office.getCountry()))
                .addToBackStack(null)
                .commit();
    }


}
