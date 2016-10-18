package com.rabobank.davidpardo.myassignement.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.model.Issue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by davidpardo on 10/18/16.
 */

public class UpdateIssuesAsyncTask extends AsyncTask<ListView, Void, String> {
    ListView listViewIssue;
    Context context;
    ArrayList<Issue> issueList;

    public UpdateIssuesAsyncTask(Context context) {
        super();
        this.context = context;
    }

    @Override
    protected String doInBackground(ListView... listViews) {
        listViewIssue = listViews[0];
        issueList = getListIssue();
        return null;
    }

    @Override
    protected void onPostExecute(String o) {
        View IssueTableTitle = (View) LayoutInflater.from(context).inflate(R.layout.issue_table_title, null);
        listViewIssue.addHeaderView(IssueTableTitle);
        IssueListAdapter issueListAdapter = new IssueListAdapter(context, R.layout.issue_items, issueList);
        listViewIssue.setAdapter(issueListAdapter);
    }

    private ArrayList<Issue> getListIssue() {
        ArrayList<Issue> issueListCSV = new ArrayList<Issue>();
        try {
            InputStreamReader is = new InputStreamReader(context.getAssets()
                    .open("issues.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] issueList = line.split(",");
                Issue issue = new Issue(issueList[0].replaceAll("^\"|\"$", ""),
                        issueList[1].replaceAll("^\"|\"$", ""),
                        issueList[2].replaceAll("^\"|\"$", ""),
                        issueList[3].replaceAll("^\"|\"$", ""));
                issueListCSV.add(issue);
            }
            return issueListCSV;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
