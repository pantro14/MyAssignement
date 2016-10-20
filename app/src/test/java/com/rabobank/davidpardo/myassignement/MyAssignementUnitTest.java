package com.rabobank.davidpardo.myassignement;



import android.test.InstrumentationTestCase;
import org.junit.Before;
import org.junit.Test;
import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import android.test.mock.MockContext;


public class MyAssignementUnitTest extends InstrumentationTestCase{

    Context context;

    public void setUp() throws Exception {
        super.setUp();
        context = new MockContext();
        assertNotNull(context);

    }

   @Test
    public void testCsvParser_isCorrect() throws Exception {
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
       assertNotNull(issueList);
       assertEquals(issueList.size(), 3);
    }

}