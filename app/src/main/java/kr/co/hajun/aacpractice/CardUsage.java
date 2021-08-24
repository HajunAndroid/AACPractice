package kr.co.hajun.aacpractice;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CardUsage {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String store;
    public int price;
    public String date;
}
