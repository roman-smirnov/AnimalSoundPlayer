package roman.com.animalsoundplayer.soundlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import roman.com.animalsoundplayer.R;
import roman.com.animalsoundplayer.SoundPlayerActivity;
import roman.com.animalsoundplayer.dataobjects.AnimalSound;
import roman.com.animalsoundplayer.filehandling.AssetLoader;
import roman.com.animalsoundplayer.soundlist.recyclerview.AnimalSoundAdapter;
import roman.com.animalsoundplayer.soundlist.recyclerview.DividerItemDecoration;
import roman.com.animalsoundplayer.soundlist.recyclerview.RecyclerTouchListener;

/**
 * a screen that shows a list of all the animal sounds available
 */
public class SoundListActivity extends AppCompatActivity {

    //list of AnimalSound
    private List<AnimalSound> mAnimalSoundList;
    // adapter from AnimalSound to view
    private AnimalSoundAdapter mAnimalSoundAdapter;
    //recyclerview to display the sounds list
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_list);

        //load the AnimalSound list from the assetsManager
        mAnimalSoundList = AssetLoader.getAnimalSoundList(getAssets());

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAnimalSoundAdapter = new AnimalSoundAdapter(mAnimalSoundList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        add the seperator decoration between recyclerview list items
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAnimalSoundAdapter);

        //a click listener for when the user clicks on a list item
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //get the AnimalSound object and send it to the player activity
                AnimalSound tempAnimalSound = mAnimalSoundList.get(position);
                goToSoundPlayerActivity(tempAnimalSound);
            }

            @Override
            public void onLongClick(View view, int position) {
                //do nothing on a long click
            }
        }));
    }

    /**
     * launches the player activity, includes the animal sound as a parcel inside the intent
     * @param animalSound the animal sound to play
     */
    private void goToSoundPlayerActivity(AnimalSound animalSound) {
        //launch the player activity
        Intent intent = new Intent(this, SoundPlayerActivity.class);
        intent.putExtra(AnimalSound.KEY_ANIMAL_SOUND, animalSound);
        startActivity(intent);
    }
}
