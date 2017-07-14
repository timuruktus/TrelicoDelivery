package ru.timuruktus.trelico.Utils;

import android.app.Fragment;

import java.io.Serializable;

public interface IFragmentChanger {

    FragmentChanger setFragment(Fragment fragment);
    FragmentChanger needAddToBackStack(boolean addToBackStack);
    FragmentChanger putSomeInfo(Serializable info);
    void changeFragment() throws FragmentChanger.FragmentDidNotSet;
}
