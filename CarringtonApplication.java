package seawright.carringtondemo;

import android.app.Application;

import seawright.carringtondemo.Util.UtilLog;


public class CarringtonApplication extends Application
{
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
