package com.example.rumah7;
public class Kartu {
    private String _id, _nama, _no, _harga;
    public Kartu (String id, String nama, String no, String harga) {
        this._id = id;
        this._nama = nama;
        this._no = no;
        this._harga = harga;
        }
        public Kartu() {
        }
        public String get_id() {
        return _id;
        }
        public void set_id(String _id) {
        this._id = _id;
        }
        public String get_nama() {
        return _nama;
        }
        public void set_nama(String _nama) {
        this._nama = _nama;
        }
        public String get_no() {
        return _no;
        }
        public void set_no(String _no) {
            this._no = _no;
        }
        public String get_harga() {
        return _harga;
        }
        public void set_harga(String _harga) {         this._harga = _harga;
    }
}
