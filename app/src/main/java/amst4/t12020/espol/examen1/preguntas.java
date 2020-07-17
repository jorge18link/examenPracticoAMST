package amst4.t12020.espol.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class preguntas extends AppCompatActivity {

    ImageView pelicula;
    TextView pregunta;
    Button pregunta1;
    Button pregunta2;
    Button pregunta3;
    Button pregunta4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        pelicula = findViewById(R.id.imgPelicula);
        pregunta = findViewById(R.id.txtPregunta);
        pregunta1 = findViewById(R.id.btnResp1);
        pregunta2 = findViewById(R.id.btnResp2);
        pregunta3 = findViewById(R.id.btnResp3);
        pregunta4 = findViewById(R.id.btnResp4);
    }


}