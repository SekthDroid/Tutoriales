package sekth.droid.Services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static String[] FILES = new String[]{
            "http://www.google.com/imagen1",
            "http://www.google.com/imagen2",
            "http://www.google.com/imagen3",
            "http://www.google.com/imagen4"};

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new DoBackgroundTask().execute(FILES);
        return START_STICKY;
    }

    private int downloadFromUrl(String url) {
        try {
            // Simulamos la descarga de un fichero
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // Retornamos un numero que puede ser el tama�o del archivo
        return 100;
    }

    private class DoBackgroundTask extends AsyncTask<String, Integer, Long> {

        @Override
        protected Long doInBackground(String... urls) {

            int count = urls.length;
            long totalKBytesDownloaded = 0;
            for (int i = 0; i < count; i++) {
                totalKBytesDownloaded += downloadFromUrl(urls[i]);
                // Calculamos el porcentaje bajado y actualizamos el progreso
                publishProgress((int) (((i + 1) / (float) count) * 100));
            }
            return totalKBytesDownloaded;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("Descargando Ficheros", String.valueOf(values[0])
                    + "% descargado");
            Toast.makeText(getApplicationContext(), values[0] + "% descargado",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);
            Toast.makeText(getApplicationContext(), "Descargados " + result + " Kbytes", Toast.LENGTH_SHORT).show();
            stopSelf();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Servicio Detenido", Toast.LENGTH_SHORT).show();
    }

}
