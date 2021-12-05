package com.example.rumah7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_gudang";
    private static final String tb_kartu = "tb_kartu";
    private static final String tb_kartu_id = "id";
    private static final String tb_kartu_nama = "nama";
    private static final String tb_kartu_no = "no";
    private static final String tb_kartu_harga = "harga";
    private static final String CREATE_TABLE = "CREATE TABLE " +
        tb_kartu + "("
            + tb_kartu_id + " INTEGER PRIMARY KEY ,"
            + tb_kartu_nama + " TEXT,"
            + tb_kartu_no + " TEXT,"
            + tb_kartu_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);     }
        @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {      }
    public void CreateKartu (Kartu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kartu_id, mdNotif.get_id());
        values.put(tb_kartu_nama, mdNotif.get_nama());
        values.put(tb_kartu_no, mdNotif.get_no());
        values.put(tb_kartu_harga, mdNotif.get_harga());
        db.insert(tb_kartu, null, values);
        db.close();
    }
        public List<Kartu> ReadKartu() {
        List<Kartu> judulModelList = new ArrayList<Kartu>();
        String selectQuery = "SELECT * FROM " + tb_kartu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
               Kartu mdKontak = new Kartu();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_no(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateKartu (Kartu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kartu_nama, mdNotif.get_nama());
        values.put(tb_kartu_no, mdNotif.get_no());
        values.put(tb_kartu_harga, mdNotif.get_harga());
        return db.update(tb_kartu, values, tb_kartu_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteKartu (Kartu mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kartu, tb_kartu_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}