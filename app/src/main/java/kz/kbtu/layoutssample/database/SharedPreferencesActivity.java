package kz.kbtu.layoutssample.database;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import kz.kbtu.layoutssample.R;

public class SharedPreferencesActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);


//        getString();


        User user = new User();
        user.setName("Name");
        user.setAge(20);

        Gson gson = new Gson();
        String userString = gson.toJson(user);
        Log.e("UserJson", userString);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("User", userString);
        editor.apply();

        String newUserString = sharedPreferences.getString("User", null);
        User user1 = gson.fromJson(newUserString, User.class);
        Log.e("User Name", user1.getName());

//        Log.e("User", user.toString());

    }


    public void getString(){
        String str = sharedPreferences.getString("string2", "Default");

        Log.e("String", str);

    }
}
