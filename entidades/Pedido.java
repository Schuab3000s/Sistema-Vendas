package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a entidade pedido, que é a compra dos produtos por um cliente.
 * 
 * @author schuab
 */
public class Pedido {

    /**
     * Código do pedido.
     */
    private String codigo;

    /**
     * Cliente associado ao pedido.
     */
    private Cliente cliente;

    /**
     * Lista de produtos comprados no pedido.
     */
    private List<Produto> produtos;

    /**
     * Total do pedido.
     */
    private double total;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Obtém a descrição dos produtos comprados no pedido.
     * 
     * @return A descrição dos produtos comprados no pedido.
     */
    public String getDescricaoProdutos() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("[");
        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                descricao.append(produto.toString());
                descricao.append("Qtd:");
                descricao.append(produto.getQuantidade());
                descricao.append(" ");
            }
        }
        descricao.append("]");
        return descricao.toString();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", produtos=" + getDescricaoProdutos() +
                ", total=" + total +
                '}';
    }
}
