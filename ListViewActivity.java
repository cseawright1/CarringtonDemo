package seawright.carringtondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import seawright.carringtondemo.Adapter.ListViewAdapter;
import seawright.carringtondemo.Adapter.ViewPagerAdapter;
import seawright.carringtondemo.fragment.ContentFragment;
import seawright.carringtondemo.fragment.HistoryFragment;
import seawright.carringtondemo.fragment.LoginFragment;
import seawright.carringtondemo.R;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ViewPager viewPager;
    private ArrayList<Fragment>fragmentList=new ArrayList<Fragment>();
    private  ArrayList<String>listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>() ;
        initialView();
        createFakeResult();
    }
    private void createFakeResult(){
        listResult.add("AAAAAAAAAA");
        listResult.add("BBBBB");
        listResult.add("CCC");
        listResult.add("D");
        listResult.add("E");
        listResult.add("F");
        listResult.add("GGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("j");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
    }
    private void initialView() {
        listView = (ListView) findViewById(R.id.List_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);

        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager_header);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"listView was clicked at position"+position , Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",  String.valueOf(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent();
        intent.putExtra("message","ListView");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}