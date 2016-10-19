package com.rabobank.davidpardo.myassignement.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by davidpardo on 10/19/16.
 */

public class ParserTool {

    private Context context;

    public ParserTool(Context context) {
        this.context = context;
    }

    public ArrayList<Issue> getListIssue() throws IOException{
        ArrayList<Issue> issueListCSV = new ArrayList<Issue>();
        InputStreamReader is = new InputStreamReader(context.getAssets()
                .open("issues.csv"));
        BufferedReader reader = new BufferedReader(is);
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] issueList = line.split(",");
            for (int i=0; i<issueList.length; i++){
                issueList[i] = issueList[i].replace("\"", "");
            }
            Issue issue = new Issue(issueList[0],
                    issueList[1],
                    issueList[2],
                    issueList[3]);
            issueListCSV.add(issue);
        }
        return issueListCSV;
    }


}
