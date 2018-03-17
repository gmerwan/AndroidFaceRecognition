package dz.esi.facereco.log;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import dz.esi.facereco.outils.LogHelper;

import java.util.List;

public class GroupingLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dz.esi.facereco.R.layout.activity_grouping_log);

        LogAdapter logAdapter = new LogAdapter();
        ListView listView = (ListView) findViewById(dz.esi.facereco.R.id.log);
        listView.setAdapter(logAdapter);
    }

    // The adapter of the ListView which contains the grouping log.
    private class LogAdapter extends BaseAdapter {
        // The grouping log.
        List<String> log;

        LogAdapter() {
            log = LogHelper.getGroupingLog();
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public int getCount() {
            return log.size();
        }

        @Override
        public Object getItem(int position) {
            return log.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater layoutInflater =
                        (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(dz.esi.facereco.R.layout.item_log, parent, false);
            }
            convertView.setId(position);

            ((TextView)convertView.findViewById(dz.esi.facereco.R.id.log)).setText(log.get(position));

            return convertView;
        }
    }
}
