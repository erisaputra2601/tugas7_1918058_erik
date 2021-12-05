package com.example.rumah7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
    public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
        private ListView mListView;
        private CustomListAdapter adapter_off;
        private MyDatabase db;
        private List<Kartu> ListKartu = new ArrayList<Kartu>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_read);
            db = new MyDatabase(this);
            adapter_off = new CustomListAdapter(this, ListKartu );
            mListView = (ListView) findViewById(R.id.list_barang);
            mListView.setAdapter(adapter_off);
            mListView.setOnItemClickListener(this);
            mListView.setClickable(true);
                ListKartu.clear();
                List<Kartu> contacts = db.ReadKartu();
                for (Kartu cn : contacts) {
                    Kartu judulModel = new Kartu();
                    judulModel.set_id(cn.get_id());
                    judulModel.set_nama(cn.get_nama());
                    judulModel.set_no(cn.get_no());
                    judulModel.set_harga(cn.get_harga());
                    ListKartu.add(judulModel);
                    if ((ListKartu.isEmpty()))
                        Toast.makeText(MainRead.this, "Tidak ada data",
                                Toast.LENGTH_SHORT).show();
                    else {

                    }
                }
        }
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
            Object o = mListView.getItemAtPosition(i);
            Kartu obj_itemDetails = (Kartu) o;
            String Sid = obj_itemDetails.get_id();
            String Snama = obj_itemDetails.get_nama();
            String Sno = obj_itemDetails.get_no();
            String Sharga = obj_itemDetails.get_harga();
            Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
            goUpdel.putExtra("Iid", Sid);
            goUpdel.putExtra("Inama", Snama);
            goUpdel.putExtra("Ino", Sno);
            goUpdel.putExtra("Iharga", Sharga);
            startActivity(goUpdel);     }
            @Override
            protected void onResume() {
            super.onResume();
            ListKartu.clear();
            mListView.setAdapter(adapter_off);
            List<Kartu> contacts = db.ReadKartu();
            for (Kartu cn : contacts) {
                Kartu judulModel = new Kartu();
                judulModel.set_id(cn.get_id());
                judulModel.set_nama(cn.get_nama());
                judulModel.set_no(cn.get_no());
                judulModel.set_harga(cn.get_harga());
                ListKartu.add(judulModel);
                    if ((ListKartu.isEmpty()))
                        Toast.makeText(MainRead.this, "Tidak ada data",
                                Toast.LENGTH_SHORT).show();
                    else {

                    }
            }
        }
    }