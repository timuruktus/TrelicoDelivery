package ru.timuruktus.trelico.MainPart;

public class MainPresenter implements IMainPresenter {

    private IMainActivity mainActivity;

    public MainPresenter(IMainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate() {

    }

    private void setFonts(){

    }

}
