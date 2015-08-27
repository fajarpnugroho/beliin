package in.beli.beliin;

import android.app.Application;

public class BeliInApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initializeComponent(this);
    }

}
