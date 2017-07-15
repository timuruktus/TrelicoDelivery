package ru.timuruktus.trelico.MainPart;

public class MainModel implements IMainModel {

    IMainPresenter mainPresenter;


    public MainModel(IMainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }
}
