package com.rabobank.davidpardo.myassignement;

import com.rabobank.davidpardo.myassignement.model.Issue;
import android.test.InstrumentationTestCase;
import org.junit.Before;
import org.junit.Test;
import android.content.Context;
import java.io.BufferedReader;
import android.test.mock.MockContext;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends InstrumentationTestCase{

    Context context;

    public void setUp() throws Exception {
        super.setUp();
        context = new MockContext();
        assertNotNull(context);

    }

    @Test
    public void testCsvParser_isCorrect() throws Exception {
        ArrayList<Issue> issueListCSV = new ArrayList<Issue>();
        context = getInstrumentation().getContext();
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
        assertNotNull(issueListCSV);
        assertEquals(issueListCSV.size(), 3);
    }


}