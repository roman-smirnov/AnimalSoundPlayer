package roman.com.animalsoundplayer;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import roman.com.animalsoundplayer.dataobjects.AnimalSound;

/**
 * this activity is a screen with a play button that allows the user to play and animal sound
 */
public class SoundPlayerActivity extends AppCompatActivity {

    //the button the user has to press to play the sound
    private ImageButton mPlayButton;
    // shows the user the filename being played
    private TextView mSoundTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_player);

        //get the animasound object from the intent
        Intent intent = getIntent();
        final AnimalSound animalSound = intent.getParcelableExtra(AnimalSound.KEY_ANIMAL_SOUND);

        //set the filename text
        mSoundTitle = (TextView) findViewById(R.id.textview_sound_asset_title);
        mSoundTitle.setText(animalSound.getTitle());

        mPlayButton = (ImageButton) findViewById(R.id.imagebutton_play_sound);

        //click listener for when the user presses the play button
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //a file descriptor is used to read the sound file
                    AssetFileDescriptor assetFileDescriptor = getAssets().openFd(animalSound.getTitle());
                    MediaPlayer player = new MediaPlayer();
                    //assets is not exactly a file as we know it, so need to set the start and length points in the assets
                    player.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(),assetFileDescriptor.getLength());
                    player.prepare();
                    //play the sound
                    player.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }


}
