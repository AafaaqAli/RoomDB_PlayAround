package com.example.roomdataplayaround;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract TransactionDAO transactionDao();

    public static AppDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "transaction_DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
         INSTANCE = null;

    }

}
