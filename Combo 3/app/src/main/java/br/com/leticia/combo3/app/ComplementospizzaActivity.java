package br.com.leticia.combo3.app;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.leticia.combo3.R;

public class ComplementospizzaActivity extends AppCompatActivity {

    NumberPicker noPicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complementospizza);

        //quantidade de pizza
            noPicker = (NumberPicker)findViewById(R.id.numQuantidade);
            noPicker.setMaxValue(10);
            noPicker.setMinValue(1);
            noPicker.setWrapSelectorWheel(false);

        //menssagem de alerta
            Button btnConcluir = (Button) findViewById(R.id.btnConcluir);//declara o botao
            btnConcluir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // mensagem inicial do alerta
               //String msgAlerta = "Seu pedido está correto?";
                String msgAlerta = "";

                //nome da pizza
                //String nomePizza = ();

                // capturando valores dos campos da tela

                //spinner borda
                Spinner meuspinnerB = (Spinner) findViewById(R.id.spnBorda);
                Object bordaDoMeuSpinnerB = meuspinnerB.getSelectedItem();

                //spinner tamanho
                Spinner meuspinnerT = (Spinner) findViewById(R.id.spnTamanho);
                Object tamanhoDoMeuSpinnerT = meuspinnerT.getSelectedItem();

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
                msgAlerta += "\nBorda : " + bordaDoMeuSpinnerB + "\nTamanho : " + tamanhoDoMeuSpinnerT + "\nQuantidade : "+ quantDoMeuNumPicker +"\n" + textoDoMeuEditText;


                //---------------
                // configurando alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(ComplementospizzaActivity.this);
                builder.setIcon(R.mipmap.ic_alerta);
                builder.setTitle("Seu pedido está correto?"); // título do alerta
                builder.setMessage(msgAlerta); // mensagem do alerta
                //builder.setMessage(titulo(positicao));//
                builder.setCancelable(false);//desabilita a opção de cancelar o alerta, clicando fora da menssagem

                //botão sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"Pedido Enviado!", Toast.LENGTH_LONG).show();
                        finish();
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);

                        ;
                    }
                }); //botao sim, caso o pedido esteja correto e a pessoa deseja enviar o pedido pra cozinha

                //botão nao
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"Pedido Incompleto!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido cancelado

                    }
                }); // botao não, caso o pedido ainda não esteja completo e o usuario ainda queira pedir mais alguma coisa
                builder.show();//faz aparecer o alerta

            }
        });

    //------
        //botao cancelar
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);//declara o botao
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AlertDialog.Builder builder = new AlertDialog.Builder(ComplementospizzaActivity.this);
                builder.setIcon(R.mipmap.ic_alerta);
                builder.setTitle("Deseja realmente cancelar?"); //tipo de mensagem

                builder.setCancelable(false);//desabilita a opção de cancelar o alerta, clicando fora da menssagem

                //botao sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//cancela o pedido

                        Toast.makeText(getApplicationContext(),"Pedido Cancelado!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido cancelado
                        finish();//finaliza a activity ComplementospizzaActivity e volta para a HomeActivity

                    }
                });

                //botao não
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {//continua a fazer o pedido

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"Pedido Incompleto!", Toast.LENGTH_LONG).show();//mostra mensagem de pedido incompleto
                    }
                }); // botao não, caso o pedido ainda não esteja completo e o usuario ainda queira pedir mais alguma coisa

                builder.show();//faz aparecer o alerta
            }
        });
    }
    //----
        //botao adicionar
        public void chamaCarrinho(View v) {
        Intent i = new Intent(this, NovoPedidoActivity.class);
        startActivity(i);

    }



}