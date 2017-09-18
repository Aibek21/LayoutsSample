package kz.kbtu.layoutssample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by aibekkuralbaev on 18.09.17.
 */

@Database(entities = {RoomUser.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
