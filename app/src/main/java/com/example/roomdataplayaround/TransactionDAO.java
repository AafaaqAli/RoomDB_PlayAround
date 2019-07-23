package com.example.roomdataplayaround;

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

    @Query("SELECT COUNT(*) FROM  transactions")
        int countTransactions();

    @Query("SELECT * FROM transactions WHERE uid LIKE :mUid")
        Transaction findByUID(int mUid);

}
