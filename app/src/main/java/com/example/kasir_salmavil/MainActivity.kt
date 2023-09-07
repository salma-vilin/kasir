package com.example.kasir_salmavil

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPelanggan = findViewById<EditText>(R.id.editnamapelanggan)
        val namaBarang = findViewById<EditText>(R.id.editnamabarang)
        val jumalahBeli = findViewById<EditText>(R.id.editjumlahbeli)
        val hargaSatuan = findViewById<EditText>(R.id.editharga)
        val uangBayar = findViewById<EditText>(R.id.edituangbayar)
        val btnProses = findViewById<Button>(R.id.btnproses)
        val txthargaTotal = findViewById<TextView>(R.id.txthargatotal)
        val txtuangkembali = findViewById<TextView>(R.id.txtuangkembali)
        val txtbonus = findViewById<TextView>(R.id.txtbonus)
        val txtkerangan = findViewById<TextView>(R.id.txtketerangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var hargaBarang =  Integer.parseInt(hargaSatuan.text.toString())
            var jmlBarang = Integer.parseInt(jumalahBeli.text.toString())
            var hargaTotal = hargaBarang * jmlBarang
            var uangBayar = Integer.parseInt(uangBayar.text.toString())
            var kembalian = uangBayar - hargaTotal

            txthargaTotal.text = "Harga Total Rp." + hargaTotal
            txtuangkembali.text = "Kembalian: " + if (kembalian<=0)  "Tidak Ada" else kembalian

            if(hargaTotal >= 200000) {
                txtbonus.text = "Bonus: Mouse"
            } else if (hargaTotal >= 400000) {
                txtbonus.text = "Bonus: Keyboard"
            } else if (hargaTotal >= 600000) {
                txtbonus.text = "Bonus: Harddisk"
            } else {
                txtbonus.text = "Bonus: Tidak ada"
            }

            if (kembalian == 0) {
                txtkerangan.text = "Keterangan: Uang Pas"
            } else if (kembalian > 0) {
                txtkerangan.text = "Keterangan: Menunggu Kembalian"
            } else {
                txtkerangan.text = "Keterangan: Uang kurang" + abs(kembalian)
            }

        }

        btnReset.setOnClickListener {
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumalahBeli.setText("")
            hargaSatuan.setText("")
            uangBayar.setText("")
            txthargaTotal.text = "Harga Total:"
            txtuangkembali.text = " Kembalian:"
            txtbonus.text = "Bonus:"
            txtkerangan.text = "Keterangan:"
        }
    }
}


