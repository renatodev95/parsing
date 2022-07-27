import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dtos.ProdutoKabumDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import pojos.AuthorPOJO;
import pojos.BooksPOJO;
import pojos.DayPOJO;
import pojos.SimpleTestCaseJsonPOJO;
import enums.Links;
import utils.JsonUtil;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private final String simpleTestCaseJsonSource = "{\n" +
            "  \"title\":\"Coder From Scratch\",\n" +
            "  \"author\":\"Rui\"\n" +
            "}";
    
    private final String dayScenario1 = "{\n" +
            "  \"date\": \"2019-12-25\",\n" +
            "  \"name\": \"Christmas Day\"\n" +
            "}";
    
    private final String authorBookScenario = "{\n" +
            "  \"authorName\": \"Rui\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inPrint\": true,\n" +
            "      \"publishDate\": \"2019-12-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inPrint\": false,\n" +
            "      \"publishDate\": \"2019-01-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    
    @Test
    void parse() throws JsonProcessingException {
        JsonNode node = JsonUtil.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "Coder From Scratch");
    }

    @Test
    void fromJson() throws JsonProcessingException {
        JsonNode node = JsonUtil.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = JsonUtil.fromJson(node, SimpleTestCaseJsonPOJO.class);
        assertEquals(pojo.getTitle(), "Coder From Scratch");
    }

    @Test
    void toJson() {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Testing 123");
        JsonNode node = JsonUtil.toJson(pojo);
        assertEquals(node.get("title").asText(), "Testing 123");
    }

    @Test
    void stringfy() throws JsonProcessingException {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Testing 123");
        JsonNode node = JsonUtil.toJson(pojo);
        System.out.println(JsonUtil.stringfy(node));
        System.out.println(JsonUtil.prettyPrint(node));
    }

    @Test
    void dayTestScenario1() throws JsonProcessingException {
        JsonNode node = JsonUtil.parse(dayScenario1);
        DayPOJO pojo = JsonUtil.fromJson(node, DayPOJO.class);
        assertEquals("2019-12-25", pojo.getDate().toString());
    }

    @Test
    void authorBookTestScenario1() throws JsonProcessingException {
        JsonNode node = JsonUtil.parse(authorBookScenario);
        AuthorPOJO pojo = JsonUtil.fromJson(node, AuthorPOJO.class);
        System.out.println("Author" + pojo.getAuthorName());
        for (BooksPOJO book : pojo.getBooks()) {
            System.out.println("Book: " + book.getTitle());
            System.out.println("Is in Print? " + book.getInPrint());
            System.out.println("Date: " + book.getPublishDate());
        }
    }
    
    @Test
    void testEnum() throws IOException {
        Document document = Jsoup.connect(Links.FONTE.getEnderecoWeb()).get();
        String json = document.html();
        String stringFinal = "\"scriptLoader\":[]}";
        int lastIndex = stringFinal.length();
        JsonNode node = JsonUtil.parse(json.substring(json.indexOf("{\"props\""), json.indexOf(stringFinal) + lastIndex).trim());
        ProdutoKabumDto produtoKabum = JsonUtil.fromJson(node, ProdutoKabumDto.class);
        System.out.println(produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getName());
        System.out.println(produtoKabum.getProps().getPageProps().getInitialZustandState().getDescriptionProduct().getPrice());
    }
}