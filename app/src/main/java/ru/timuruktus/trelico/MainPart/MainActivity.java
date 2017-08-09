package ru.timuruktus.trelico.MainPart;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import ru.timuruktus.trelico.R;
import ru.timuruktus.trelico.Utils.FragmentChanger;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    public static final String DEFAULT_TAG = "defaultTag";
    public static final String TESTING_TAG = "testingTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        IMainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
