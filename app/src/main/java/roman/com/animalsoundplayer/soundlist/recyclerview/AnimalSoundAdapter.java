package roman.com.animalsoundplayer.soundlist.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import roman.com.animalsoundplayer.dataobjects.AnimalSound;
import roman.com.animalsoundplayer.R;

public class AnimalSoundAdapter extends RecyclerView.Adapter<AnimalSoundAdapter.AnimalSoundHolder> {
    private List<AnimalSound> mAnimalSoundList;


    public class AnimalSoundHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;

        public AnimalSoundHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.note_title);
        }
    }

    public AnimalSoundAdapter(List<AnimalSound> animalSoundList) {
        mAnimalSoundList = animalSoundList;
    }

    @Override
    public AnimalSoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_sound_list_item_row, parent, false);
        return new AnimalSoundHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalSoundHolder holder, int position) {
        AnimalSound animalSound = mAnimalSoundList.get(position);
        holder.mTitle.setText(animalSound.getTitle());
    }

    @Override
    public int getItemCount() {
        return mAnimalSoundList.size();
    }
}
