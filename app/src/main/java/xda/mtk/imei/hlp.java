package xda.mtk.imei;

import android.app.*;
import android.os.*;

public class hlp extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
