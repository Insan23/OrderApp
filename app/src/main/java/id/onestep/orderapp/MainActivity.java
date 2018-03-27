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
    CheckBox cbNasi,cbMie,cbEsteh,cbEsjeruk;
    TextView txtOrder;
    EditText etNama,etJumlahNasi,etJumlahMie,etJumlahEsteh,etJumlahEsjeruk;
    Button submit;
    //int jumlahNasi,jumlahMie,jumlahEsteh,jumlahEsjeruk;
    double totalHarga;
    boolean status;
    ArrayList<String> orderMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbNasi=(CheckBox)findViewById(R.id.ckNasi);
        cbMie=(CheckBox)findViewById(R.id.ckMie);
        cbEsteh=(CheckBox)findViewById(R.id.ckEsteh);
        cbEsjeruk=(CheckBox)findViewById(R.id.ckEsjeruk);
        txtOrder=(TextView)findViewById(R.id.orderSummary);
        etNama=(EditText)findViewById(R.id.etNama);
        etJumlahNasi=(EditText) findViewById(R.id.etJumlahNasi);
        etJumlahMie=(EditText) findViewById(R.id.etJumlahMie);
        etJumlahEsteh=(EditText) findViewById(R.id.etEsteh);
        etJumlahEsjeruk=(EditText) findViewById(R.id.etEsjeruk);

        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        submit = (Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMenu=new ArrayList<String>();
                String order="";
                if (cbNasi.isChecked()){
                    orderMenu.add("Nasi Goreng");
                    if (etJumlahNasi.getText().length()==0){
                        etJumlahNasi.setError("harus diisi");
                        status=false;
                    }
                    else {
                        status=true;
                    int jumlahNasi = Integer.parseInt(etJumlahNasi.getText().toString());
                    totalHarga+=jumlahNasi*7000;

                    }

                }
                if (cbMie.isChecked()){
                    if (etJumlahMie.getText().length()==0){
                        etJumlahMie.setError("harus diisi");
                        status=false;
                    }
                    else{
                        orderMenu.add("Mie Goreng");

                        int jumlahMie = Integer.parseInt(etJumlahMie.getText().toString());
                        totalHarga+=jumlahMie*7000;
                    }

                }
                if (cbEsteh.isChecked()){
                    orderMenu.add("Es Teh");
                    int jumlahEsteh = Integer.parseInt(etJumlahEsteh.getText().toString());
                    totalHarga+=jumlahEsteh*3000;
                }
                if (cbEsjeruk.isChecked()){
                    orderMenu.add("Es Jeruk");
                    int jumlahEsjeruk = Integer.parseInt(etJumlahEsjeruk.getText().toString());
                    totalHarga+=jumlahEsjeruk*4000;
                }

                for (int i=0;i<orderMenu.size();i++){
                    order+=orderMenu.get(i)+"\n";

                }
                order+="\nharga : "+formatRupiah.format((double)totalHarga);
                txtOrder.setText(order);
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_SUBJECT,"order dari "+etNama.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT,order);
                if (status){
                    startActivity(i);
                }
            }
        });



    }
}
