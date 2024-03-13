package entidades;

/**
 * Classe que representa a entidade cupom. Este pode ser utilizado no ato do
 * fechamento do pedido para obter um desconto, caso desejado.
 * 
 * @author schuab
 */
public class Cupom {

    /**
     * Código descritivo do cupom.
     */
    private String codigo;

    /**
     * Valor em porcentagem do desconto.
     */
    private double desconto;

    /**
     * Construtor do cupom
     * 
     * @param codigo   Código do cupom
     * @param desconto Porcentagem de desconto
     */
    public Cupom(String codigo, double desconto) {
        this.codigo = codigo;
        this.desconto = desconto;
    }

    /**
     * Obtém o código do cupom.
     * 
     * @return O código do cupom.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do cupom.
     * 
     * @param codigo O código do cupom a ser definido.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o desconto do cupom.
     * 
     * @return O desconto do cupom.
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Define o desconto do cupom.
     * 
     * @param desconto O desconto do cupom a ser definido.
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
