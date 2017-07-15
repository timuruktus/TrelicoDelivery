package ru.timuruktus.trelico.MainPart;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.timuruktus.trelico.R;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreate();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
