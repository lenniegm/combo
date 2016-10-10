package br.com.leticia.combo3.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


import br.com.leticia.combo3.R;

public class ComplementosBebidaActivity extends AppCompatActivity {

    NumberPicker noPicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complementosbebida);

                noPicker = (NumberPicker)findViewById(R.id.numQuantidade);
                noPicker.setMaxValue(10);
                noPicker.setMinValue(1);
                noPicker.setWrapSelectorWheel(true);

        //menssagem de alerta
                Button btnConcluir = (Button) findViewById(R.id.btnConcluir);//declara o botao
                btnConcluir.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                    // mensagem inicial do alerta
                    String msgAlerta = " ";

                      // EditText meuProduto = (EditText) findViewById(R.id.titulo);
                      //  String textoDoMeuProduto = meuProduto.getText().toString();

                   // EditText txtProduto = meuProduto;

                    //numberPicker
                    NumberPicker meunumberPicker = (NumberPicker) findViewById(R.id.numQuantidade);
                    Integer quantDoMeuNumPicker = meunumberPicker.getValue();

                    //campo observação
                    EditText meuEditText = (EditText) findViewById(R.id.campoObservacao);
                    String textoDoMeuEditText = meuEditText.getText().toString();

                    //valor total
                    TextView meuEditTextTotal = (TextView) findViewById(R.id.edtTotal);
                    String valorDomeuEditText = meuEditTextTotal.getText().toString();

                    //mostra o pedido
                    msgAlerta += "\nQuantidade : "+ quantDoMeuNumPicker +"\n" + textoDoMeuEditText;



                //---------------
                // configurando alerta
                    AlertDialog.Builder builder = new AlertDialog.Builder(ComplementosBebidaActivity.this);
                    builder.setIcon(R.mipmap.ic_alerta);
                    builder.setTitle("Seu pedido está correto?"); //tipo de mensagem
                    builder.setMessage(msgAlerta); // mensagem do alerta

                    builder.setCancelable(false);//desabilita a opção de cancelar o alerta, clicando fora da menssagem

                    //botao sim
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"Pedido Enviado!", Toast.LENGTH_LONG).show();
                        finish();
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        }
                    }); //botao sim, caso o pedido esteja correto e a pessoa deseja enviar o pedido pra cozinha

                    //botao não
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"Pedido Incompleto!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido cancelado
                        }
                    }); // botao não, caso o pedido ainda não esteja completo e o usuario ainda queira pedir mais alguma coisa
                        builder.show();//faz aparecer o alerta

                }
            });
        //----
        //botao cancelar
                Button btnCancelar = (Button) findViewById(R.id.btnCancelar);//declara o botao
                btnCancelar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                        AlertDialog.Builder builder = new AlertDialog.Builder(ComplementosBebidaActivity.this);
                        builder.setIcon(R.mipmap.ic_alerta);
                        builder.setTitle("Deseja realmente cancelar?"); //tipo de mensagem

                        builder.setCancelable(false);//desabilita a opção de cancelar o alerta, clicando fora da menssagem

                        //botão sim
                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {//cancela o pedido

                            Toast.makeText(getApplicationContext(),"Pedido Cancelado!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido cancelado
                            finish();//finaliza a activity ComplementospizzaActivity e volta para a HomeActivity
                        }
                    });

                        //botao nao
                        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {//continua a fazer o pedido

                            Toast.makeText(getApplicationContext(),"Pedido Incompleto!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido incompleto
                        }
                    }); // botao não, caso o pedido ainda não esteja completo e o usuario ainda queira pedir mais alguma coisa

                builder.show();//faz aparecer o alerta
            }
        });


    }
}
