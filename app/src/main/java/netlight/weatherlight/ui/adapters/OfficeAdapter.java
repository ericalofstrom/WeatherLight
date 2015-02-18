package netlight.weatherlight.ui.adapters;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import netlight.weatherlight.R;
import netlight.weatherlight.manager.OfficeManager;
import netlight.weatherlight.model.Office;
import netlight.weatherlight.model.OfficeClickedListener;

/**
 * Created by olak on 17.02.15.
 */
public class OfficeAdapter extends RecyclerView.Adapter<OfficeAdapter.ViewHolder> {
    private List<Office> mOffices;
    private Activity mActivity;


    public OfficeAdapter(Activity activity, List<Office> offices) {
        mActivity = activity;
        mOffices = offices;

    }

    @Override
    public OfficeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_office_item, parent, false);
        ViewHolder vh = new ViewHolder(v, (OfficeClickedListener) mActivity);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Office currentOffice = mOffices.get(position);
        holder.officeName.setText(currentOffice.getCity()+", "+currentOffice.getCountry());
    }

    @Override
    public int getItemCount() {
        return mOffices.size();
    }

    public Office getItemAt(int pos) {
        return mOffices.get(pos);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView officeName;
        public OfficeClickedListener mListener;

        public ViewHolder(View v, OfficeClickedListener listener) {
            super(v);
            mListener = listener;
            officeName = (TextView) v.findViewById(R.id.office_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.officeClicked(OfficeManager.getOfficeAt(this.getPosition()));
        }
    }

}