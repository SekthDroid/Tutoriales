package sekth.droid.CheckBox.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import sekth.droid.CheckBox.R;
import sekth.droid.CheckBox.adapter.MyCustomAdapter;
import sekth.droid.CheckBox.model.DataSource;
import sekth.droid.CheckBox.model.Item;

public class MainActivity extends ListActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MyCustomAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListAdapter = new MyCustomAdapter(this, DataSource.getStubData(100));

        findViewById(R.id.btn_check_data).setOnClickListener(this);

        setListAdapter(mListAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ((MyCustomAdapter) l.getAdapter()).checkItem(position);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_check_data) {
            printSelectedItems();
        }
    }

    private void printSelectedItems() {
        List<Item> checkedItems = ((MyCustomAdapter) getListView().getAdapter()).getAllChecked();
        Toast.makeText(this, "Seleccionados " + checkedItems.size() + " items", Toast.LENGTH_SHORT).show();
        for (Item checkedItem : checkedItems) {
            Log.d(TAG, checkedItem.toString());
        }
    }
}
