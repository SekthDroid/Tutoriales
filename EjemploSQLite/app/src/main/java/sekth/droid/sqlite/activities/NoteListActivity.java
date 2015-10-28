package sekth.droid.sqlite.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import sekth.droid.sqlite.R;
import sekth.droid.sqlite.datasource.NotasDataSource;
import sekth.droid.sqlite.model.Note;

public class NoteListActivity extends Activity implements OnItemClickListener, View.OnClickListener {
    private int requestCode = 1;
    private ListView mNotesListView;
    private List<Note> mNotes;
    private NotasDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        // Instanciamos NotasDataSource para
        // poder realizar acciones con la base de datos
        initializeDataSource();

        this.mNotes = dataSource.getAll();

        // Instanciamos los elementos
        findViewById(R.id.btn_add).setOnClickListener(this);
        initializeListView();
    }

    private void initializeDataSource() {
        dataSource = new NotasDataSource(this);
        dataSource.open();
    }

    private void initializeListView() {
        mNotesListView = (ListView) findViewById(R.id.lv_notes);
        mNotesListView.setEmptyView(findViewById(R.id.tv_empty_notes));

        // Cargamos la lista de notas disponibles
        ArrayAdapter<Note> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mNotes);

        // Establecemos el adapter
        mNotesListView.setAdapter(adapter);

        // Establecemos un Listener para el evento de pulsación
        mNotesListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(final AdapterView<?> adapterView, View view, final int position, long id) {
        AlertDialog dialog = createAlertDialogForNote(position);
        dialog.show();
    }

    private AlertDialog createAlertDialogForNote(final int position) {
        return new AlertDialog.Builder(this)
                .setTitle(R.string.delete_note)
                .setMessage(R.string.do_you_want_to_delete)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        removeNoteInPosition(position);
                    }
                })

                .setNegativeButton(android.R.string.cancel, onRemoveCancel).create();
    }

    private void removeNoteInPosition(int position) {
        Note note = mNotes.get(position);
        dataSource.removeNote(note);
        mNotes.remove(position);
        // Refrescamos la lista
        refresh();
    }

    private DialogInterface.OnClickListener onRemoveCancel = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Result", "Se ejecuta onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.requestCode && resultCode == RESULT_OK) {
            // Actualizar el Adapter
            dataSource.open();
            this.mNotes.clear();
            this.mNotes.addAll(dataSource.getAll());
            refresh();
        }
    }

    private void refresh() {
        ArrayAdapter adapter = (ArrayAdapter) this.mNotesListView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add){
            goToAddNote();
        }
    }

    private void goToAddNote() {
        Intent i = new Intent(this, CreateNoteActivity.class);
        startActivityForResult(i, requestCode);
    }
}
