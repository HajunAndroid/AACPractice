package kr.co.hajun.aacpractice;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CardUsageDAO {
    @Insert
    void Insert(CardUsage cardUsage);

    @Query("SELECT * FROM CardUsage")
    LiveData<List<CardUsage>> getAll();
}
