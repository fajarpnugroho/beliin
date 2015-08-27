package in.beli.beliin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EntranceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new EntranceFragment()).commit();
        }
    }
}
