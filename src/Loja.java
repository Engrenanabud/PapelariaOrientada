import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Loja {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        int opcao = 0;

        while (opcao != 4) {

            System.out.println("=====================================================");
            System.out.println("=====================PAPELARIA=======================");
            System.out.println("=====================================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("[1] Para cadastrar produto: ");
            System.out.println("[2] Para Deletar produto: ");
            System.out.println("[3] Buscar produto por nome: ");
            System.out.println("[4] Buscar produto por marca: ");
            System.out.println("[5] Exibir produtos Cadastrados: ");


            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    Produto produtoCriado = CadastrarProduto();
                    System.out.println("Produto Cadastrado com Sucesso \n" + produtoCriado);
                    Estoque.cadastrarProduto(produtoCriado);

                    break;
                case 2:
                     DeletarProduto();
                    break;
                case 3:
                    Produto produtoEncontrado = buscaPorNome();
                    System.out.println("Encontramos o produto: " + produtoEncontrado);

                    break;
                case 4:
                    Produto produtoAchado = buscaPorMarca();
                    System.out.println("Encontramos o produto: " + produtoAchado);

                    break;
                case 5:
                    listarProdutos();

                    break;
                default:
                    System.out.println("Opção Inválida");
            }


        }

    }

    public static Produto CadastrarProduto() {

        Produto produto = new Produto();

        System.out.println("Digite o Nome do Produto: ");
        String nome = scanner.next();
        System.out.println("Digite a marca do produto: ");
        String marca = scanner.next();
        System.out.println("Digite o id: ");
        Integer id = scanner.nextInt();
        System.out.println("Digite o valor: ");
        Double valor = scanner.nextDouble();

        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setId(id);
        produto.setValor(valor);

        return produto;
    }

    public static void DeletarProduto() {

        System.out.println("Digite o id do produto que deseja deletar: ");
        int idProduto = scanner.nextInt();

        List<Produto> produtos = Estoque.buscarProduto();
        Produto produtoDeletado = null;

        for (Produto produto : produtos) {
            if (idProduto == produto.getId()) {
                produtoDeletado = produto;
                break;
            }
        }

        if (produtoDeletado != null) {
            System.out.println("O produto que você deseja deletar é:\n" + produtoDeletado);
            System.out.println("Deseja mesmo deletar esse produto? S/N?");
            scanner.nextLine(); // Consumindo a nova linha
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("n")) {
                produtos.remove(produtoDeletado);
                System.out.println("Produto deletado com sucesso.");
            }
        } else {
            System.out.println("O id do produto não foi encontrado.");
        }

    }


    public static Produto buscaPorNome() {
        System.out.println("Digite o nome do produto que deseja buscar: ");
        String nomeDoProduto = scanner.next();

        for (Produto produtoEncontrado : Estoque.buscarProduto()) {

            if (nomeDoProduto.equals(produtoEncontrado.getNome())) {

                return produtoEncontrado;
            }
        }
        System.out.println("o nome não foi achado.");
        return null;
    }

    public static Produto buscaPorMarca() {
        System.out.println("Digite a marca do produto que deseja buscar: ");
        String nomeDaMarca = scanner.next();

        for (Produto produtoAchado : Estoque.buscarProduto()) {

            if (nomeDaMarca.equals(produtoAchado.getMarca())) {

                return produtoAchado;
            }
        }
        System.out.println("A marca não foi encontrada.");
        return null;
    }

    public static List<Produto> listarProdutos() {

        List<Produto> todasOsProdutos = Estoque.buscarProduto();

        //retorna toda a lista de produtos
        if (!todasOsProdutos.isEmpty()) {
            System.out.println("Todos os Produtos Registrados:");
            for (Produto produtos : todasOsProdutos) {
                System.out.println("Nome: " + produtos.getNome() + " " + "Marca: " + produtos.getMarca() + ", id: " + produtos.getId() + ", Valor: " + produtos.getValor());
            }
        } else {
            System.out.println("Nenhum produto registrado.");
        }
        return todasOsProdutos;
    }
}



