package bancoDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entidades.Caderno;
import entidades.Cliente;
import entidades.Cupom;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;

/**
 * Classe responsável por simular um banco de dados. Esta faz as inserções e
 * exclusões da
 * aplicação. Atualizações não são permitidas para facilitar o funcionamento da
 * aplicação.
 * 
 * @author schuab
 */

public class Banco {

    /**
     * Lista que armazena os produtos(livros e cadernos) cadastrados.
     */
    private List<Produto> produtos;

    /**
     * Lista que armazena os pedidos cadastrados.
     */
    private List<Pedido> pedidos;

    /**
     * Lista que armazena os cupons disponíveis.
     */
    private List<Cupom> cupons;

    /**
     * Cliente cadastrado.
     */
    private Cliente cliente;

    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cliente = new Cliente();

        this.cupons = new ArrayList<>();
        cupons.add(new Cupom("CUPOM2", 2));
        cupons.add(new Cupom("CUPOM5", 5));
        cupons.add(new Cupom("CUPOM10", 10));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cupom[] getCupons() {
        return cupons.toArray(new Cupom[cupons.size()]);
    }

    public Pedido[] getPedidos() {
        return pedidos.toArray(new Pedido[pedidos.size()]);
    }

    public Produto[] getProdutos() {
        return produtos.toArray(new Produto[produtos.size()]);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(int posicao) {
        pedidos.remove(posicao);
    }

    public void adicionarCupom(Cupom cupom) {
        cupons.add(cupom);
    }

    public void removerCupom(Cupom cupom) {
        cupons.remove(cupom);
    }

    /**
     * Consulta um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto.
     * @return Optional contendo o produto encontrado, se existir.
     */
    public Optional<Produto> consultarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    /**
     * Consulta um pedido pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do pedido.
     * @return Optional contendo o pedido encontrado, se existir.
     */
    public Optional<Pedido> consultarPedidoPorCodigo(String codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(pedido);
            }
        }
        return Optional.empty();
    }

    public List<Livro> consultarLivroPorNome(String nome) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof Livro && ((Livro) produto).getNome().equalsIgnoreCase(nome)) {
                livrosEncontrados.add((Livro) produto);
            }
        }
        return livrosEncontrados;
    }

    public List<Caderno> consultarCadernoPorMateria(String materia) {
        List<Caderno> cadernosEncontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof Caderno && ((Caderno) produto).getMateria().equalsIgnoreCase(materia)) {
                cadernosEncontrados.add((Caderno) produto);
            }
        }
        return cadernosEncontrados;
    }

    public Optional<Cliente> consultarClientePorCPF(String cpf) {
        for (Cliente clientes : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

}
