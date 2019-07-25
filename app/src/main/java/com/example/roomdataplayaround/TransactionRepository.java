package com.example.roomdataplayaround;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class TransactionRepository {
    private final String LOG_TAG = "AsyncTag";
    private String DB_NAME = "transaction_DB";
    private AppDatabase appDatabase;

    ///UID auto_Generate is not working (Temp variable)
    static int tempUID = 0;

    LiveData<Transaction> tempTransaction;


    public TransactionRepository(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }


    public void insertTransaction(double amount) {

        Date currentTime = Calendar.getInstance().getTime();
        String currentDate = currentTime.toString();

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(currentDate);
        //transaction.setUid(tempUID);

        insertTransaction(transaction);
        //tempUID++;
    }
    private void insertTransaction(final Transaction mTransaction) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(LOG_TAG,
                        "UID: " + mTransaction.getUid() + " AMOUNT: " + mTransaction.getAmount() + " DATE" + mTransaction.getDate());

                appDatabase.transactionDAO().insert(mTransaction);
            }
        });
    }

    public LiveData<Transaction> getTransaction(final int mUID){
        return appDatabase.transactionDAO().getTransactionByID(mUID);
    }
}
