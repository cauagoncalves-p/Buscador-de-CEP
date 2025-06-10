import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void GerarArquivo(Endereco retornoCep){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            FileWriter writer = new FileWriter("cep.json");
            writer.write(gson.toJson(retornoCep));
            writer.close();
        }catch (IOException e){
            System.out.println("Não consegui gerar seu arquivo");
            System.out.println("Fim do programa.");
        }
    }
}
