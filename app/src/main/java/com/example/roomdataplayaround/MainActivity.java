package com.example.roomdataplayaround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewAmount, textViewDate, textViewUID;
    private Button buttonAddTransaction, buttonPreviewPrevious, buttonPreviewNext;
    private EditText ediTextAmount;
    double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAmount = findViewById(R.id.textViewAmount);
        textViewDate = findViewById(R.id.textViewDate);
        textViewUID = findViewById(R.id.textViewUID);

        buttonAddTransaction = findViewById(R.id.buttonAdd);
        buttonPreviewNext = findViewById(R.id.buttonNext);
        buttonPreviewPrevious = findViewById(R.id.buttonPrevious);

        //onClickNext();
        //onClickPrevious();

        onClickAdd();
        addTransaction();
    }


    private void addTransaction() {
        TransactionRepository transactionRepo = new TransactionRepository();
        //getting null-pointer exception
        //amount = Double.parseDouble(ediTextAmount.getText().toString());
        transactionRepo.insertTransaction(10.5);
      
    }

    public void onClickAdd() {
        buttonAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    addTransaction();

            }
        });
    }


}
