import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConverteValor {
     public Moeda convertMoeda(String moeda){
         String conexao = "https://v6.exchangerate-api.com/v6/dc1b76696213cc66103e5bf5/latest/" + moeda;
         try{
             HttpClient client = HttpClient.newBuilder().build();
             HttpRequest request = HttpRequest.newBuilder().uri(URI.create(conexao)).build();
             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             return new Gson().fromJson(response.body(), Moeda.class);
         }catch (InterruptedException | IOException e) {
             throw new RuntimeException("Falha ao executar a operação", e);
         }
     }
}
