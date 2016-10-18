package com.rabobank.davidpardo.myassignement.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.model.Issue;

import java.util.ArrayList;

/**
 * Created by davidpardo on 10/17/16.
 */

public class IssueListAdapter extends ArrayAdapter<Issue> {
    private int resource;

    public ArrayList<Issue> issueList;
    public Context appContext;


    public IssueListAdapter(Context appContext, int resource, ArrayList<Issue> issueList) {
        super(appContext, resource, issueList);
        this.appContext = appContext;
        this.resource = resource;
        this.issueList = issueList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) appContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View rowView= inflater.inflate(resource, null, true);

        TextView txtIssueFirstName = (TextView) rowView.findViewById(R.id.txt_FisrtName);
        TextView txtIssueSurtName = (TextView) rowView.findViewById(R.id.txt_SurName);
        TextView txtIssueIssueCount = (TextView) rowView.findViewById(R.id.txt_IssueCount);
        TextView txtIssueDateBirth = (TextView) rowView.findViewById(R.id.txt_DateBirth);

        txtIssueFirstName.setText(issueList.get(position).getfirstName());
        txtIssueSurtName.setText(issueList.get(position).getSurname());
        txtIssueIssueCount.setText(issueList.get(position).getIssueCount());
        txtIssueDateBirth.setText(issueList.get(position).getDateOfBirth());

        return rowView;
    }
}
