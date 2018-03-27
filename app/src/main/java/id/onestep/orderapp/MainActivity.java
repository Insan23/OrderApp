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

    CheckBox cbNasi, cbMie, cbEsteh, cbEsjeruk;
    TextView txtOrder;
    EditText etNama, etJumlahNasi, etJumlahMie, etJumlahEsteh, etJumlahEsjeruk;
    Button submit;
    //int jumlahNasi,jumlahMie,jumlahEsteh,jumlahEsjeruk;
    String order;
    double totalHarga;
    boolean status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbNasi = (CheckBox) findViewById(R.id.ckNasi);
        txtOrder = (TextView) findViewById(R.id.orderSummary);
        etNama = (EditText) findViewById(R.id.etNama);
        etJumlahNasi = (EditText) findViewById(R.id.etJumlahNasi);

        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order = "";
                if (cbNasi.isChecked()) {
                    if (etJumlahNasi.getText().length() == 0) {
                        etJumlahNasi.setError("harus diisi");
                        status = false;
                    } else {
                        status = true;
                        int jumlahNasi = Integer.parseInt(etJumlahNasi.getText().toString());
                        order += "Nasi Goreng, " + jumlahNasi + " piring @ Rp 7000 : " + (jumlahNasi * 7000) + "\n";
                        totalHarga += jumlahNasi * 7000;
                    }
                }

                order += "\nharga : " + formatRupiah.format((double) totalHarga);
                txtOrder.setText(order);
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_SUBJECT, "order dari " + etNama.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, order);
                if (status) {
                    startActivity(i);
                }
            }
        });
    }
}
