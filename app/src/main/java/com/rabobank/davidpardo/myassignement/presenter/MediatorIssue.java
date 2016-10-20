package com.rabobank.davidpardo.myassignement.presenter;

import android.content.Context;

import com.rabobank.davidpardo.myassignement.view.AssignementActivity;

import java.util.ArrayList;

/**
 * Created by davidpardo on 10/20/16.
 */

public class MediatorIssue {
    private AssignementActivity appContext;

    public MediatorIssue() {
        super();
    }

    public MediatorIssue(AssignementActivity appContext) {
        this.appContext = appContext;
    }

    public void mediatorCallback(ArrayList<ArrayList<String>> issueList){
        appContext.updateListView(issueList);
    }

    public Context getAppContext(){
        return appContext.getBaseContext();
    }

    public void updateIsueeList(){
        UpdateIssuesAsyncTask task = new UpdateIssuesAsyncTask(this);
        task.execute();
    }

}
