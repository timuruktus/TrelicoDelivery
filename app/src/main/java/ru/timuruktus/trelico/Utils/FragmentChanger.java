package ru.timuruktus.trelico.Utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.io.Serializable;

import ru.timuruktus.trelico.MainPart.IMainActivity;
import ru.timuruktus.trelico.R;

import static android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

public class FragmentChanger implements IFragmentChanger{

    private static IMainActivity mainActivity;
    private boolean addToBackStack;
    private Fragment fragment;
    public static final String ARG_INFO = "Info";

    public static void initFragmentChanger(IMainActivity mainActivity){
        FragmentChanger.mainActivity = mainActivity;
    }

    /**
     * Call it before any of other methods except initialisation.
     */
    public static FragmentChanger getInstance(){
        return new FragmentChanger();
    }

    /**
     * Set the fragment, that needed to be change. REQUIRED method.
     * @param fragment - Fragment, that needed to be change.
     * @return - instance of this class.
     */
    @Override
    public FragmentChanger setFragment(Fragment fragment){
        this.fragment = fragment;
        return this;
    }

    /**
     * Sets that current fragment will be added to backStack.
     * @param addToBackStack - should add to backStack.
     * @return - instance of this class.
     */
    @Override
    public FragmentChanger needAddToBackStack(boolean addToBackStack){
        this.addToBackStack = addToBackStack;
        return this;
    }

    /**
     * Should be executed last. Changes fragment.
     */
    @Override
    public void changeFragment(){
        FragmentManager fragmentManager = mainActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().toString());
        }
        fragmentTransaction.setTransition(TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }



}
