package com.example.roomdataplayaround;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Transaction_Table")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    int uid;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "amount")
    double amount;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
