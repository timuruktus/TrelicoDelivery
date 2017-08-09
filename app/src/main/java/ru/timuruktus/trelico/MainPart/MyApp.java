package ru.timuruktus.trelico.MainPart;

import android.app.Application;

import ru.timuruktus.trelico.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
