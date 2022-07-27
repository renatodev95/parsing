package utils;

public class MoedaUtil {

    public static String formataValor(Double d) {
        return "R$ " + d.toString().replace(".", ",");
    }
}
