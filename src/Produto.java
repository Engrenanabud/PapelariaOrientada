public class Produto {

    private String nome;
    private String marca;
    private int id;
    private double valor;


    public Produto() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public String toString(){

        return "Produto Cadastrado: " + "\nNome do Produto: " + nome + "\nMarca: " + marca + "\nid: " + id + "\nValor: " + String.format("\nR$ %.2f \n", valor );
    }

}

