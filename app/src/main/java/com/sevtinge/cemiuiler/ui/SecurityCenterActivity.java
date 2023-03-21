package com.sevtinge.cemiuiler.ui;

import android.Manifest;
import android.os.Bundle;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.ui.base.BaseAppCompatActivity;
import com.sevtinge.cemiuiler.ui.base.SubFragment;
import com.sevtinge.cemiuiler.utils.SdkHelper;

import moralnorm.preference.Preference;
import moralnorm.preference.SwitchPreference;

public class SecurityCenterActivity extends BaseAppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Fragment initFragment() {
        return new SecurityCenterFragment();
    }

    public static class SecurityCenterFragment extends SubFragment {

        Preference mPowerSetting;

        Preference mNewboxBackgroundCustom;

        @Override
        public int getContentResId() {
            return R.xml.security_center;
        }

        @Override
        public void initPrefs() {
            mPowerSetting = findPreference("prefs_key_powerkeeper");

            mNewboxBackgroundCustom = findPreference("prefs_key_security_center_newbox_bg_custom");

            mPowerSetting.setVisible(SdkHelper.isAndroidTiramisu());

        }

        @Override
        public boolean onPreferenceTreeClick(Preference preference) {
            if (preference == mNewboxBackgroundCustom) {
                openMultiAction(preference, null, PickerHomeActivity.Actions.Blur);
            }
            return super.onPreferenceTreeClick(preference);
        }
    }
}
