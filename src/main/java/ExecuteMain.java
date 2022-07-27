import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dtos.ProdutoKabum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import shared.Links;

import java.io.IOException;

public class ExecuteMain {
    public static void main(String[] args) throws IOException {
        
        double total = 0;
        
        for (Links link : Links.values()) {
            Document document = Jsoup.connect(link.getEnderecoWeb()).get();
            String json = document.html();
            String stringFinal = "\"scriptLoader\":[]}";
            int lastIndex = stringFinal.length();
            JsonNode node = Json.parse(json.substring(json.indexOf("{\"props\""), json.indexOf(stringFinal) + lastIndex).trim());
            ProdutoKabum produtoKabum = Json.fromJson(node, ProdutoKabum.class);
            System.out.println(produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getName());
            System.out.println(produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getPrice());
            total += produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getPrice();
        }
        System.out.println();
        System.out.println("TOTAL: " + total);
    }
}
