package app.kudzy;

import app.kudzy.service.ResistanceCalServiceImpl;

public class Main {
    public static void main(String[] args) {

        ResistanceCalServiceImpl rcsi= new ResistanceCalServiceImpl();
        rcsi.mainServiceRunner();
    }
}