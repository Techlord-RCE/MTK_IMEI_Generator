package xda.mtk.imei;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;


public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	public void onBtn(View v) {

		EditText ed;
		ed = findViewById(R.id.editText);

		switch (v.getId()) {
			case R.id.button:
				ed.setText(imei.generateIMEI());
				break;

			case R.id.button2:
				if (ed.getText().length() > 0)
					imei.copyToClip(this, ed.getText().toString());
				break;

			case R.id.button3:
			    imei.openEngMode(this);
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater Inflater = getMenuInflater();
		Inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
			case R.id.item:
				startActivity(new Intent(this, hlp.class));
				break;

			case R.id.item2:
				finish();
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onBackPressed() {
		finish();
	}

}
