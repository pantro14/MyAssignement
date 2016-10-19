package com.rabobank.davidpardo.myassignement.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.model.Issue;
import com.rabobank.davidpardo.myassignement.view.AssignementActivity;

import java.util.ArrayList;

/**
 * Created by davidpardo on 10/17/16.
 */

public class IssueListAdapter extends ArrayAdapter<Issue> {
    private int resource;

    public ArrayList<Issue> issueList;
    public AssignementActivity appContext;


    public IssueListAdapter(AssignementActivity appContext, int resource, ArrayList<Issue> issueList) {
        super(appContext, resource, issueList);
        this.appContext = appContext;
        this.resource = resource;
        this.issueList = issueList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        return appContext.UpdateCustomItemListView(position, resource, issueList);
    }
}
