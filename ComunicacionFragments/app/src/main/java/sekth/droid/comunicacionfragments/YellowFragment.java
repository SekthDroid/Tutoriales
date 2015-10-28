package sekth.droid.comunicacionfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class YellowFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_yellow, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View mReadButton = view.findViewById(R.id.btn_get_text);
        mReadButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_get_text) {
            fetchTextFromAnotherFragment();
        }
    }

    private void fetchTextFromAnotherFragment() {
        TextView lbl = (TextView) getActivity().findViewById(R.id.tv_text);
        Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();
    }
}
