package sekth.droid.lvPersonalizado;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos el ListView
        listView = (ListView) findViewById(R.id.listView);

        // Creamos un nuevo objeto de nuestra clase MyAdapter
        MyAdapter adapter = new MyAdapter(this, Data.generateItems(100));

        // Establecemos el Adapter en el listView
        listView.setAdapter(adapter);

        // Implementamos la Interface OnItemClickListener
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                // En este método hemos recibido el Adapter (arg0), la posicion (position)
                // y el ID de nuestro elemento, el cual nos proporciona el método getItemId()
                // que implementamos en la clase MyAdapter
                Toast.makeText(MainActivity.this, "ID del cliente: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
