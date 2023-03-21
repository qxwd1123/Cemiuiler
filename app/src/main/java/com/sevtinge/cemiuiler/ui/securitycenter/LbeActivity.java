package com.sevtinge.cemiuiler.ui.securitycenter;

import androidx.fragment.app.Fragment;
import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.ui.base.BaseAppCompatActivity;
import com.sevtinge.cemiuiler.ui.base.SubFragment;

public class LbeActivity extends BaseAppCompatActivity {

    @Override
    public Fragment initFragment() {
        return new LbeActivity.LbeFragment();
    }

    public static class LbeFragment extends SubFragment {

        @Override
        public int getContentResId() {
            return R.xml.lbe_security;
        }
    }


}
