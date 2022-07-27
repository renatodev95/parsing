import dtos.ProdutoDto;
import services.ProdutoService;
import utils.MoedaUtil;

import java.io.IOException;
import java.util.List;

public class ExecuteMain {
    public static void main(String[] args) throws IOException {
        
        ProdutoService service = new ProdutoService();
        List<ProdutoDto> myList = service.obterProdutos();
        System.out.println("TOTAL: " + MoedaUtil.formataValor(myList.stream().map(ProdutoDto::getPrice).reduce(0.0, Double::sum)));
    }
}
