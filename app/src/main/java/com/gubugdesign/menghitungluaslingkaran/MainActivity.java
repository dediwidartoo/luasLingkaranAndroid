package com.gubugdesign.menghitungluaslingkaran;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView              = findViewById(R.id.scroll);
        final EditText edtJari  = findViewById(R.id.edtJari);
        Button button           = findViewById(R.id.btnCount);
        textView                = findViewById(R.id.txtResult);
        ImageView imageView     = findViewById(R.id.image);

        Picasso.get().load("http://images.pexels.com/photos/669615/pexels-photo-669615.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
                .into(imageView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jari = edtJari.getText().toString();

                if (edtJari.length()>0){
                    menghitungLuasLingkaran(Integer.parseInt(jari));
                }else {
                    Toast.makeText(getApplicationContext(),"Nilai tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void menghitungLuasLingkaran(int jari) {
        double phi =  3.14;
        double hasil = phi*jari*jari;

        textView.setText(String.valueOf(hasil));

        scrollView.smoothScrollBy(0, scrollView.getBottom());
    }
}
