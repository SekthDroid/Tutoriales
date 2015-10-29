package sekth.droid.maestrodetalle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sekth.droid.maestrodetalle.model.Contenido;

public class TitleFragment extends ListFragment {

	private onTituloSelectedListener mCallback;

	// Interface que la Activity contenedora debe implementar
	// para poder tener comunicación
	public interface onTituloSelectedListener {
		void onTituloSelected(int position);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Establecemos el Adapter cuando se crea el Fragment
		setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, Contenido.titulos));
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Inicializamos nuestra variable de referencia del tipo
		// onTituloSelectedListener junto con el valor del objeto
		// activity que debe ser una Activity que implemente esta interface
		try {
			mCallback = (onTituloSelectedListener) activity;
		} catch (ClassCastException e) {
			Log.d("ClassCastException", "La Activity debe implementar esta Interface");
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		// Llamamos al método que implementa la Activity pasandole
		// la posicion del elemento que hemos pulsado
		mCallback.onTituloSelected(position);
	}

}
