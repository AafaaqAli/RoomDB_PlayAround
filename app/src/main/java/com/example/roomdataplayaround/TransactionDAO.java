package com.example.roomdataplayaround;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface TransactionDAO {
    @Delete
        void delete(Transaction transaction);
    @Insert
        void insert(Transaction... transactions);

    @Query("SELECT COUNT(*) FROM  Transaction_Table")
        int countTransactions();

    @Query("SELECT * FROM Transaction_Table WHERE uid =:transactionID")
    LiveData<Transaction> getTransactionByID(int transactionID);
}
