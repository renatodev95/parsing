package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dtos.ProdutoDto;
import dtos.ProdutoKabumDto;
import enums.Links;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    public List<ProdutoDto> obterProdutos() throws IOException {
        List<ProdutoDto> lista = new ArrayList<>();
        for (Links link : Links.values()) {
            Document document = Jsoup.connect(link.getEnderecoWeb()).get();
            String json = document.html();
            String stringFinal = "\"scriptLoader\":[]}";
            int lastIndex = stringFinal.length();
            JsonNode node = JsonUtil.parse(json.substring(json.indexOf("{\"props\""), json.indexOf(stringFinal) + lastIndex).trim());
            ProdutoKabumDto produtoKabum = JsonUtil.fromJson(node, ProdutoKabumDto.class);
            String nomeProduto = produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getName();
            double precoProduto = produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getPrice();
            lista.add(new ProdutoDto(nomeProduto, precoProduto));
        }
        return lista;
    }
}
