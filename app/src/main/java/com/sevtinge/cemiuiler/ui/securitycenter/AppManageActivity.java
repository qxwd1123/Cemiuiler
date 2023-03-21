package com.sevtinge.cemiuiler.ui.securitycenter;

import androidx.fragment.app.Fragment;

import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.ui.base.BaseAppCompatActivity;
import com.sevtinge.cemiuiler.ui.base.SubFragment;

public class AppManageActivity extends BaseAppCompatActivity {

    @Override
    public Fragment initFragment() {
        return new AppManageFragment();
    }

    public static class AppManageFragment extends SubFragment {

        @Override
        public int getContentResId() {
            return R.xml.security_center_app_manage;
        }
    }
}
