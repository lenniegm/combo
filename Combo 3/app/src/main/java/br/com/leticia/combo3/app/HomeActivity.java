package br.com.leticia.combo3.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.leticia.combo3.R;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


    }

      //chama a tela novo pedido
    public void chamaNovoPedido(View v) {
        Intent i = new Intent(this, NovoPedidoActivity.class);
        startActivity(i);
    }

    //chama a tela historico de consumo
    public void chamaHistorico(View v) {
        Intent i = new Intent(this, HistoricoConsumoActivity.class);
        startActivity(i);
    }


       //chama a tela para finalizar o pedido
    public void chamaFinalizarPedido(View v) {
        Intent i = new Intent(this, FinalizarPedidoActivity.class);
        startActivity(i);

    }
    //impossibilita o cliente de voltar para a tela mesa ou login, na qual somente o funcionario tera acesso
    public void onBackPressed(){
        onDestroy();


                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Alerta!"); // título do alerta
                builder.setMessage("Impossivel voltar!");//mensagem que aparece
                builder.setCancelable(false);//desabilita a opção de cancelar o alerta, clicando fora da menssagem

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Acesso Restrito!", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();//faz aparecer o alerta

            }


    }


