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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int jumlahNasiGoreng = 5;
        tampilkan(jumlahNasiGoreng);
        tampilkanHarga(jumlahNasiGoreng * 7000);
    }

    public void tampilkan(int angka) {
        TextView quantity = findViewById(R.id.teks_jumlah);
        quantity.setText(angka);
    }

    public void tampilkanHarga(int harga) {
        TextView quantity = findViewById(R.id.teks_harga);
        quantity.setText("Rp " + harga);
    }
}
