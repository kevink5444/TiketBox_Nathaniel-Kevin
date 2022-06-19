package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class KonserIwanFals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        Button button7;
        setContentView(R.layout.activity_konser_iwanfals);
        button7 = this.findViewById(R.id.button7);
        button7.setOnClickListener(view -> {
            Intent i = new Intent(activity, MainActivity.class);
            startActivity(i);
        });
        this.setTitle("Konser Iwan Fals");
    }
}