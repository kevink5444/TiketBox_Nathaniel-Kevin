package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
public class Daftar_Konser extends AppCompatActivity {
    private Activity activityDaftarKonser = this;
    ListView list;
    String[] konser = new String[] { "Armada", "Iwan Fals", "Tulus"};
    Integer[] imageKonser = {R.drawable.iconarmada, R.drawable.iconiwanfals, R.drawable.icontulus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_konser);
        CustomListView adapterF = new CustomListView(Daftar_Konser.this,konser,imageKonser);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapterF);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                    if (i == 0) {
                        startActivity(new Intent(activityDaftarKonser,KonserArmada.class));
                    } else if (i == 1) { startActivity(new Intent(activityDaftarKonser,KonserIwanFals.class));
                    } else if (i == 2) { startActivity(new Intent(activityDaftarKonser,KonserTulus.class));
                }
            }
        });
    }
}


