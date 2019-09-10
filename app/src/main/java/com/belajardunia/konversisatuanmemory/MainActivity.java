package com.belajardunia.konversisatuanmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBit = findViewById(R.id.btn_bit);
        btnBit.setOnClickListener(this);

        Button btnByte = findViewById(R.id.btn_byte);
        btnByte.setOnClickListener(this);

        Button btnKbyte = findViewById(R.id.btn_kbyte);
        btnKbyte.setOnClickListener(this);

        Button btnInformation = findViewById(R.id.btn_information);
        btnInformation.setOnClickListener(this);


        btn_fragment = (Button) findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new About()).commit();
            }
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_bit:
                Intent moveBit =  new Intent(MainActivity.this, Bit.class);
                startActivity(moveBit);
                break;

            case R.id.btn_byte:
                Intent moveByte =  new Intent(MainActivity.this, Byte.class);
                startActivity(moveByte);
                break;

            case R.id.btn_kbyte:
                Intent moveKbyte =  new Intent(MainActivity.this, Kbyte.class);
                startActivity(moveKbyte);
                break;

            case R.id.btn_information:
                Intent moveInformation = new Intent(MainActivity.this, Information.class);
                startActivity(moveInformation);
                break;
        }
    }

}
