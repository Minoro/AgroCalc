package br.com.minoro.calcpulverizador;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private final static int FATOR_CONVERSAO = 600;
    private final static float VALORES_DISTANCIA[] = {0.6F, 0.5F, 0.4F, 0.35F};

    private float distancia = 1.F;
    private float velocidade = 1.F;
    private float vazao = 0.F;
    private float volume = 0.F;

    EditText vazaoText, velocidadeText;
    Spinner spinner;
    Button calcularButton;
    TextView volumeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vazaoText = (EditText) findViewById(R.id.text_vazao);
        velocidadeText = (EditText) findViewById(R.id.text_velocidade);
        spinner = (Spinner) findViewById(R.id.spinner_distancia_bicos);
        volumeText = (TextView) findViewById(R.id.text_volume);
        calcularButton = (Button) findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_distancia_bicos, R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distancia = VALORES_DISTANCIA[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                distancia = VALORES_DISTANCIA[0];
            }
        });

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVolume();
            }
        });
    }
    private void calcularVolume(){
        this.velocidade = Float.valueOf(velocidadeText.getText().toString());
        this.vazao = Float.valueOf(vazaoText.getText().toString());

        this.volume = FATOR_CONVERSAO*vazao;
        this.volume = volume/(velocidade*distancia);

        float volumeAlqueire = this.volume*2.4F;
        String text = String.format("%.3f (L/ha)\n%.3f(L/alq)", volume, volumeAlqueire);
        this.volumeText.setText(text);
    }
}
