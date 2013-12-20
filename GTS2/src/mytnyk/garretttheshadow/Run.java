package mytnyk.garretttheshadow;

import mytnyk.gts.kernel.Terrain;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class Run extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_run);
		
		Terrain ter = new Terrain("road");
		Log.d("DEBUG", ter.getType());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.run, menu);
		return true;
	}

}
