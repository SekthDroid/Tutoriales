package sekth.droid.sqlite.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sekth.droid.sqlite.datasource.MySQLiteOpenHelper.TablaNotas;
import sekth.droid.sqlite.model.Note;

public class NotasDataSource {
    private SQLiteDatabase db;
    private MySQLiteOpenHelper dbHelper;
    private String[] columnas = {TablaNotas.COLUMNA_ID, TablaNotas.COLUMNA_TEXTO};

    public NotasDataSource(Context context) {
        dbHelper = MySQLiteOpenHelper.getInstance(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void crearNota(String nota) {
        ContentValues values = new ContentValues();
        values.put(TablaNotas.COLUMNA_TEXTO, nota);
        db.insert(TablaNotas.TABLA_NOTAS, null, values);
    }

    public List<Note> getAll() {
        List<Note> listaNotes = new ArrayList<Note>();

        Cursor cursor = db.query(TablaNotas.TABLA_NOTAS, columnas, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Note nuevaNote = fetchNoteFrom(cursor);
            listaNotes.add(nuevaNote);
            cursor.moveToNext();
        }

        cursor.close();
        return listaNotes;
    }

    public void removeNote(Note note) {
        long id = note.getId();
        db.delete(TablaNotas.TABLA_NOTAS, TablaNotas.COLUMNA_ID + " = " + id, null);
    }

    private Note fetchNoteFrom(Cursor cursor) {
        Note note = new Note();
        note.setId(cursor.getLong(0));
        note.setTexto(cursor.getString(1));
        return note;
    }
}
