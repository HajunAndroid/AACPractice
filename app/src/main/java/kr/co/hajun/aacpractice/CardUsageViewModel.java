package kr.co.hajun.aacpractice;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class CardUsageViewModel extends AndroidViewModel {
    public LiveData<List<CardUsage>> cardUsageList;
    private CardUsageDAO cardUsageDAO;

    public CardUsageViewModel(@NonNull Application application) {
        super(application);
        CardUsageDatabase db = Room.databaseBuilder(application, CardUsageDatabase.class, "cardUsage").build();
        cardUsageDAO = db.getCardUsageDao();
        cardUsageList = db.getCardUsageDao().getAll();
    }

    public void insert(CardUsage cardUsage){
        new InsertCardUsageAsyncTask().execute(cardUsage);
    }

    private class InsertCardUsageAsyncTask extends AsyncTask<CardUsage,Void,Void>{
        @Override
        protected Void doInBackground(CardUsage... cardUsages) {
            cardUsageDAO.Insert(cardUsages[0]);
            return null;
        }
    }
}
