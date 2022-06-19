package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class KonserArmada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        Button button6;
        setContentView(R.layout.activity_konserarmada);
        button6 = this.findViewById(R.id.button6);
        button6.setOnClickListener(view -> {
            Intent i = new Intent(activity, MainActivity.class );
            startActivity(i);
        });
        this.setTitle("Konser Armada");
    }
}
