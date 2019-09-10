package com.belajardunia.konversisatuanmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Byte extends AppCompatActivity implements View.OnClickListener{
    private EditText edtByte;
    private Button btnKovert;
    private TextView tvResultBit, tvResultKbyte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byte);


        edtByte = findViewById(R.id.edtByte);
        btnKovert = findViewById(R.id.btnKonvert);
        tvResultBit = findViewById(R.id.tv_Result_Bit);
        tvResultKbyte =  findViewById(R.id.tv_Result_Kbyte);

        btnKovert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId() ==  R.id.btnKonvert) {
            String inputByte = edtByte.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputByte)) {
                isEmptyFields = true;
                edtByte.setError("Field ini tidak boleh kosong");
            }

            Double by = toDouble(inputByte);

            if (by == null) {
                isInvalidDouble = true;
                edtByte.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double b = by*8;
                double kb = by/1000;
                tvResultBit.setText(String.valueOf(b));
                tvResultKbyte.setText(String.valueOf(kb));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
