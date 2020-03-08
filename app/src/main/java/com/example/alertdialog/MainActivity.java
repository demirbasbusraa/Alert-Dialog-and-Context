package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Context
        /*Activity Context -> this veya MainActivity.this kullanılır
         Aktiviteyle alakalı durumlarda this kullan*/
        /*App Context -> getApplicationContext()
           Genel app i ilgilendiren durumlarda getApplicationContext'i kullan.
         */
        //Yani senaryoya göre değişiyor. Mesela

        Toast.makeText(MainActivity.this, "toast message", Toast.LENGTH_LONG).show();
        //Buradaki this bir üstüne referans veriyor yani MainActivity'e.
        // Ya da Listenerların içinde this kullanırsam Listener'ın kedisine referans verecektir

    }

    public void save(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("SAVE");
        alert.setMessage("Are you sure?"); // Butona tıklandığında kullanıcıya gösterilecek mesajdır.
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            //Listener dediğimiz şey bir şeye tıklandığında veya bir olay(event) olduğunda
            //ne olacağını ne yazacağımızı yazdığımız dinleyici bir metoddur(arayüzler).
            //Bu listenerlar genellikle hazır metodların üzerine yazılır override edilir, çok sık karşılaşacağız!

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // YESE TIKLARSA(POZİTİF OLAY) NE OLACAĞINI YAZCAM BURDA -> SAVE
                // Küçük bir mesaj göster kullanıcıya Toast ile
                Toast.makeText(MainActivity.this, "SAVED", Toast.LENGTH_LONG).show();

            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "NOT SAVED", Toast.LENGTH_LONG).show();

            }
        });
        alert.show();



    }



}
