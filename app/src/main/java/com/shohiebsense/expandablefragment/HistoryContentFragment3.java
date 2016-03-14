package com.shohiebsense.expandablefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andexert.expandablelayout.library.ExpandableLayoutListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shohieb on 3/14/2016.
 */
public class HistoryContentFragment3 extends Fragment {

    private com.andexert.expandablelayout.library.ExpandableLayoutListView expandableLayoutListView;

    //Search Bar
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;

    private List<History> historyList;
    private View layoutView;

    HistoryArrayAdapter adapter;
    Button btn;

    public HistoryContentFragment3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }


        layoutView = inflater.inflate(R.layout.history_tab,
                container, false);/*

        LinearLayout headerLayout = (LinearLayout) layoutView.findViewById(R.id.headerLayout);
        headerLayout.setGravity(Gravity.CENTER);*/

        TextView period = (TextView) layoutView.findViewById(R.id.header_item_text);
        period.setText("Terbentuknya Umat Islam");
        period.setTextColor(getResources().getColor(R.color.LightGrayishGreen));
        /*period.setBackgroundColor(getResources().getColor(R.color.LightGrayishGreen));*/
        period.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams params = period.getLayoutParams();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        period.setLayoutParams(params);

        btn = (Button) layoutView.findViewById(R.id.imagebutton);
       /* btn.setVisibility(View.INVISIBLE);*/


        RelativeLayout layout = (RelativeLayout) layoutView.findViewById(R.id.viewcontent);
        layout.removeView(btn);

        populateListView(layoutView);

        return layoutView;
    }


    private void populateListView(View layoutView){
        expandableLayoutListView = (ExpandableLayoutListView) layoutView.findViewById(R.id.historyListView);


        historyList = new ArrayList<History>();
        // This is how, a reference of DAO object can be done
        // Query the database. We need all the records so, used queryForAll()
        History newUser = new History(1,"1","a","a");
        historyList.add(newUser);

        adapter = new HistoryArrayAdapter(getActivity(), R.layout.view_row, R.id.header_item_text, historyList);
        //Now, link the  RecordArrayAdapter with the ListView
        expandableLayoutListView.setAdapter(adapter);

    }


}
