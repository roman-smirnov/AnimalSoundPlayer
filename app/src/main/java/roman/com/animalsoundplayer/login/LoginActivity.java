package roman.com.animalsoundplayer.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import roman.com.animalsoundplayer.R;
import roman.com.animalsoundplayer.soundlist.SoundListActivity;


/**
 * A login screen that offers login via a password
 * this is the laucher activity
 */
public class LoginActivity extends AppCompatActivity {
    //the login button
    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginButton = (Button) findViewById(R.id.button_login);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to the main activity
                goToSoundListActivity();
            }
        });

    }

    /**
     * go to the SoundList activity
     */
    private void goToSoundListActivity() {
        //launch the main activity
        Intent intent = new Intent(this, SoundListActivity.class);
        startActivity(intent);
    }
}

