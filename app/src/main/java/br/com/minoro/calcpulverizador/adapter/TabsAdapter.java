package br.com.minoro.calcpulverizador.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.minoro.calcpulverizador.FormulaActivity;

public class TabsAdapter extends FragmentPagerAdapter {

    private static final int TABS_COUNT = 3;
    private static final String tabs[] = {"Formula", "Prática", "Instruções"};

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FormulaActivity formulaActivity = new FormulaActivity();
                return formulaActivity;
        }

        return null;
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }
}
