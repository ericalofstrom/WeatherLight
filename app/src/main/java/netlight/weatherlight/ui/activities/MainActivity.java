package netlight.weatherlight.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import netlight.weatherlight.R;
import netlight.weatherlight.model.Office;
import netlight.weatherlight.model.OfficeClickedListener;
import netlight.weatherlight.ui.fragments.OfficeDetailFragment;
import netlight.weatherlight.ui.fragments.OfficeListFragment;


public class MainActivity extends ActionBarActivity implements OfficeClickedListener, FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new OfficeListFragment())
                    .commit();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
    }

    @Override
    public void officeClicked(Office office) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, OfficeDetailFragment.newInstance(office.getCity() + ", " + office.getCountry()))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackStackChanged() {
        int backstackCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backstackCount > 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}
