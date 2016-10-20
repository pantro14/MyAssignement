package com.rabobank.davidpardo.myassignement.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by davidpardo on 10/19/16.
 */

public class ParserTool {

    private Context context;

    public ParserTool(Context context) {
        this.context = context;
    }

    public ArrayList<ArrayList<String>> getListIssue() throws IOException{
        ArrayList<ArrayList<String>> issueList = new ArrayList<ArrayList<String>>();
        InputStreamReader is = new InputStreamReader(context.getAssets()
                .open("issues.csv"));
        BufferedReader reader = new BufferedReader(is);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] stringList = line.split(",");
            for (int i=0; i<stringList.length; i++){
                stringList[i] = stringList[i].replace("\"", "");
            }
            ArrayList<String> issueFields = new ArrayList<String>(Arrays.asList(stringList));
            issueList.add(issueFields);
        }
        return issueList;
    }


}
