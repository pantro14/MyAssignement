package com.rabobank.davidpardo.myassignement.presenter;

import android.view.View;


import java.util.ArrayList;

/**
 * Created by davidpardo on 10/19/16.
 */

public interface IssueViewInterface {

    public void updateListView(ArrayList<ArrayList<String>> issueList);

    public View updateCustomItemListView(int position, ArrayList<ArrayList<String>> issueList, View view);
}
