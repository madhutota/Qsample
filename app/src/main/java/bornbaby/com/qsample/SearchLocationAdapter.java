package bornbaby.com.qsample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bornbaby.com.qsample.models.LocationModel;

public class SearchLocationAdapter extends ArrayAdapter<LocationModel> {
    private ArrayList<LocationModel> mList;
    private ArrayList<LocationModel> sortedList;
    private LayoutInflater inflater;
    private Typeface mProximaNovaRegular;

    public SearchLocationAdapter(Context context, int textViewResourceId, ArrayList<LocationModel> mList) {
        super(context, textViewResourceId, mList);
        this.mList = mList;
        FragmentActivity context1 = (FragmentActivity) context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public LocationModel getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item_location, parent, false);
            holder = new ViewHolder();

            holder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
            holder.tv_location.setTypeface(mProximaNovaRegular);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        LocationModel model = mList.get(position);

        /*NAME*/
        holder.tv_location.setText(model.getmArea());

        return convertView;
    }

    private class ViewHolder {
        TextView tv_location;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mList = (ArrayList<LocationModel>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                List<LocationModel> FilteredArrList = new ArrayList<>();


                if (sortedList == null) {
                    sortedList = new ArrayList<>(mList); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = sortedList.size();
                    results.values = sortedList;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < sortedList.size(); i++) {
                        LocationModel data = sortedList.get(i);
                        if (data.getmArea().toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(data);
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
    }
}
