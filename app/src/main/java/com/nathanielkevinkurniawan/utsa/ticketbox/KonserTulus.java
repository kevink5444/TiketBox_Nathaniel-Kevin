package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class KonserTulus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        Button button8;
        setContentView(R.layout.activity_konsertulus);
        button8 = this.findViewById(R.id.button8);
        button8.setOnClickListener(view -> {
            Intent i = new Intent(activity, MainActivity.class);
            startActivity(i);
        });
        this.setTitle("Konser Tulus");
    }
}