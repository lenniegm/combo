package br.com.leticia.combo3.banco;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
/*
public class Conexao {

    public static  String postDados(String urlCPF, String parametrosCPF){
        URL url;
        HttpsURLConnection connection = null;//faz conexao com a rede

        try { //faz conexao

            url = new URL(urlCPF);
            connection = (HttpsURLConnection) url.openConnection();//abre a conexao

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//tipo de parameto que vai receber

            connection.setRequestProperty("Content-Lenght", "" + Integer.toString(parametrosCPF.getBytes().length));//tamanho em bytes

            connection.setRequestProperty("Content-Language", "pt-BR");//idioma da solicitação da comunicação

            connection.setUseCaches(false);//usa a conexao em tempo real, nao armazena nada
            connection.setDoInput(true);//habilita a entrada de dados
            connection.setDoOutput(true);//habilita a saida de dados

            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());//armazena os dados que ira sair
            dataOutputStream.writeBytes(parametrosCPF);
            dataOutputStream.flush();
            dataOutputStream.close();

            InputStream inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String linha;
            StringBuffer resposta = new StringBuffer();

            while ((linha = bufferedReader.readLine()) != null) {//enquanto tiver informação, ira continuar lendo

                resposta.append(linha);
                resposta.append('\r');

            }

            bufferedReader.close();

            return resposta.toString();

        }catch (Exception erro){

            return null;
        }finally {

            if(connection != null){ //desconecta
                    connection.disconnect();
            }

        }
    }
}
*/