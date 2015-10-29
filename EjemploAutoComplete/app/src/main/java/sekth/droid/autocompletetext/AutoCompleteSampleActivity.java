package sekth.droid.autocompletetext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteSampleActivity extends Activity{

	// Array de String con los datos que usaremos para poder filtrar

	private String[] OS_NAMES = { "Android", "Windows Vista", "Windows 7",
			"Windows 8", "Ubuntu 12.04", "Ubuntu 12.10", "Mac OSX", "iOS 5",
			"iOS 6", "Solaris", "Kubuntu", "Suse" };

	private AutoCompleteTextView mAutocompleteView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_complete);

		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_dropdown_item_1line, OS_NAMES);

		this.mAutocompleteView = (AutoCompleteTextView) findViewById(R.id.actv_autocomplete);

		// Numero de caracteres necesarios para que se empiece
		// a mostrar la lista
		mAutocompleteView.setThreshold(3);

		// Se establece el Adapter
		mAutocompleteView.setAdapter(adapter);
	}
}
