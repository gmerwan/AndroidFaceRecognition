package dz.esi.facereco.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreference {
    private static final String MAIN_CONFIG = "application_settings";
    private static final String LAST_PERSON = "last_person";

    public static void setLastPersone(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences
                (MAIN_CONFIG, Context.MODE_PRIVATE).edit();
        editor.putString(LAST_PERSON, name);
        editor.apply();
    }

    public static String getLastPerson(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences
                (MAIN_CONFIG, Context.MODE_PRIVATE);
        return sharedPreferences.getString(LAST_PERSON, "Personne inconnue");
    }
}
