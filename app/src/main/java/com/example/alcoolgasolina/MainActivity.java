package com.example.alcoolgasolina;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView melhorCombustivel;
    private TextInputEditText txtPrecoAlcool;
    private TextInputEditText txtPrecoGasolina;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraCampos();
        configuraBotoes();
    }

    private void configuraBotoes() {
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(onclickBtnCalcular());
    }

    private View.OnClickListener onclickBtnCalcular() {
        return view -> {
            calcularPreco();
        };
    }

    private void calcularPreco() {

        Double precoAlcool = txtPrecoAlcool.getText().toString().equals("") ? 0 : Double.parseDouble(txtPrecoAlcool.getText().toString());
        Double precoGasolina = txtPrecoGasolina.getText().toString().equals("") ? 0 : Double.parseDouble(txtPrecoGasolina.getText().toString());

        if (validaCampos(precoAlcool, precoGasolina)) {
            String melorOpcao = (precoAlcool / precoGasolina) > 0.7 ? "Gasolina" : "Alcool";
            melhorCombustivel.setText(getString(R.string.strMelhorCombustivel, melorOpcao));
        } else {
            melhorCombustivel.setText(R.string.strInformeTodosOsCampos);
        }
    }

    private boolean validaCampos(Double precoAlcool, Double precoGasolina) {
        if (precoAlcool == 0 || precoGasolina == 0) {
            return false;
        }
        return true;
    }

    private void configuraCampos() {
        melhorCombustivel = (TextView) findViewById(R.id.melhorCombustivel);
        txtPrecoAlcool = (TextInputEditText) findViewById(R.id.precoAlcool);
        txtPrecoGasolina = (TextInputEditText) findViewById(R.id.precoGasolina);
        
        melhorCombustivel.setText(getString(R.string.strInformeTodosOsCampos));
    }
}