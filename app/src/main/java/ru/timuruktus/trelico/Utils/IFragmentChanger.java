package ru.timuruktus.trelico.Utils;

import android.app.Fragment;

import java.io.Serializable;

import ru.timuruktus.trelico.MainPart.IMainActivity;

public interface IFragmentChanger {

//    void initFragmentChanger(IMainActivity mainActivity);
    FragmentChanger setFragment(Fragment fragment);
    FragmentChanger needAddToBackStack(boolean addToBackStack);
    void changeFragment();
}
