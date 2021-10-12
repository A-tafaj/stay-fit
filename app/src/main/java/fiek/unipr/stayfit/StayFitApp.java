package fiek.unipr.stayfit;

import android.app.Application;


public class StayFitApp extends Application {
    static StayFitApp instance;
//
//        public StayFitApp() {
//        instance = new StayFitApp();
//    }

    public void onCreate() {
        super.onCreate();
        instance = this;

    }


/*    public static StayFitApp getInstance(){
        return instance = new StayFitApp();
    }*/
}

