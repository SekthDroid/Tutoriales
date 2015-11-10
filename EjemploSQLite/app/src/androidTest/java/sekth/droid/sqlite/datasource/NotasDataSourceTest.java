package sekth.droid.sqlite.datasource;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import sekth.droid.sqlite.model.Note;

/**
 * Created by SekthDroid on 10/11/15.
 */
public class NotasDataSourceTest extends AndroidTestCase {
    private static final String TAG = NotasDataSourceTest.class.getSimpleName();
    private RenamingDelegatingContext isolatedContext;
    private NotasDataSource notasDataSource;

    public void setUp() throws Exception {
        this.isolatedContext = new RenamingDelegatingContext(getContext().getApplicationContext(), "_test");
        this.notasDataSource = new NotasDataSource(isolatedContext);
        this.notasDataSource.open();
    }

    public void testDataSourceShouldAddNotes() throws Exception {
        notasDataSource.crearNota("Hola");
        assertEquals(1, notasDataSource.getAll().size());
        assertEquals(notasDataSource.getAll().get(0).getContent(), "Hola");

        notasDataSource.crearNota("Mundo");
        assertEquals(2, notasDataSource.getAll().size());
        assertEquals(notasDataSource.getAll().get(1).getContent(), "Mundo");
    }

    public void testDataSourceShouldDeleteNote() throws Exception {
        notasDataSource.crearNota("Note to delete");

        Note created = notasDataSource.getAll().get(0);

        notasDataSource.removeNote(created);

        assertEquals(0, notasDataSource.getAll().size());
    }

    public void tearDown() throws Exception {
        notasDataSource.close();
        isolatedContext.deleteDatabase("Notas");
    }
}