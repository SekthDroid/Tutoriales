package sekth.droid.viewpager.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import sekth.droid.viewpager.R;
import sekth.droid.viewpager.model.Content;

public class ItemsListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Según el resultado, lo cargaremos con datos diferentes
        int tipoLista = (int) (Math.random() * 3);
        String data[];
        switch (tipoLista) {
            case 0:
                data = Content.smartphoneSO;
                break;
            case 1:
                data = Content.computerSO;
                break;
            case 2:
            default:
                data = Content.androidVersion;
        }

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));

    }
}
