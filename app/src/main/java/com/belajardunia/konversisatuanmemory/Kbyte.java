package com.belajardunia.konversisatuanmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kbyte extends AppCompatActivity implements View.OnClickListener{
    private EditText edtKbyte;
    private Button btnKovert;
    private TextView tvResultByte, tvResultBit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kbyte);

        edtKbyte = findViewById(R.id.edtKbyte);
        btnKovert = findViewById(R.id.btnKonvert);
        tvResultBit = findViewById(R.id.tv_Result_Bit);
        tvResultByte =  findViewById(R.id.tv_Result_Byte);

        btnKovert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId() ==  R.id.btnKonvert) {
            String inputKbyte = edtKbyte.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputKbyte)) {
                isEmptyFields = true;
                edtKbyte.setError("Field ini tidak boleh kosong");
            }

            Double by = toDouble(inputKbyte);

            if (by == null) {
                isInvalidDouble = true;
                edtKbyte.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double b = by*8000;
                double kb = by*1000;
                tvResultBit.setText(String.valueOf(b));
                tvResultByte.setText(String.valueOf(kb));
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
