package entidades;

/**
 * Classe que representa a abstração dos produtos que podem ser vendidos pela loja.
 * 
 * @author schuab
 */
public abstract class Produto {

    /**
     * Código de identiticação do produto.
     */
    private String codigo;

    /**
     * Valor unitário do produto.
     */
    private double preco;

    /**
     * Quantidade comprada do produto.
     */
    private int quantidade;

    public Produto() {
    }

    /**
     * Obtém o código de identificação do produto.
     * 
     * @return O código de identificação do produto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código de identificação do produto.
     * 
     * @param codigo O código de identificação do produto a ser definido.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o valor unitário do produto.
     * 
     * @return O valor unitário do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o valor unitário do produto.
     * 
     * @param preco O valor unitário do produto a ser definido.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém a quantidade comprada do produto.
     * 
     * @return A quantidade comprada do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade comprada do produto.
     * 
     * @param quantidade A quantidade comprada do produto a ser definida.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Calcula o preço do frete para os produtos comprados. Este cálculo pode variar de acordo com o produto.
     * 
     * @return O valor do frete para o determinado produto.
     */
    public abstract double calcularFrete();
}
