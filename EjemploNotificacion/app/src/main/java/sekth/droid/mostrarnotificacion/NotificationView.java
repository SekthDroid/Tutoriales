package sekth.droid.mostrarnotificacion;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// Cancelamos la Notificacion que hemos comenzado
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
	}
}
