package br.com.alura.agendaalura;

import java.io.PrintStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class WebClient {

    public String post(String json){

        try {
            URL url = new URL("https://www.caelum.com.br/mobile");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-type", "application/json");

            connection.setDoInput(true);
            connection.setDoOutput(true);

            PrintStream saida = new PrintStream(connection.getOutputStream());
            saida.print(json);

            connection.connect();

            String resposta = new Scanner(connection.getInputStream()).next();

            return  resposta;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
