package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.view.View;


public class Info extends AppCompatActivity implements View.OnClickListener {
    Button  btnCustomAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        Button button5;
        setContentView(R.layout.activity_info);
        button5 = this.findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            Intent i = new Intent(activity, MainActivity.class );
            startActivity(i);
        });
        btnCustomAlert = (Button) findViewById(R.id.btnCustomAlert);
        btnCustomAlert.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCustomAlert:
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_detailinfo);
                Button dialobButton = (Button) dialog.findViewById(R.id.btn_custom_alert_ok);
                dialobButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}
