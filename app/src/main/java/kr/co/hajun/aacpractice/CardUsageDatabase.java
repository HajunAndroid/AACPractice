package kr.co.hajun.aacpractice;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CardUsage.class},version = 1)
public abstract class CardUsageDatabase extends RoomDatabase {
    public abstract CardUsageDAO getCardUsageDao();
}
