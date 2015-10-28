package sekth.droid.sqlite.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sekth.droid.sqlite.R;
import sekth.droid.sqlite.datasource.NotasDataSource;

public class CreateNoteActivity extends Activity implements View.OnClickListener {
    public static int resultCode = 10;

    private EditText txtNota;
    private NotasDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_nota);

        dataSource = new NotasDataSource(this);
        dataSource.open();

        txtNota = (EditText) findViewById(R.id.et_note_content);
        findViewById(R.id.btn_add).setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            addNote();
        }
    }

    private void addNote() {
        String textoNota = txtNota.getText().toString();

        if (textoNota.length() != 0) {
            dataSource.crearNota(textoNota);
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "No ha introducido texto", Toast.LENGTH_SHORT).show();
        }
    }
}
