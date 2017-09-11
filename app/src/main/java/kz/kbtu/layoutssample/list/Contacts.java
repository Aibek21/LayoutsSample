package kz.kbtu.layoutssample.list;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aibekkuralbaev on 11.09.17.
 */

public class Contacts implements Parcelable{

    String name;
    String phone;


    public Contacts(){

    }

    protected Contacts(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contacts> CREATOR = new Creator<Contacts>() {
        @Override
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        @Override
        public Contacts[] newArray(int size) {
            return new Contacts[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }
}
