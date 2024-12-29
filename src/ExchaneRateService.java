import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ExchaneRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bac33b7a9ba718ac81d3c8ab/latest/USD";
    public  double getExchangeRate(int opcion) throws IOException, InterruptedException {
        //Obtener datos de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        //Parsear el JSON
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversion = jsonObject.getAsJsonObject("conversion_rates");



        //Determinar el tipo de cambio segun la opcion
        switch (opcion) {
            case 1: // Dolar a peso Argentino
                return conversion.get("ARS").getAsDouble();
            case 2: // Peso argentino a Dolar
                return 1 / conversion.get("ARS").getAsDouble();
            case 3: // Dolar a real Brasileño
                return conversion.get("BRL").getAsDouble();
            case 4: // Real Brasileño a Dolar
                return 1 / conversion.get("BRL").getAsDouble();
            case 5:  // Dolar a Peso Colombiano
                return conversion.get("COP").getAsDouble();
            case 6: // Peso colombiano a Dolar
                return 1/ conversion.get("COP").getAsDouble();
            case 7:  // Dolar a Peso Mexicano
                return conversion.get("MXN").getAsDouble();
            case 8: // Peso Mexicano a Dolar
                return 1/ conversion.get("MXN").getAsDouble();
            default:
                return 0; //opcion no valida

        }
    }

    public String getHistorialJson() throws IOException, InterruptedException {
        // Obtener datos de la API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // Devolver el JSON original (puedes personalizar si es necesario)
        return json;
    }

}


