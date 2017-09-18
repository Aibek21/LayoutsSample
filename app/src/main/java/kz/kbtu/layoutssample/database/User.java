package kz.kbtu.layoutssample.database;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 18.09.17.
 */

public class User {


    @SerializedName("user_name")
    String name;

    @SerializedName("user_age")
    int age;

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
