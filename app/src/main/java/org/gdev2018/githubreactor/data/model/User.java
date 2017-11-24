package org.gdev2018.githubreactor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 *   Updated by gdev2018 on 2017-11-22
 */
public class User implements Parcelable {
    // implements interface
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        // returns User from Parcel
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        // returns new User Array of arg-size items
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String login;
    public long id;
    public String url;
    public String email;

    public User() {
    }

    // creates User from Parcel
    protected User(Parcel in) {
        this.login = in.readString();
        this.id = in.readLong();
        this.url = in.readString();
        this.email = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.email);
    }
}
