package sekth.droid.Services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
	private static final String TAG = MyService.class.getSimpleName();
	private static final String[] FILES = new String[]{
			"http://www.google.com/imagen1.png",
			"http://www.google.com/imagen2.png",
			"http://www.google.com/imagen3.png",
			"http://www.google.com/imagen4.png"};

	int counter = 0;
	static final int UPDATE_INTERVAL = 1000;
	private Timer timer;

	@Override
	public void onCreate() {
		super.onCreate();
		this.timer = new Timer();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Queremos que este servicio se ejecute continuamente
		// hasta que sea detenido manualmente, por lo que retornaremos
		// START_STICKY

		doSomethingRepeatedly();

		new DoBackgroundTask().execute(FILES);

		return START_STICKY;
	}
	
	private void doSomethingRepeatedly(){
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				Log.d(TAG, String.valueOf(++counter));
			}
			
		},0, UPDATE_INTERVAL);
	}

	private int downloadFileFrom(String url) {
		try {
			// Simulamos la descarga de un fichero
			Thread.sleep(2500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		return 100;
	}

	private class DoBackgroundTask extends AsyncTask<String, Integer, Long> {

		@Override
		protected Long doInBackground(String... urls) {
			int count = urls.length;
			long totalKBytesDownloaded = 0;
			for (int i = 0; i < count; i++) {
				totalKBytesDownloaded += downloadFileFrom(urls[0]);
				// --Calculamos el porcentaje descargado y
				// --reportamos el progreso
				publishProgress((int) (((i + 1) / (float) count) * 100));
			}
			return totalKBytesDownloaded;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Log.d(TAG, String.valueOf(values[0]) + "% descargado");
			Toast.makeText(getApplicationContext(), values[0] + "% descargado", Toast.LENGTH_SHORT).show();
		}

		@Override
		protected void onPostExecute(Long result) {
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), "Descargado " + result + " KBytes", Toast.LENGTH_SHORT).show();
			stopSelf();
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (timer != null){
			timer.cancel();
		}
		Toast.makeText(getApplicationContext(), "Servicio Detenido", Toast.LENGTH_SHORT).show();
	}

}
