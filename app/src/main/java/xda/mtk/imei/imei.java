package xda.mtk.imei;

import android.content.*;
import android.os.*;
import android.widget.*;
import java.util.*;
public class imei
{

	static String generateIMEI() {
		String str = generateRandomStr();
		return str + getStr(str);
	}

	static String generateRandomStr() {
        Random random = new Random();
        return "35826501" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

	static int getNum(int i) {
        if (i < 10)
            return i;
        String str = String.valueOf(i);
        return getNum2(String.valueOf(str.charAt(1))) + getNum2(String.valueOf(str.charAt(0)));
    }

	static String getStr(String str) {
        int i = 0;
        int length = str.length() - 2;
        while (true) {
            if (length <= 0 && length != 0)
                break;
            i += getNum2(String.valueOf(str.charAt(length)));
            length -= 2;
        }
        length = str.length() - 1;
        while (true) {
            if (length > 0 || length == 0) {
                i += getNum(getNum2(String.valueOf(str.charAt(length))) * 2);
                length -= 2;
            } else {
                String str2 = String.valueOf((i * 9));
                return String.valueOf(str2.charAt(str2.length() - 1));
            }
        }
    }

	static int getNum2(String str) {
        int i = 0;
        String str2 = "0";
        while (!str2.equals(str)) {
            i++;
            str2 = String.valueOf(i);
        }
        return i;
    }


	// copy to clipboard
	static void copyToClip(Context context, String str) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			final ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			final ClipData clipData = ClipData.newPlainText("MTK IMEI: ", str);
			clipboardManager.setPrimaryClip(clipData);
			Toast.makeText(context, "copy: " + str, Toast.LENGTH_SHORT).show();
		} else {
			final ClipboardManager clipboardManager =(ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			clipboardManager.setText(str);
			Toast.makeText(context, "copy: " + str, Toast.LENGTH_SHORT).show();
		}
	}

	// open engineer mode
	static void openEngMode(Context context) {
		try {
			Intent in = new Intent("android.intent.action.MAIN");
			in.setClassName("com.mediatek.engineermode", "com.mediatek.engineermode.EngineerMode");
			context.startActivity(in);
		} catch (Exception e) {
			Toast.makeText(context, "Cannot find Mediatek EngineerMode App", 1).show();
		}

	}
}
