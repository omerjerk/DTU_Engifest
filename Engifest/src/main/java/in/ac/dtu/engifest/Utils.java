package in.ac.dtu.engifest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by omerjerk on 25/12/13.
 */
public class Utils {

    public static boolean isNetworkConnected(Context context) {

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni == null) {
                // There are no active networks.
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
