package sekth.droid.maestrodetalle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import sekth.droid.maestrodetalle.fragments.ContentFragment;
import sekth.droid.maestrodetalle.fragments.TitleFragment;

public class MainActivity extends FragmentActivity implements
		TitleFragment.onTituloSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Comprobamos si estamos usando la version con
		// con el FrameLayout
		if (findViewById(R.id.fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}
			
			// Establecemos el ListFragment en el caso de que sea la version
			// de un panel (SmartPhone)
			TitleFragment fragment = new TitleFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, null).commit();
		}
	}

	@Override
	public void onTituloSelected(int position) {

		// Comprobamos si tenemos disponible el Fragment de
		// contenido
		ContentFragment contFragment = (ContentFragment) getSupportFragmentManager().findFragmentById(R.id.contenidoFragment);

		if (contFragment != null) {
			// Si está disponible, estamos en la versión de 2 paneles
			contFragment.updateContentByPosition(position);
		} else {
			// Si no está disponible, estamos en el layout
			// del FrameLayout, y tenemos que cambiar los Fragment
			contFragment = new ContentFragment();
			Bundle args = new Bundle();
			
			// Establecemos la posición que hemos elegido
			args.putInt(ContentFragment.POSICION, position);
			contFragment.setArguments(args);
			
			// Reemplazamos el Fragment que había por el nuevo
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, contFragment)
					.addToBackStack(null).commit();
		}
	}

}
