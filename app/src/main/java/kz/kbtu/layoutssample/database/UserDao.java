package kz.kbtu.layoutssample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by aibekkuralbaev on 18.09.17.
 */

@Dao
public interface UserDao {


    @Query("SELECT * FROM users")
    List<RoomUser> getAll();

    @Insert
    void insert(RoomUser user);

    @Delete
    void delete(RoomUser user);


}
