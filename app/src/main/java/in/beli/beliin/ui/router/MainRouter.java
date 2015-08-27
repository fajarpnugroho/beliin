package in.beli.beliin.ui.router;

import android.app.Activity;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.beli.beliin.ui.activity.SearchActivity;

@Singleton
public class MainRouter {
    private Activity activity;

    @Inject public MainRouter() {}

    public void setActivity(Activity activity) { this.activity = activity; }

    public void navigateToSearchActivity() {
        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivityForResult(intent, 1000);
    }
}
