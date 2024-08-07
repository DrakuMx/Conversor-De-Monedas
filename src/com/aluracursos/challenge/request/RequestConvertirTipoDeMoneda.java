package com.aluracursos.challenge.request;

import com.aluracursos.challenge.records.Conversor;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestConvertirTipoDeMoneda {
    public Conversor convertirMonedaXMoneda(String moneda1, String moneda2) {
        String YourApiKey = "YOUR_API_KEY";
        String solicitudConvertir = "/pair/"+ moneda1 + "/" + moneda2;

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + YourApiKey + solicitudConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre ese tipo de Moneda.");
        }
    }
}
