package acs.castac.ricsvil.criminalintent.crimelist;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import acs.castac.ricsvil.criminalintent.Crime;
import acs.castac.ricsvil.criminalintent.CrimeFragment;
import acs.castac.ricsvil.criminalintent.CrimePagerActivity;
import acs.castac.ricsvil.criminalintent.R;
import acs.castac.ricsvil.criminalintent.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks,CrimeFragment.Callbacks{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if(findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this, crime.getmId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getmId());

            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container,newDetail).commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
