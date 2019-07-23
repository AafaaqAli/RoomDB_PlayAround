package com.example.roomdataplayaround;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class TransactionRepository {

    private final String LOG_TAG = "AsyncTag";

    private static AppDatabase INSTANCE;
    private String DB_NAME = "transaction_DB";
    private AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "transaction_DB")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public void insertTransaction(double amount) {
        Date currentTime = Calendar.getInstance().getTime();
        String currentDate = currentTime.toString();


        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(currentDate);

        insertTransaction(transaction);
    }

    public void insertTransaction(final Transaction transaction){
        ///Async Task to insert Transaction
        Log.d(LOG_TAG, "Async task started");


    }



}
