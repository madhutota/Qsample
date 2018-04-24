package bornbaby.com.qsample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bornbaby.com.qsample.MainActivity;
import bornbaby.com.qsample.R;


public class HomeFragment extends Fragment {
    public  static final String TAG = HomeFragment.class.getSimpleName();
    private MainActivity mainActivity;
    private HorizontalScrollView scroll_view_top_locations;
    LinearLayout lly_top_locations;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lly_top_locations = view.findViewById(R.id.lly_top_locations);
        scroll_view_top_locations = view.findViewById(R.id.scroll_view_top_locations);


       setTopLocationData();

    }

    private void setTopLocationData() {

        for (int i = 0; i < 10 ;i++) {
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.top_items, null);

            ImageView iv_profile_pic = (ImageView) linearLayout.findViewById(R.id.iv_profile_pic);

            /*LOCATION NAME*/
            TextView tv_top_location = (TextView) linearLayout.findViewById(R.id.tv_top_location);

            /*ON CLICK*/
            LinearLayout mLinearLayout = (LinearLayout) linearLayout.findViewById(R.id.ll_top_cities);
            mLinearLayout.setTag(i);
            lly_top_locations.addView(mLinearLayout);
        }
    }


}
