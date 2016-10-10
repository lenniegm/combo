package br.com.leticia.combo3.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import br.com.leticia.combo3.R;

public class NovoPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_pedido);
    }

    //metodo que chama a pagina CardapioPizza
    public void chamaCardapioPizza(View v) {
        Intent i = new Intent(this, CardapioPizzaActivity.class);
        startActivity(i);

    }

    //metodo que chama a pagina CardapioBebida
    public void chamaCardapioBebida(View v) {
        Intent i = new Intent(this, CardapioBebidaActivity.class);
        startActivity(i);

    }

    //metodo que chama a pagina CardapioSobremesa
    public void chamaCardapioSobremesa(View v) {
        Intent i = new Intent(this, CardapioSobremesaActivity.class);
        startActivity(i);

    }

    //chama o memu para add novo pedido no carrinho
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //infla o menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menunovopedido,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId())
        {
            case R.id.action_acao1:

             break;
            case R.id.action_acao2:

            break;
        }

        return super.onOptionsItemSelected(item);
    }



}

