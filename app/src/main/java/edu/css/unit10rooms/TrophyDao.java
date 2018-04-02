package edu.css.unit10rooms;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface TrophyDao {

//Add a trophy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrophy(Trophy trophy);
//find trohpy for user by userid
    @Query("SELECT * FROM trophy WHERE userId=:userId")
    List<Trophy> findTrophiesForUser(int userId);
//update trophy
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTrophy(Trophy trophy);
//delete trophy by id
    @Query("delete from trophy where id = :id")
    void delete(long id);

}
