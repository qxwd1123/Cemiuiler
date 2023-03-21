package com.sevtinge.cemiuiler.ui;

import androidx.fragment.app.Fragment;

import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.ui.base.BaseAppCompatActivity;
import com.sevtinge.cemiuiler.ui.base.SubFragment;

public class XiaoAiAssistantActivity extends BaseAppCompatActivity {

    @Override
    public Fragment initFragment() {
        return new XiaoAiAssistantFragment();
    }

    public static class XiaoAiAssistantFragment extends SubFragment {

        @Override
        public int getContentResId() {
            return R.xml.xiaoai_assistant;
        }
    }
}
