package com.example.rumah7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eno, Eharga;
    private String Snama, Sno, Sharga;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_create);
            db = new MyDatabase(this);
            Enama = (EditText) findViewById(R.id.create_nama);
            Eno = (EditText) findViewById(R.id.create_no);
            Eharga = (EditText) findViewById(R.id.create_harga);

            Button btnCreate = (Button) findViewById(R.id.create_btn);
            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snama = String.valueOf(Enama.getText());
                    Sno = String.valueOf(Eno.getText());
                    Sharga = String.valueOf(Eharga.getText());
                    if (Snama.equals("")){
                        Enama.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi nama barang",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sno.equals("")){
                        Eno.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi warna",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sharga.equals("")) {
                        Eharga.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi berat",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        Enama.setText("");
                        Eno.setText("");
                        Eharga.setText("");
                        Toast.makeText(MainCreate.this, "Data telah ditambah",
                                Toast.LENGTH_SHORT).show();
                        db.CreateKartu (new Kartu(null, Snama, Sno, Sharga));
                        Intent a = new Intent(MainCreate.this, MainActivity.class);
                        startActivity(a);
                    }
                }
            });
        }
}