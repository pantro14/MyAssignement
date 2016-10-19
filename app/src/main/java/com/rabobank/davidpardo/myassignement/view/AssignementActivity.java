package com.rabobank.davidpardo.myassignement.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.model.Issue;
import com.rabobank.davidpardo.myassignement.presenter.IssueListAdapter;
import com.rabobank.davidpardo.myassignement.presenter.IssueViewInterface;
import com.rabobank.davidpardo.myassignement.presenter.UpdateIssuesAsyncTask;

import java.util.ArrayList;

public class AssignementActivity extends AppCompatActivity implements IssueViewInterface{
    private ListView listViewIssue;
    ArrayList<Issue> issueList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignement);
        listViewIssue = (ListView) findViewById(R.id.issue_list_view);
        issueList = new ArrayList<Issue>();

        updateIsueeList();
    }

    public void updateIsueeList(){
        UpdateIssuesAsyncTask task = new UpdateIssuesAsyncTask(AssignementActivity.this, issueList);
        task.execute();
    }


    @Override
    public void updateListView(ArrayList<Issue> issueList) {
        View IssueTableTitle = (View) LayoutInflater.from(getBaseContext()).inflate(R.layout.issue_table_title, null);
        listViewIssue.addHeaderView(IssueTableTitle);
        IssueListAdapter issueListAdapter = new IssueListAdapter(AssignementActivity.this, R.layout.issue_items, issueList);
        listViewIssue.setAdapter(issueListAdapter);
    }

    @Override
    public View UpdateCustomItemListView(int position, int resource, ArrayList<Issue> issueList) {
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService( getBaseContext().LAYOUT_INFLATER_SERVICE );
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
