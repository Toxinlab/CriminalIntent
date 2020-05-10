package acs.castac.ricsvil.criminalintent.crimelist;

import androidx.fragment.app.Fragment;

import acs.castac.ricsvil.criminalintent.R;
import acs.castac.ricsvil.criminalintent.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
}
