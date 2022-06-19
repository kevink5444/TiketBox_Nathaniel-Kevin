package com.nathanielkevinkurniawan.utsa.ticketbox;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class PesanTiket extends AppCompatActivity {
    TextView dn1,dn2,dn3,jmlbyr,hrg1,hrg2,hrg3,jmlbyrcc,txtoutput;
    ScrollView bank,cc,main,output;
    Integer totalbayar=0;
    CheckBox armada,iwanfals,tulus;
    EditText et_armada,et_iwanfals,et_tulus,noID,nama,email,notelp,alamat,viabank,noac,atsnama,namacc,atsnamacc;
    Integer[] harga={400000,600000,800000};
    Integer[] totalharga={0,0,0};
    String line1="",line2="",line3="",jeniskartu,datenow,metodepemb,banktransfer="",creditcard="",maintext;
    String[] kota={"Bali","Surabaya","Makassar","Jakarta","Medan","Malang"};
    Spinner sp1,sp2,sp3;
    RadioButton rb1,rb2,rb3,rb4,rbbank,rbcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_tiket);
        bank=(ScrollView) findViewById(R.id.SV_bank);
        cc=(ScrollView) findViewById(R.id.SV_CC);
        main=(ScrollView) findViewById(R.id.SV_main);
        output=(ScrollView) findViewById(R.id.SV_output);
        armada=(CheckBox) findViewById(R.id.cb_01);
        iwanfals=(CheckBox) findViewById(R.id.cb_02);
        tulus=(CheckBox) findViewById(R.id.cb_03);
        et_armada=(EditText) findViewById(R.id.et_jml1);
        et_iwanfals=(EditText) findViewById(R.id.et_jml2);
        et_tulus=(EditText) findViewById(R.id.et_jml3);
        sp1=(Spinner) findViewById(R.id.SPN_1);
        sp2=(Spinner) findViewById(R.id.SPN_2);
        sp3=(Spinner) findViewById(R.id.SPN_3);
        noID=(EditText) findViewById(R.id.et_noid);
        rb1=(RadioButton) findViewById(R.id.rb_KTP);
        rb2=(RadioButton) findViewById(R.id.rb_SIM);
        rb3=(RadioButton) findViewById(R.id.rb_KP);
        rb4=(RadioButton) findViewById(R.id.rb_passpor);
        nama=(EditText) findViewById(R.id.et_nama);
        email=(EditText) findViewById(R.id.et_email);
        notelp=(EditText) findViewById(R.id.et_telp);
        alamat=(EditText) findViewById(R.id.et_alamat);
        viabank=(EditText) findViewById(R.id.et_viabank);
        noac=(EditText) findViewById(R.id.et_noac);
        namacc=(EditText) findViewById(R.id.et_nmcc);
        atsnamacc=(EditText) findViewById(R.id.et_ccatasnama);
        atsnama=(EditText) findViewById(R.id.et_atasnama);
        dn1=(TextView) findViewById(R.id.txt_datenow1);
        dn2=(TextView) findViewById(R.id.txt_datenow2);
        dn3=(TextView) findViewById(R.id.txt_datenow3);
        hrg1=(TextView) findViewById(R.id.txt_harga_1);
        hrg2=(TextView) findViewById(R.id.txt_harga_2);
        hrg3=(TextView) findViewById(R.id.txt_harga_3);
        txtoutput=(TextView) findViewById(R.id.txt_output);
        jmlbyrcc=(TextView) findViewById(R.id.txt_jmlbayar);
        hrg1.setText("Rp."+harga[0]+".-");
        hrg2.setText("Rp."+harga[1]+".-");
        hrg3.setText("Rp."+harga[2]+".-");
        datenow = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        dn1.setText(datenow);
        dn2.setText(datenow);
        dn3.setText(datenow);
        jmlbyr=(TextView) findViewById(R.id.txt_jmltrans);
        rbbank=(RadioButton) findViewById(R.id.rb_bank);
        rbcc=(RadioButton) findViewById(R.id.rb_cc);

        bank.setVisibility(View.INVISIBLE);
        cc.setVisibility(View.INVISIBLE);

        //disable all
        output.setVisibility(View.INVISIBLE);
        et_armada.setVisibility(View.INVISIBLE);
        sp1.setVisibility(View.INVISIBLE);
        hrg1.setVisibility(View.INVISIBLE);
        et_iwanfals.setVisibility(View.INVISIBLE);
        sp2.setVisibility(View.INVISIBLE);
        hrg2.setVisibility(View.INVISIBLE);
        et_tulus.setVisibility(View.INVISIBLE);
        sp3.setVisibility(View.INVISIBLE);
        hrg3.setVisibility(View.INVISIBLE);
    }

    public void pembayaran(View view){
        if(armada.isChecked()){
            totalharga[0]=harga[0]*Integer.parseInt(String.valueOf(et_armada.getText()));
            line1="Konser Armada  "+"x"+et_armada.getText()+"  "+sp1.getSelectedItem().toString();
        }
        if(iwanfals.isChecked()){
            totalharga[1]=harga[1]*Integer.parseInt(String.valueOf(et_iwanfals.getText()));
            line2="Konser Iwan Fals  "+"x"+et_iwanfals.getText()+"  "+sp2.getSelectedItem().toString();
        }
        if(tulus.isChecked()){
            totalharga[2]=harga[2]*Integer.parseInt(String.valueOf(et_tulus.getText()));
            line3="Konser Tulus  "+"x"+et_tulus.getText()+"  "+sp3.getSelectedItem().toString();
        }
        if(rb1.isChecked()){
            jeniskartu="KTP";
        }
        if(rb2.isChecked()){
            jeniskartu="SIM";
        }
        if(rb3.isChecked()){
            jeniskartu="Kartu Pelajar";
        }
        if(rb4.isChecked()){
            jeniskartu="Passpor";
        }
        if(rbbank.isChecked()){
            metodepemb="Bank Transfer";
            bank.setVisibility(View.VISIBLE);
            main.setVisibility(View.INVISIBLE);
        }
        if(rbcc.isChecked()){
            metodepemb="Kartu Kredit";
            cc.setVisibility(View.VISIBLE);
            main.setVisibility(View.INVISIBLE);
        }
        totalbayar=0;
        for (int i = 0; i < totalharga.length; i++){
            totalbayar+=totalharga[i];
        }
        jmlbyrcc.setText("Rp."+totalbayar+",-");
        jmlbyr.setText("Rp."+totalbayar+",-");

    }
    public void proses(View view){
        if(rbbank.isChecked()){
            banktransfer="tanggal : "+datenow+"" +
                    "\nJumlah Bayar : " +totalbayar+
                    "\nVia Bank : " +viabank.getText().toString()+
                    "\nNo AC : " +noac.getText().toString()+
                    "\nAtas Nama : " +atsnama.getText().toString();
        }
        if(rbcc.isChecked()){
            creditcard="Nama KK : " +namacc.getText().toString()+
                    "\nAtas Nama : " +atsnamacc.getText().toString()+
                    "\nJumlah Bayar : " +jmlbyrcc.getText().toString()+
                    "\nTanggal : " +datenow;
        }
        maintext="PESANAN ANDA" +
                "\nTanggal : "+datenow+
                "\n"+line1+
                "\n"+line2+
                "\n"+line3+
                "\nTotal Bayar : "+totalbayar.toString() +
                "\n" +
                "\nIDENTITAS PEMESAN" +
                "\nNo "+jeniskartu+" : " +noID.getText().toString()+
                "\nNama : " +nama.getText().toString()+
                "\nEmail : " +email.getText().toString()+
                "\nNo Telp : " +notelp.getText().toString()+
                "\nAlamat : " +alamat.getText().toString()+
                "\n" +
                "\nPEMBAYARAN" +
                "\nMetode Pembayaran : " +metodepemb+
                "\n" +banktransfer+
                "\n" +creditcard+
                "\n---END---";
        txtoutput.setText(maintext);
        bank.setVisibility(View.INVISIBLE);
        cc.setVisibility(View.INVISIBLE);
        output.setVisibility(View.VISIBLE);
    }

    public void bankback(View view){
        bank.setVisibility(View.INVISIBLE);
        main.setVisibility(View.VISIBLE);
        cc.setVisibility(View.INVISIBLE);
    }

    public void backmenu(View view){
        Intent iMenu1 = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(iMenu1);
    }
    public void cb1(View view){
        if(armada.isChecked()){
            et_armada.setVisibility(View.VISIBLE);
            sp1.setVisibility(View.VISIBLE);
            hrg1.setVisibility(View.VISIBLE);
        }else {
            et_armada.setVisibility(View.INVISIBLE);
            sp1.setVisibility(View.INVISIBLE);
            hrg1.setVisibility(View.INVISIBLE);
        }
    }
    public void cb2(View view){
        if(iwanfals.isChecked()){
            et_iwanfals.setVisibility(View.VISIBLE);
            sp2.setVisibility(View.VISIBLE);
            hrg2.setVisibility(View.VISIBLE);
        }else {
            et_iwanfals.setVisibility(View.INVISIBLE);
            sp2.setVisibility(View.INVISIBLE);
            hrg2.setVisibility(View.INVISIBLE);
        }
    }
    public void cb3(View view){
        if(tulus.isChecked()){
            et_tulus.setVisibility(View.VISIBLE);
            sp3.setVisibility(View.VISIBLE);
            hrg3.setVisibility(View.VISIBLE);
        }else {
            et_tulus.setVisibility(View.INVISIBLE);
            sp3.setVisibility(View.INVISIBLE);
            hrg3.setVisibility(View.INVISIBLE);
        }
    }
}
