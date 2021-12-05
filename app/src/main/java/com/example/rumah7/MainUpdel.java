package com.example.rumah7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sno, Sharga;
    private EditText Enama, Eno, Eharga;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_updel);
            db = new MyDatabase(this);
            Intent i = this.getIntent();
            Sid = i.getStringExtra("Iid");
            Snama = i.getStringExtra("Inama");
            Sno = i.getStringExtra("Ino");
            Sharga = i.getStringExtra("Iharga");
            Enama = (EditText) findViewById(R.id.updel_nama);
            Eno = (EditText) findViewById(R.id.updel_no);
            Eharga = (EditText) findViewById(R.id.updel_harga);
            Enama.setText(Snama);
            Eno.setText(Sno);
            Eharga.setText(Sharga);
            Button btnUpdate = (Button) findViewById(R.id.btn_up);
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snama = String.valueOf(Enama.getText());
                    Sno = String.valueOf(Eno.getText());
                    Sharga = String.valueOf(Eharga.getText());
                    if (Snama.equals("")){
                        Enama.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (Sno.equals("")){
                        Eno.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi no",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if (Sharga.equals("")){
                        Eharga.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi harga",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                        {db.UpdateKartu(new Kartu(Sid, Snama, Sno, Sharga));
                        Toast.makeText(MainUpdel.this, "Data telah diupdate",
                                Toast.LENGTH_SHORT).show();
                        finish();
                        }
                    }
                });
                    Button btnDelete = (Button) findViewById(R.id.btn_del);
                    btnDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            db.DeleteKartu (new Kartu(Sid, Snama, Sno, Sharga));
                            Toast.makeText(MainUpdel.this, "Data telah dihapus",
                            Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
        } }