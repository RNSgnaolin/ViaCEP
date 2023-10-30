package cepapi.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cepapi.models.Endereco;
import cepapi.models.Model;
import cepapi.service.json.ReaderWriter;

public class Request {

    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Endereco search(String query) {

        try {
            ReaderWriter document = new ReaderWriter("enderecos.json");
            URI viacep = URI.create("https://viacep.com.br/ws/" + query + "/json/");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(viacep)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Model model = gson.fromJson(response.body(), Model.class);

            document.out.write(gson.toJson(model));
            document.out.close();

            return new Endereco(model);
        } catch (IOException e) {
            System.err.println("Erro inesperado: " + e);
            return null;
        } catch (InterruptedException e) {
            System.err.println("Operação interrompida: " + e);
            Thread.currentThread().interrupt();
            return null;
        }

    }

}
