package sekth.droid.viewpager.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import sekth.droid.viewpager.R;
import sekth.droid.viewpager.adapter.MyPagerAdapter;
import sekth.droid.viewpager.fragments.SimpleFragment;
import sekth.droid.viewpager.fragments.ItemsListFragment;

public class ViewPagerActivity extends FragmentActivity {

	MyPagerAdapter mPagerAdapter;
	ViewPager mviewPager;
	private List<Fragment> listaFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);

		// Creamos una lista de Fragments
		listaFragments = new ArrayList<Fragment>();
		listaFragments.add(new ItemsListFragment());
		listaFragments.add(new SimpleFragment());
		listaFragments.add(new ItemsListFragment());
		listaFragments.add(new SimpleFragment());
		listaFragments.add(new ItemsListFragment());

		// Creamos nuestro Adapter
		mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), listaFragments);

		// Instanciamos nuestro ViewPager
		mviewPager = (ViewPager) findViewById(R.id.viewPager);

		// Establecemos el Adapter
		mviewPager.setAdapter(mPagerAdapter);
	}
}
