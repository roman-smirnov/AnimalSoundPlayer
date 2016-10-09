package roman.com.animalsoundplayer.dataobjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roman on 10/9/16.
 */

public class AnimalSound implements Parcelable {

    public static final String KEY_ANIMAL_SOUND = "KEY_ANIMAL_SOUND";
    public static final Creator<AnimalSound> CREATOR = new Creator<AnimalSound>() {
        @Override
        public AnimalSound createFromParcel(Parcel source) {
            return new AnimalSound(source);
        }

        @Override
        public AnimalSound[] newArray(int size) {
            return new AnimalSound[size];
        }
    };
    private String mTitle;

    public AnimalSound(String title) {
        mTitle = title;
    }

    protected AnimalSound(Parcel in) {
        this.mTitle = in.readString();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
    }
}
