package com.nathanielkevinkurniawan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private final Activity activity = this;
    ImageButton button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = this.findViewById(R.id.button1);
        button2 = this.findViewById(R.id.button2);
        button3 = this.findViewById(R.id.button3);
        button4 = this.findViewById(R.id.button4);
        button1.setOnClickListener(view -> {
            Intent i = new Intent(activity, PesanTiket.class );
            startActivity(i);
        });

        button2.setOnClickListener(view -> {
            Intent i = new Intent(activity, Daftar_Konser.class );
            startActivity(i);
        });

        button3.setOnClickListener(view -> {
            Intent i = new Intent(activity, Official.class );
            startActivity(i);
        });

        button4.setOnClickListener(view -> {
            Intent i = new Intent(activity, Info.class );
            startActivity(i);
        });
    }
}