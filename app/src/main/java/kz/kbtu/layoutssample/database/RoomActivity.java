package kz.kbtu.layoutssample.database;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import kz.kbtu.layoutssample.R;

public class RoomActivity extends AppCompatActivity {

    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Room.db")
                .build();

        new DatabaseAsync().execute();
    }


    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... voids) {
            RoomUser user = new RoomUser();
            user.setName("Name");
            user.setAge(18);


            database.userDao().insert(user);

            List<RoomUser> roomUsers = database.userDao().getAll();

            for (RoomUser roomUser: roomUsers){
                Log.e("RoomUser", roomUser.getName()+" "+roomUser.getAge());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }

}
