package in.ac.dtu.engifest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
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

    public static String getEmail(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account account = getAccount(accountManager);

        if (account == null) {
            return null;
        } else {
            return account.name;
        }
    }

    private static Account getAccount(AccountManager accountManager) {
        Account[] accounts = accountManager.getAccountsByType("com.google");
        Account account;
        if (accounts.length > 0) {
            account = accounts[0];
        } else {
            account = null;
        }
        return account;
    }

    public static String[][] eventNamesDay = {
            {"bob", "dirt"},
            { "natya", "nukkad", "paridhan"},
            {"soundtrack", "spandan", "stfu"}
    };

    public static String[][] eventDesc = {
            {"fucking desc1", "fucking desc2"},
            {"fucking desc3", "fucking desc4", "fucking desc5"},
            {"fucking desc6", "fucking desc7", "fucking desc8"}
    };

    public static Drawable getEventDrawable (Context context, String eventName) {
        eventName = eventName.toLowerCase();
        int eventDrawableId = context.getResources().getIdentifier(eventName, "drawable", context.getPackageName());
        Drawable eventDrawable = context.getResources().getDrawable(eventDrawableId);
        return eventDrawable;
    }
}
