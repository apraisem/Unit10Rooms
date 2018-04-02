package edu.css.unit10rooms;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

//Entity for trophy
@Entity(tableName = "trophy",
        foreignKeys = {
                @ForeignKey( //connecting user to trophy
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)
//trophy class
public class Trophy {

    @PrimaryKey(autoGenerate = true)
//initiates id
    long id;

//initiates userID
    public long userId;

//Initiates description
    String description;

    public Trophy(long userId, String description) {
        this.userId = userId;
        this.description = description;
    }
}