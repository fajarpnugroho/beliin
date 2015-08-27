package in.beli.beliin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import in.beli.beliin.ui.EntranceView;
import in.beli.beliin.ui.fragment.EntranceFragment;

public class EntranceActivity extends BaseActivity implements EntranceView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new EntranceFragment()).commit();
        }

        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainActivity();
            }
        }, 1000);
    }

    @Override
    public void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
