package bornbaby.com.qsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import bornbaby.com.qsample.models.LocationModel;
import bornbaby.com.qsample.utils.Constants;
import bornbaby.com.qsample.utils.Utility;

public class LocationActivity extends AppCompatActivity {
    private SearchLocationAdapter adapter;
    private ListView lv_locations;
    private EditText et_search;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        initui();
    }

    private void initui() {
        lv_locations = findViewById(R.id.lv_locations);
        et_search = findViewById(R.id.et_search);
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSearchLocationData();
        implementSearch();


    }

    private void implementSearch() {

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setSearchLocationData() {
        adapter = new SearchLocationAdapter(this, 100, getSearchLocationList());
        lv_locations.setAdapter(adapter);
        lv_locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Utility.hideSoftKeyPad(LocationActivity.this);
                adapter.getFilter().filter("");
                LocationModel model = (LocationModel) adapterView.getAdapter().getItem(position);

                Intent intent = new Intent(LocationActivity.this, MainActivity.class);
                intent.putExtra(Constants.CITY_NAME, model.getmArea());
                startActivity(intent);
                finish();

            }
        });
    }

    private ArrayList<LocationModel> getSearchLocationList() {
        ArrayList<LocationModel> locationListModels = new ArrayList<>();
        /*Need to remove*/
        LocationModel locationModel = new LocationModel();
        locationModel.setmArea("Chennai");
        locationListModels.add(locationModel);

        LocationModel locationModel1 = new LocationModel();
        locationModel1.setmArea("Mumbai");
        locationListModels.add(locationModel1);

        LocationModel locationModel2 = new LocationModel();
        locationModel2.setmArea("Kolkata");
        locationListModels.add(locationModel2);

        LocationModel locationModel3 = new LocationModel();
        locationModel3.setmArea("Bengaluru");
        locationListModels.add(locationModel3);

        LocationModel locationModel4 = new LocationModel();
        locationModel4.setmArea("pune");
        locationListModels.add(locationModel4);

        LocationModel locationModel5 = new LocationModel();
        locationModel5.setmArea("Ahmedabad");
        locationListModels.add(locationModel5);

        LocationModel locationModel6 = new LocationModel();
        locationModel6.setmArea("Hyderabad");
        locationListModels.add(locationModel6);

        LocationModel locationModel7 = new LocationModel();
        locationModel7.setmArea("New Delhi");
        locationListModels.add(locationModel7);

        LocationModel locationModel8 = new LocationModel();
        locationModel8.setmArea("Jaipur");
        locationListModels.add(locationModel8);

        LocationModel locationModel9 = new LocationModel();
        locationModel9.setmArea("Kochi");
        locationListModels.add(locationModel9);

        LocationModel locationModel10 = new LocationModel();
        locationModel10.setmArea("Lucknow");
        locationListModels.add(locationModel10);

        LocationModel locationModel11 = new LocationModel();
        locationModel11.setmArea("Surat");
        locationListModels.add(locationModel11);

        LocationModel locationModel12 = new LocationModel();
        locationModel12.setmArea("Bhopal");
        locationListModels.add(locationModel12);

        LocationModel locationModel13 = new LocationModel();
        locationModel13.setmArea("Vadodara");
        locationListModels.add(locationModel13);

        return locationListModels;
    }

}
