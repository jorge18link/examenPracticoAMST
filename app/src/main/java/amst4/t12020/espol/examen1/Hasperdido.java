package amst4.t12020.espol.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Hasperdido extends AppCompatActivity {

    TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasperdido);
        Intent intent = getIntent();
        data.setText("Haz contestado "+intent.getStringExtra("contestadas")+" preguntas correctamente");
    }
}