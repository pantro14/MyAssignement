package com.rabobank.davidpardo.myassignement.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rabobank.davidpardo.myassignement.R;
import com.rabobank.davidpardo.myassignement.presenter.IssueListAdapter;
import com.rabobank.davidpardo.myassignement.presenter.IssueViewInterface;
import com.rabobank.davidpardo.myassignement.presenter.MediatorIssue;
import com.rabobank.davidpardo.myassignement.presenter.UpdateIssuesAsyncTask;

import java.util.ArrayList;

public class AssignementActivity extends AppCompatActivity implements IssueViewInterface{
    private ListView listViewIssue;
    MediatorIssue mediatorIssue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignement);
        listViewIssue = (ListView) findViewById(R.id.issue_list_view);
        //issueList = new ArrayList<ArrayList<String>>();
        mediatorIssue = new MediatorIssue(AssignementActivity.this);
        mediatorIssue.updateIsueeList();
    }

    @Override
    public void updateListView(ArrayList<ArrayList<String>> issueList) {
        IssueListAdapter issueListAdapter = new IssueListAdapter(AssignementActivity.this,
                android.R.layout.simple_spinner_item, issueList);
        listViewIssue.setAdapter(issueListAdapter);
    }

    @Override
    public View updateCustomItemListView(int position, ArrayList<ArrayList<String>> issueList, View view) {
        ViewHolder holder = new ViewHolder();

        if(view==null){
            HorizontalScrollView hr = new HorizontalScrollView(this);
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            for(int i=0; i<issueList.get(position).size(); i++){
                holder.valueField = new TextView(this);
                holder.valueField.setText(issueList.get(position).get(i));
                holder.valueField.setTypeface(Typeface.DEFAULT_BOLD);
                holder.valueField.setTextSize(20f);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                holder.valueField.measure(0,0);
                int viewWidth = holder.valueField.getMeasuredWidth();
                if(position==0){
                    holder.valueField.setTextColor(Color.parseColor("#FF0000"));
                    params.setMargins(0, 0, 80, 0);
                    holder.valueField.setLayoutParams(params);
                }else{
                    if(viewWidth>0 && viewWidth<20){
                        params.setMargins(0, 0, 160, 0);
                    }else if(viewWidth>20 && viewWidth<100){
                        params.setMargins(0, 0, 130, 0);
                    }else if(viewWidth>100 && viewWidth<140){
                        params.setMargins(0, 0, 80, 0);
                    }else if(viewWidth>140){
                    params.setMargins(0, 0, 20, 0);
                }
                    holder.valueField.setLayoutParams(params);
                }
                layout.addView(holder.valueField);
            }
            hr.addView(layout);
            view = hr;
            view.setTag(holder);
        }

        holder = (ViewHolder) view.getTag();
        return view;
    }

    static class ViewHolder {
        TextView valueField;
        HorizontalScrollView hr;
    }
}
