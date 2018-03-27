package id.onestep.orderapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        EditText mJumlah = (EditText) findViewById(R.id.teks_jumlah);
        jumlah = Integer.parseInt(mJumlah.getText().toString());
        tampilkanHarga(jumlah * 7000);
    }

    public void tampilkanHarga(int harga) {
        TextView quantity = findViewById(R.id.teks_harga);
        EditText mNama = (EditText) findViewById(R.id.nama);
        String pemesanan = mNama.toString();
        pemesanan += "\nRp " + harga;
        quantity.setText(pemesanan);
    }
}
