package com.rabobank.davidpardo.myassignement.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.model.ParserTool;
import com.rabobank.davidpardo.myassignement.view.AssignementActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by davidpardo on 10/18/16.
 */

public class UpdateIssuesAsyncTask extends AsyncTask<Void, Void, Void> {
    MediatorIssue mediatorIssue;
    public ArrayList<ArrayList<String>> issueList;
    public IssueListAdapter issueAdapter;

    public UpdateIssuesAsyncTask(MediatorIssue mediatorIssue) {
        super();
        this.issueList = new ArrayList<ArrayList<String>>();
        this.mediatorIssue = mediatorIssue;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        ParserTool parserTool = new ParserTool(mediatorIssue.getAppContext());
        try {
            issueList = parserTool.getListIssue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mediatorIssue.mediatorCallback(issueList);
    }
}
