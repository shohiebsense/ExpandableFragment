package com.shohiebsense.expandablefragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shohieb on 3/14/2016.
 */
public class HistoryArrayAdapter extends ArrayAdapter<History> implements Filterable, View.OnClickListener {

    private LayoutInflater inflater;

    private PackageManager packageManager;
    private LinearLayout llContainer;
    private String translation;
    Context context;

    @Override
    public void onClick(View v) {

    }

    static class ViewHolder {
        public TextView headerText, historyText;
        public Button imgbutton;
    }

    private History history;

    // This would hold the database objects. It could be TeacherDetails or StudentDetails objects
    private List records;
    private List<History> listrecords = null;



    // Declaration of DAO to interact with corresponding table
    SharedPreferences preferences;

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    @SuppressWarnings("unchecked")
    public HistoryArrayAdapter(Context context, int view_row,int header_text, List histories) {
        super(context, view_row, header_text, histories);

        this.context = context;
        this.records = histories;
        packageManager = context.getPackageManager();
        this.listrecords = new ArrayList<History>(); //Added here
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {

            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_row, parent, false);
            ViewHolder holder = new ViewHolder();

            holder.historyText = (TextView) convertView.findViewById(R.id.historyText);

            holder.headerText =  (TextView) convertView.findViewById(R.id.header_item_text);
            holder.imgbutton = (Button) convertView.findViewById(R.id.imagebutton);
            holder.imgbutton.setOnClickListener(HistoryArrayAdapter.this);

            convertView.setTag(holder);
        }

        final ViewHolder holder =(ViewHolder) convertView.getTag();

       /* Log.d("nganu", translation);*


       /* final History currentHistory = (History) records.get(position);*/
        final History currentHistory =  getItem(position);

       /* final TextView headerText =*/
        holder.headerText.setText(currentHistory.getPeriod());

        holder.historyText.setText(currentHistory.getDescription());
        holder.historyText.setTag(currentHistory.getId_history());

        return convertView;
    }
}