package ru.timuruktus.trelico.MainPart;

import android.content.Context;


import io.realm.Realm;
import ru.timuruktus.trelico.Model.DataManager;
import ru.timuruktus.trelico.R;
import ru.timuruktus.trelico.ShopsShowcase.ShopsFragment;
import ru.timuruktus.trelico.Utils.FragmentChanger;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainPresenter implements IMainPresenter {

    private IMainActivity mainActivity;
    private Context context;

    public MainPresenter(IMainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity.getContext();
        Realm.init(context);
        FragmentChanger.initFragmentChanger(mainActivity);
        loadFirstFragment();
    }

    @Override
    public void onCreate() {
    }


    private void loadFirstFragment(){
        FragmentChanger.getInstance()
                .needAddToBackStack(false)
                .setFragment(ShopsFragment.getInstance())
                .changeFragment();
    }


}
