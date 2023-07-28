package org.example.tamemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.example.tamemon.fragments.PlayBattleFragment;
import org.example.tamemon.fragments.PlayHomeFragment;
import org.example.tamemon.fragments.PlayStatsFragment;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PlayHomeFragment();
            case 1:
                return new PlayBattleFragment();
            case 2:
                return new PlayStatsFragment();
            default:
                return new PlayHomeFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
