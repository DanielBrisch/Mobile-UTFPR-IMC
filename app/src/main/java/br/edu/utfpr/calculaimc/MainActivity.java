package br.edu.utfpr.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText peso, altura;
    private Button btnCalcular;
    private TextView imcResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        btnCalcular = findViewById(R.id.btnCalcular);
        Button btnLimpar = findViewById(R.id.btnLimpar);
        imcResult = findViewById(R.id.imcResult);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = peso.getText().toString();
        String alturaStr = altura.getText().toString();

        if (TextUtils.isEmpty(pesoStr) || TextUtils.isEmpty(alturaStr)) {
            Toast.makeText(this, "Preencha ambos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr);

        float imc = peso / (altura * altura);

        imcResult.setText(String.format("IMC: %.2f", imc));
    }

    private void limparCampos() {
        peso.setText("");
        altura.setText("");
        imcResult.setText("IMC:");
    }
}