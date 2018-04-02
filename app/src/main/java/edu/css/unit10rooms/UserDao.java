package edu.css.unit10rooms;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface UserDao {

//adding a user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);
//getting a list of all users
    @Query("select * from user")
    public List<User> getAllUser();
//get user by userID
    @Query("select * from user where id = :userId")
    public List<User> getUser(long userId);

//Update user
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

//delete all users
    @Query("delete from user")
    void removeAllUsers();
}