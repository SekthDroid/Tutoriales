package sekth.droid.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class EjemploFragment extends FragmentActivity implements DialogSampleFragment.OnDialogSampleListener, OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_fragment);

		findViewById(R.id.btn_show).setOnClickListener(this);
	}

	@Override
	public void onPositiveClick() {
		Toast.makeText(this, "Ha pulsado OK", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNegativeClick() {
		Toast.makeText(this, "Ha pulsado Cancelar", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_show){
			showDialog();
		}
	}

	private void showDialog() {
		DialogSampleFragment dialogFragment = DialogSampleFragment.createDialog(getString(R.string.are_you_sure));
		dialogFragment.show(getSupportFragmentManager(), "dialog");
	}
}
