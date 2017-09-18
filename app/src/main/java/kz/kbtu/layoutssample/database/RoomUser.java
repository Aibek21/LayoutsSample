package kz.kbtu.layoutssample.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by aibekkuralbaev on 18.09.17.
 */

@Entity(tableName = "users")
public class RoomUser {

    @PrimaryKey
    @ColumnInfo(name = "userid")
    private String mId;


    @ColumnInfo(name = "name")
    String name;


    @ColumnInfo(name = "age")
    int age;


    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
