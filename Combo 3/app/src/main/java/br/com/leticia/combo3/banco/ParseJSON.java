package br.com.leticia.combo3.banco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Leticia on 01/10/2016.


public class ParseJSON {
    public static String[] codigos;
    public static String[] camposCPF;
    public static String[] camposSenha;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_CODIGO = "codigo";
    public static final String KEY_CPF = "campoCPF";
    public static final String KEY_SENHA = "campoSenha";

    private JSONArray usuarios = null;

    private String json;
    public ParseJSON(String json) {
        this.json = json;
    }

    @Override
    protected void parseJSON(){
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(json);
            usuarios = jsonObject.getJSONArray(JSON_ARRAY);

            codigos = new String [usuarios.length()];
            camposCPF = new String[usuarios.length()];
            camposSenha = new String [usuarios.length()];

            for (int i = 0; i<usuarios.length(); i++){
                JSONObject jo = usuarios.getJSONObject(i);
                codigos[i] = jo.getString(KEY_CODIGO);
                camposCPF[i] = jo.getString(KEY_CPF);
                camposSenha[i] = jo.getString(KEY_SENHA);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
 */