package amst4.t12020.espol.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class preguntas extends AppCompatActivity {

    ImageView pelicula;
    TextView pregunta;
    Button pregunta1;
    Button pregunta2;
    Button pregunta3;
    Button pregunta4;

    ArrayList<Trivia> listaPreguntas;

    Trivia actual;
    int contador=0;
    Boolean termino = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        listaPreguntas = new ArrayList<>();

        pelicula = findViewById(R.id.imgPelicula);
        pregunta = findViewById(R.id.txtPregunta);
        pregunta1 = findViewById(R.id.btnResp1);
        pregunta2 = findViewById(R.id.btnResp2);
        pregunta3 = findViewById(R.id.btnResp3);
        pregunta4 = findViewById(R.id.btnResp4);

        llenarTrivias();

        actual = presentarPreguntaRandom();
        cargarPreguntaAPantalla(actual);


        pregunta1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                respuesta1();
            }
        });

        pregunta2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                respuesta2();
            }
        });

        pregunta3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                respuesta3();
            }
        });

        pregunta4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                respuesta4();
            }
        });
    }

    public void respuesta1(){
        actual.setRespuesta(true);
        actual.setContestada(true);

        contador++;

        if(contador>4){
            Intent intent = new Intent(this, Hasganado.class);
            startActivity(intent);
        }else{

            actual = presentarPreguntaRandom();
            while (actual==null){
                actual = presentarPreguntaRandom();
            }
            cargarPreguntaAPantalla(actual);
        }
    }

    public void respuesta2(){

        Intent intent = new Intent(this, Hasperdido.class);
        intent.putExtra("contestadas",contador);
        startActivity(intent);

    }

    public void respuesta3(){

        Intent intent = new Intent(this, Hasperdido.class);
        intent.putExtra("contestadas",contador);
        startActivity(intent);
    }

    public void respuesta4(){

        Intent intent = new Intent(this, Hasperdido.class);
        intent.putExtra("contestadas",contador);
        startActivity(intent);
    }



    public void cargarPreguntaAPantalla(Trivia pregunta){
        Uri imgUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + pregunta.getUrl());
        this.pelicula.setImageURI(imgUri);
        this.pregunta.setText(pregunta.getPregunta());
        this.pregunta1.setText(pregunta.getResp1());
        this.pregunta2.setText(pregunta.getResp2());
        this.pregunta3.setText(pregunta.getResp3());
        this.pregunta4.setText(pregunta.getResp4());
    }

    public Trivia presentarPreguntaRandom() {
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;

        Trivia actual = listaPreguntas.get(n);

        if (actual.getContestada() == false) {
            return actual;
        } else{
            return null;
        }
    }


    public void llenarTrivias(){
        Trivia tri1 = new Trivia();
        tri1.setUrl("avenger");
        tri1.setPregunta("Quien muere al final de end game");
        tri1.setResp1("Iron man");
        tri1.setResp2("Hulk");
        tri1.setResp3("Ant man");
        tri1.setResp4("Spider man");
        tri1.setRespuesta(false);

        Trivia tri2 = new Trivia();
        tri2.setUrl("dragon");
        tri2.setPregunta("Como se llama el dragon principal");
        tri2.setResp1("Chimuelo");
        tri2.setResp2("Hippo");
        tri2.setResp3("Pepe el dragon");
        tri2.setResp4("Lol");
        tri2.setRespuesta(false);

        Trivia tri3 = new Trivia();
        tri3.setUrl("increibles");
        tri3.setPregunta("Que poder tiene la señora increible");
        tri3.setResp1("Elasticidad");
        tri3.setResp2("Invisibilidad");
        tri3.setResp3("volar");
        tri3.setResp4("detener el tiempo");
        tri3.setRespuesta(false);

        Trivia tri4 = new Trivia();
        tri4.setUrl("panda");
        tri4.setPregunta("De que color es el panda");
        tri4.setResp1("Blanco y negro");
        tri4.setResp2("Verde y rojo");
        tri4.setResp3("rojo y negro");
        tri4.setResp4("arcoiris");
        tri4.setRespuesta(false);

        Trivia tri5 = new Trivia();
        tri5.setUrl("spiderman");
        tri5.setPregunta("Como obtuvo los poderes Miles Morales");
        tri5.setResp1("Le pico una araña radioactiva");
        tri5.setResp2("Se cayo en desperdicios toxicos");
        tri5.setResp3("Le cayo un rayo");
        tri5.setResp4("Comio una empanada caducada");
        tri5.setRespuesta(false);

        listaPreguntas.add(tri1);
        listaPreguntas.add(tri2);
        listaPreguntas.add(tri3);
        listaPreguntas.add(tri4);
        listaPreguntas.add(tri5);
    }



}