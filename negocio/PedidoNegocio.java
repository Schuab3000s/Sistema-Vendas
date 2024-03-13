package negocio;

import java.time.LocalDate;
import java.util.List;

import bancoDados.Banco;
import entidades.Cupom;
import entidades.Pedido;
import entidades.Produto;

/**
 * Classe para manipular a entidade {@link Pedido}.
 * 
 * @author schuab
 */
public class PedidoNegocio {

    /**
     * Banco de dados para armazenar e acessar os pedidos.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para armazenar e acessar os pedidos.
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo pedido.
     * 
     * @param novoPedido Pedido a ser armazenado.
     */
    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    /**
     * Salva um novo pedido com cupom de desconto.
     * 
     * @param novoPedido Pedido a ser armazenado.
     * @param cupom Cupom de desconto a ser aplicado.
     */
    public void salvar(Pedido novoPedido, Cupom cupom) {
        LocalDate hoje = LocalDate.now();
        String codigo = String.format("PE%4d%02d%04d", hoje.getYear(), hoje.getMonthValue(), bancoDados.getPedidos().length);
        novoPedido.setCodigo(codigo);
        novoPedido.setCliente(bancoDados.getCliente());
        novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(), cupom));
        bancoDados.adicionarPedido(novoPedido);
        System.out.println("Pedido cadastrado com sucesso.");
    }

    /**
     * Calcula o total do pedido, aplicando o desconto do cupom, se fornecido.
     * 
     * @param produtos Lista de produtos no pedido.
     * @param cupom Cupom de desconto a ser aplicado.
     * @return O total do pedido.
     */
    private double calcularTotal(List<Produto> produtos, Cupom cupom) {
        double total = produtos.stream().mapToDouble(Produto::calcularFrete).sum();
        return cupom != null ? total * (1 - cupom.getDesconto()) : total;
    }

    /**
     * Exclui um pedido com base no código.
     * 
     * @param codigo Código do pedido a ser excluído.
     */
    public void excluir(String codigo) {
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {
            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                bancoDados.removerPedido(i);
                System.out.println("Pedido excluído com sucesso.");
                return;
            }
        }
        System.out.println("Pedido inexistente.");
    }

    /**
     * Lista todos os pedidos realizados.
     */
    public void listarTodos() {
        Pedido[] pedidos = bancoDados.getPedidos();
        if (pedidos.length == 0) {
            System.out.println("Não existem pedidos cadastrados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
