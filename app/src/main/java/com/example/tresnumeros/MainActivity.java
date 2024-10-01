package com.example.tresnumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    EditText num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);

        Button btnMenor = findViewById(R.id.btnMenor);
        Button btnMayor = findViewById(R.id.btnMayor);
        Button btnAsc = findViewById(R.id.btnAsc);
        Button btnDesc = findViewById(R.id.btnDesc);
        Button btnBorrar = findViewById(R.id.btnBorrar);

        btnMenor.setOnClickListener(view -> ordenar("menor"));
        btnMayor.setOnClickListener(view -> ordenar("mayor"));
        btnDesc.setOnClickListener(view -> ordenar("desc"));
        btnAsc.setOnClickListener(view -> ordenar("asc"));
        btnBorrar.setOnClickListener(view -> borrar());
    }

    private void ordenar(String tipo) {

        String strNum1 = num1.getText().toString();
        String strNum2 = num2.getText().toString();
        String strNum3 = num3.getText().toString();

        if (!strNum1.isEmpty() && !strNum2.isEmpty() && !strNum3.isEmpty()) {
            try {

                int numero1 = Integer.parseInt(strNum1);
                int numero2 = Integer.parseInt(strNum2);
                int numero3 = Integer.parseInt(strNum3);
                int[] numeros = {numero1, numero2, numero3};
                int resultado;

                switch (tipo) {
                    case "menor":
                        resultado = (numero1 < numero2 && numero1 < numero3) ? numero1 : (numero2 < numero1 && numero2 < numero3) ? numero2 : numero3;
                        tv1.setText("");
                        tv2.setText(String.valueOf(resultado));
                        tv3.setText("");
                        break;

                    case "mayor":
                        resultado = (numero1 > numero2 && numero1 > numero3) ? numero1 : (numero2 > numero1 && numero2 > numero3) ? numero2 : numero3;
                        tv1.setText("");
                        tv2.setText(String.valueOf(resultado));
                        tv3.setText("");
                        break;

                    case "asc":

                        Arrays.sort(numeros);
                        tv1.setText(String.valueOf(numeros[0]));
                        tv2.setText(String.valueOf(numeros[1]));
                        tv3.setText(String.valueOf(numeros[2]));
                        break;

                    case "desc":
                        Arrays.sort(numeros);
                        tv1.setText(String.valueOf(numeros[2]));
                        tv2.setText(String.valueOf(numeros[1]));
                        tv3.setText(String.valueOf(numeros[0]));
                        break;
                }
            } catch (NumberFormatException e) {
                tv2.setText("Error: Ingrese números válidos");
            }
        } else {
            tv2.setText("Rellene todos los campos");
        }
    }

    private void borrar() {
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        num1.setText("");
        num2.setText("");
        num3.setText("");
    }
}