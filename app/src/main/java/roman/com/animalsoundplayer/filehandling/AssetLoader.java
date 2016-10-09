package roman.com.animalsoundplayer.filehandling;

import android.content.res.AssetManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import roman.com.animalsoundplayer.dataobjects.AnimalSound;

/**
 * Created by roman on 10/9/16.
 */
public class AssetLoader {

//This will go into the detail activity
//    AssetFileDescriptor afd = getAssets().openFd("AudioFile.mp3");
//    player = new MediaPlayer();
//    player.setDataSource(afd.getFileDescriptor());
//    player.prepare();
//    player.start();

    private static final String ROOT_DIR="";

    /**
     * the method will load all the .wav files from the assets folder into a list and return it
     * @param assetManager
     */
    public static List<AnimalSound> getAnimalSoundList(AssetManager assetManager) {

        List<AnimalSound> animalSoundList = new ArrayList<>();

        try {
            String[] list = assetManager.list(ROOT_DIR);
            for (String str : list) {
                AnimalSound tempAnimalSound = new AnimalSound(str);
                animalSoundList.add(tempAnimalSound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return animalSoundList;
    }
}
