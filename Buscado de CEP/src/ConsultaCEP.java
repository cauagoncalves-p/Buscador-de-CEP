import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

   public Endereco buscacep(String cep){
       String buscaCep = "https://viacep.com.br/ws/" + cep + "/json/";
       HttpRequest request = HttpRequest.newBuilder().uri(URI.create(buscaCep)).build();
       try {
           HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
           String json = response.body();
           return new Gson().fromJson(json, Endereco.class);
       } catch (Exception e) {
           throw new RuntimeException("Não consegui obter atraves desse cep");
       }
   }
}
