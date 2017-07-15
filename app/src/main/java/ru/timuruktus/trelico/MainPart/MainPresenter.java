package ru.timuruktus.trelico.MainPart;

import android.content.Context;


import ru.timuruktus.trelico.R;
import ru.timuruktus.trelico.Utils.FragmentChanger;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainPresenter implements IMainPresenter {

    private IMainActivity mainActivity;
    private IMainModel mainModel;
    private Context context;

    public MainPresenter(IMainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity.getContext();
        this.mainModel = new MainModel(this);

        FragmentChanger.initFragmentChanger(mainActivity);
    }

    @Override
    public void onCreate() {
        setFonts();
    }

    private void setFonts(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
