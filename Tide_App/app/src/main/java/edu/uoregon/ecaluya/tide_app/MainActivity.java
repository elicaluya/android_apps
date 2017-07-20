package edu.uoregon.ecaluya.tide_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    private TideItems tideItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileIO io = new FileIO(getApplicationContext());
        tideItems = io.readFile();

        ArrayList<HashMap<String, String>> data = new
                ArrayList<HashMap<String, String>>();

        for (TideItem item : tideItems){
            HashMap<String, String> map = new HashMap<String, String>();

            map.put("dateDay",item.getDate() + " " + item.getDay());
            map.put("hlTime", item.getHighlow() + " " + item.getTime());
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_items,
                new String[]{"dateDay", "hlTime"},
                new int[]{R.id.item_date_day, R.id.item_hl_time,});
        ListView itemsListView = (ListView)findViewById(R.id.itemsListView);
        itemsListView.setAdapter(adapter);
        itemsListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TideItem item = tideItems.get(position);
        Toast.makeText(this,item.getPred_in_ft() + " ft, " + item.getPred_in_cm() + " cm",Toast.LENGTH_LONG).show();
    }
}
