import java.util.ArrayList;
import java.util.List;

public class Estoque {

 static List<Produto> estoque = new ArrayList<>();

    public static void cadastrarProduto(Produto produto) {
        estoque.add(produto);
    }

    public static List<Produto> buscarProduto() {
        return estoque;
    }

}
