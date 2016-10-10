package br.com.leticia.combo3.app;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.leticia.combo3.R;


public class SphashActivity extends AppCompatActivity implements Runnable{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sphash);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    @Override
    public void run (){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}