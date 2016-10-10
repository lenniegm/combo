package br.com.leticia.combo3.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.leticia.combo3.R;

public class MesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mesa);


    }

    //metodo que chama a pagina home
    public void chamaHome(View v) {
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);

    }



}
