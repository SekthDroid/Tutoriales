package sekth.droid.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener, GetContentAsyncTask.OnLoadFinishedListener {
	
	private ListView mItemsListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mItemsListView = (ListView)findViewById(R.id.listview);
		mItemsListView.setOnItemClickListener(this);
		
		GetContentAsyncTask getTask = new GetContentAsyncTask(this, this);
		getTask.execute();
	}

	@Override
	public void onFinish(String[] data) {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
		mItemsListView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(getApplicationContext(), "Ha pulsado el elemento " + position, Toast.LENGTH_SHORT).show();
	}

}
