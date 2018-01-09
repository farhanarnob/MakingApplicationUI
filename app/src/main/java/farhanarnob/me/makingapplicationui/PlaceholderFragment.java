package farhanarnob.me.makingapplicationui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    String[] values, valuesMobile;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private int layoutID = 0;
    private int layoutNo = 0;
    private ListView listViewOne;
    private ListView listViewTwo;
    private Spinner spinnerGender, spinnerBirth, spinnerMarital, spinnerEducation, spinnerProducer, SpinnerPhone;
    private ArrayList<String> list;
    private StableArrayAdapter adapter, adapterMobile;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};
        valuesMobile = new String[]{"+880", "+521", "+520",
                "+851", "+201"};

        list = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        adapter = new StableArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
        list = new ArrayList<>();
        for (int i = 0; i < valuesMobile.length; ++i) {
            list.add(valuesMobile[i]);
        }
        adapterMobile = new StableArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int argNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (argNumber) {
            case 1: {
                layoutID = R.layout.fragment_one;
                layoutNo = 1;
                break;
            }
            case 2: {
                layoutID = R.layout.fragment_two;
                layoutNo = 2;
                break;
            }
            case 3: {
                layoutID = R.layout.fragment_three;
                layoutNo = 3;
                break;
            }
        }
        View rootView = inflater.inflate(layoutID, container, false);
        switch (argNumber) {
            case 1: {
                listViewOne = rootView.findViewById(R.id.list_view_one);
                listViewTwo = rootView.findViewById(R.id.list_view_two);
                break;
            }
            case 2: {

                break;
            }
            case 3: {
                spinnerGender = rootView.findViewById(R.id.spinner_gender);
                spinnerBirth = rootView.findViewById(R.id.spinner_birth);
                spinnerMarital = rootView.findViewById(R.id.spinner_marital);
                spinnerEducation = rootView.findViewById(R.id.spinner_education);
                spinnerProducer = rootView.findViewById(R.id.spinner_producer);
                SpinnerPhone = rootView.findViewById(R.id.spinner_phone);
                break;
            }
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        switch (layoutNo) {
            case 1: {

                listViewOne.setAdapter(adapter);
                listViewTwo.setAdapter(adapter);
                break;
            }
            case 2: {

                break;
            }
            case 3: {
                spinnerGender.setAdapter(adapter);
                spinnerBirth.setAdapter(adapter);
                spinnerMarital.setAdapter(adapter);
                spinnerEducation.setAdapter(adapter);
                spinnerProducer.setAdapter(adapter);
                SpinnerPhone.setAdapter(adapterMobile);
                break;
            }
        }
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}