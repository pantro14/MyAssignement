package com.rabobank.davidpardo.myassignement.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.presenter.UpdateIssuesAsyncTask;

public class AssignementActivity extends AppCompatActivity {
    private ListView listViewIssue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignement);
        listViewIssue = (ListView) findViewById(R.id.issue_list_view);

        UpdateIssuesAsyncTask task = new UpdateIssuesAsyncTask(getBaseContext());
        task.execute(listViewIssue);
    }



}
