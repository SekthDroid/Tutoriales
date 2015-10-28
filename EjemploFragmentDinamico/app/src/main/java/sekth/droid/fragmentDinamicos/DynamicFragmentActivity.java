package sekth.droid.fragmentDinamicos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class DynamicFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dinamyc_fragments);

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		WindowManager wm = getWindowManager();
		Display d = wm.getDefaultDisplay();
		
		if (d.getRotation() == Surface.ROTATION_90){
			GreenFragment greenFragment = new GreenFragment();
			fragmentTransaction.replace(android.R.id.content, greenFragment).commit();
		}else {
			YellowFragment yellowFragment = new YellowFragment();
			fragmentTransaction.replace(android.R.id.content, yellowFragment).commit();
		}
	}
}
