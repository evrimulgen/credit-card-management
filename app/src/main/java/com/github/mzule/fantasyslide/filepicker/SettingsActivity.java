package com.github.mzule.fantasyslide.filepicker;

/**
 * Created by scheng on 3/11/17.
 */

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.github.angads25.filepicker.view.FilePickerPreference;
import com.github.mzule.fantasyslide.app.R;

/**
 * <p>
 * Created by Angad on 22/07/2016.
 * </p>
 */

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        FilePickerPreference fileDialog = (FilePickerPreference) findPreference("directories");
        fileDialog.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        if (preference.getKey().equals("directories")) {
            String value = (String) o;
            String arr[] = value.split(":");
            for (String path : arr)
                Toast.makeText(SettingsActivity.this, path, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}