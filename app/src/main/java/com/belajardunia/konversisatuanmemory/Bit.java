package com.belajardunia.konversisatuanmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bit extends AppCompatActivity implements View.OnClickListener{
    private EditText edtBit;
    private Button btnKovert;
    private TextView tvResultByte, tvResultKbyte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit);

        edtBit = findViewById(R.id.edtBit);
        btnKovert = findViewById(R.id.btnKonvert);
        tvResultByte = findViewById(R.id.tv_Result_Byte);
        tvResultKbyte =  findViewById(R.id.tv_Result_Kbyte);

        btnKovert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if (v.getId() ==  R.id.btnKonvert) {
            String inputBit = edtBit.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputBit)) {
                isEmptyFields = true;
                edtBit.setError("Field ini tidak boleh kosong");
            }

            Double bit = toDouble(inputBit);

            if (bit == null) {
                isInvalidDouble = true;
                edtBit.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double b = bit*0.125;
                double kb = bit*0.000125;
                tvResultByte.setText(String.valueOf(b));
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
