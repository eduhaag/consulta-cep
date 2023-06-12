import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.com.eh.buscaCep.models.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

public class API {
    private String API_ADDRESS = "https://viacep.com.br/ws/";
    private String FORMAT = "json";
    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    public Address getAddress(String cep)  {
        URI uri = URI.create(API_ADDRESS + cep + "/" + FORMAT);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = null;

        try {
             response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel obter o endereço.");
        }

        Address address = gson.fromJson(response.body(), Address.class);


        return  address;
    }
}
