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
    private Serializable info;
    private Fragment fragment;
    public static final String ARG_INFO = "Info";

    public static void initFragmentChanger(IMainActivity mainActivity){
        FragmentChanger.mainActivity = mainActivity;
    }

    /**
     * Call it before any of other methods except initialisation.
     * @throws MainActivityDidNotInit - throws if mainActivity didn't init.
     */
    public static FragmentChanger getInstance() throws MainActivityDidNotInit {
        if(FragmentChanger.mainActivity == null){
            throw new MainActivityDidNotInit();
        }
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
     *  Puts some info and deliver it to new fragment.
     * @param info - some info, that should delivered to new fragment.
     * @return - instance of this class.
     */
    @Override
    public FragmentChanger putSomeInfo(Serializable info){
        this.info = info;
        return this;
    }

    /**
     * Should be executed last. Changes fragment.
     * @throws FragmentDidNotSet - Throws if we didn't set the fragment via "setFragment(Fragment()"
     */
    @Override
    public void changeFragment() throws FragmentDidNotSet{
        if(fragment == null){
            throw new FragmentDidNotSet();
        }
        FragmentManager fragmentManager = mainActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().toString());
        }
        if(info != null) {
            Bundle args = new Bundle();
            args.putSerializable(ARG_INFO, info);
            fragment.setArguments(args);
        }
        fragmentTransaction.setTransition(TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public static class MainActivityDidNotInit extends Throwable {}
    public static class FragmentDidNotSet extends Throwable {}


}
