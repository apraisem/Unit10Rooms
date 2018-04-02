package edu.css.unit10rooms;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class,  Trophy.class
}, version = 16, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

//For this instance...
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract TrophyDao trophyDao();
//get database conatct
    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "userdatabase")
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)

                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }
//destroy this instance
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
