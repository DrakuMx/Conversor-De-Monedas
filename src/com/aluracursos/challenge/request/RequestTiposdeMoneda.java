package com.aluracursos.challenge.request;

import com.aluracursos.challenge.records.TipoDeMonedas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestTiposdeMoneda {
    public TipoDeMonedas DatosMonedas (String moneda) {
        String YourApiKey = "YOUR_API_KEY";
        String solicitudConvertir = moneda;

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + YourApiKey + "/latest/" + solicitudConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeMonedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre ese tipo de Moneda.");
        }
    }
}
