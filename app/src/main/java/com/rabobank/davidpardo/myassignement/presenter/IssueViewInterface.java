package com.rabobank.davidpardo.myassignement.presenter;

import android.view.View;

import com.rabobank.davidpardo.myassignement.model.Issue;

import java.util.ArrayList;

/**
 * Created by davidpardo on 10/19/16.
 */

public interface IssueViewInterface {

    public void updateListView(ArrayList<Issue> issueList);

    public View UpdateCustomItemListView(int position, int resource, ArrayList<Issue> issueList);
}
