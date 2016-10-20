package com.rabobank.davidpardo.myassignement.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.rabobank.davidpardo.myassignement.view.AssignementActivity;

import java.util.ArrayList;

/**
 * Created by davidpardo on 10/17/16.
 */

public class IssueListAdapter extends ArrayAdapter<ArrayList<String>> {
    private int resource;

    public ArrayList<ArrayList<String>> issueList;
    public AssignementActivity appContext;


    public IssueListAdapter(AssignementActivity appContext, int resource, ArrayList<ArrayList<String>> issueList) {
        super(appContext, resource, issueList);
        this.appContext = appContext;
        this.resource = resource;
        this.issueList = issueList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        return appContext.updateCustomItemListView(position, issueList, convertView);
    }
}
