package br.com.leticia.combo3.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.leticia.combo3.R;
import br.com.leticia.combo3.banco.CustomRequest;


public class LoginActivity extends AppCompatActivity {

    private Button botaoLogin;
    private EditText campoLogin;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //declaração dos componentes
        botaoLogin = (Button) findViewById(R.id.botaoLogin);
        campoLogin = (EditText) findViewById(R.id.edtLogin);
        campoSenha = (EditText) findViewById(R.id.edtSenha);

    }



  /*  private void sendRequest() {
        StringRequest stringRequest = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this, ParseJSON.codigos, ParseJSON.camposCPF, ParseJSON.camposSenha);
        listView.setAdapter(cl);
    }

    @Override
    public void onClick(View v){
        sendRequest();
    }  */


    ///-------


    //esse aki faz parte do codigo
    public void verificaLogin(View v) {//verifica o CPF e a senha

        logar(getApplicationContext(),campoLogin.getText().toString(),campoSenha.getText().toString());//chama metodo logar, onde realiza ou nao a conexao


    }
/*
    botaoLogin.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v) {
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                // fetch data
            } else {
                Toast.makeText(getApplicationContext(),"Nenhuma conexão foi detectada!", Toast.LENGTH_LONG).show();
            }
        }

    });
  }
*/


//----

             public void logar(final Context vContext, String login, String senha) { //testa a conexão
        // se a conexao for = true, execulta onResponse
        //se a conexao for = false, execulta onErrorResponse

        // atribuição dos parametros que serão enviados via POST ao webservices
        Map<String, String> par = new HashMap<>();

        {
            par.put("Login", String.valueOf(login));//parametro recebido pelo java
            par.put("senha", String.valueOf(senha));//parametro recebido pelo java

            JSONObject parameters = new JSONObject(par);

            // criação de um novo request
            CustomRequest jsonObjReq = new CustomRequest(Request.Method.GET,
                    "http://192.168.20.1:8080/ComboTres/rest/login", par, //endereço do banco
                    new Response.Listener<JSONArray>() {
                        //
                         // dentro do metodo on response, é que podemos tratar o codigo que deve ser executano, em nosso caso,
                         // estamos limpando os marcadores do mapa, adicionando o marcador na localização atual e adicionando marcadores
                         // referentes a cada registro do banco de dados
                         //
                        @Override
                        public void onResponse(JSONArray response) {//se tiver conexao com o banco

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject e = new JSONObject();
                                try {
                                    //j= é o nome da intent
                                    //nomeQualquer= login ou senha vem do java, leticia
                                    e = response.getJSONObject(i);
                                    if(e.getBoolean("login")){ //se o CPF e a senha estiver certo, abre a pagina MesaActivity
                                        Intent j = new Intent(vContext, MesaActivity.class);//abre a pagina MesaActivity
                                        startActivity(j);
                                    }
                                   else{//se o CPF ou a senha estiver errada

                                        //mensagem de erro de CPF ou senha errada
                                        Toast.makeText(getApplicationContext(),"Seu CPF ou senha está incorreta!", Toast.LENGTH_LONG).show();
                                    }

                                } catch (JSONException e1) {

                                }
                            }
                        }
                    }, new Response.ErrorListener() {

                //
                 //se o metodo onResponse nao consegue ser executado, seja por falha de rede, alguma sintaxe errada
                 //nossa requisição é direcionada ao metodo onErrorResponse, aqui podemos gerar um Log, ou até mesmo
                 //tratar as exceptions
                 //
                @Override
                public void onErrorResponse(VolleyError error) {//se nao tiver conexao com banco
                    VolleyLog.d("", "Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),"Nenhuma conexão foi detectada!", Toast.LENGTH_LONG).show();
                }
            });

            // adiciona nossa requisição para a fila de requisições
            Volley.newRequestQueue(vContext).add(jsonObjReq);

        }

    }

}

