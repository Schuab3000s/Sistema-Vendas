package negocio;

import java.util.List;
import java.util.Optional;

import bancoDados.Banco;
import entidades.Caderno;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;

/**
 * Classe para manipular a entidade {@link Produto}.
 * 
 * @author schuab
 */
public class ProdutoNegocio {

    /**
     * Banco de dados para armazenar e acessar os produtos.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para armazenar e acessar os produtos.
     */
    public ProdutoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo produto (livro ou caderno) na loja.
     * 
     * @param novoProduto Livro ou caderno a ser cadastrado.
     */
    public void salvar(Produto novoProduto) {
        String codigo = String.format("PR%04d", bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        if (buscarProdutoPorCodigo(novoProduto.getCodigo()).isPresent()) {
            System.out.println("Produto já cadastrado.");
            return;
        }

        bancoDados.adicionarProduto(novoProduto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    /**
     * Exclui um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto.
     */
    public void excluir(String codigo) {
        Optional<Produto> produtoOptional = buscarProdutoPorCodigo(codigo);
        if (produtoOptional.isPresent()) {
            bancoDados.removerProduto(produtoOptional.get());
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

    /**
     * Consulta um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto.
     * @return Optional contendo o produto encontrado, se existir.
     */
    public Optional<Produto> consultar(String codigo) {
        return bancoDados.consultarProdutoPorCodigo(codigo);
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarTodos() {
        Produto[] produtos = bancoDados.getProdutos();
        if (produtos.length == 0) {
            System.out.println("Não existem produtos cadastrados.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    /**
     * Busca um produto pelo código de cadastro.
     * 
     * @param codigo Código de cadastro do produto.
     * @return Optional contendo o produto encontrado, se existir.
     */
    private Optional<Produto> buscarProdutoPorCodigo(String codigo) {
        return bancoDados.consultarProdutoPorCodigo(codigo);
    }

    public void consultarLivroPorNome(String nome) {
        List<Livro> livrosEncontrados = bancoDados.consultarLivroPorNome(nome);
        if (!livrosEncontrados.isEmpty()) {
            for (Livro livro : livrosEncontrados) {
                System.out.println(livro);
            }
        } else {
            System.out.println("Nenhum livro encontrado com o nome fornecido.");
        }
    }

    public void consultarCadernoPorMateria(String materia) {
        List<Caderno> cadernosEncontrados = bancoDados.consultarCadernoPorMateria(materia);
        if (!cadernosEncontrados.isEmpty()) {
            for (Caderno caderno : cadernosEncontrados) {
                System.out.println(caderno);
            }
        } else {
            System.out.println("Nenhum caderno encontrado com a matéria fornecida.");
        }
    }

    public void consultarPedidoPorCodigo(String codigo) {
        Optional<Pedido> pedidoOptional = bancoDados.consultarPedidoPorCodigo(codigo);
        if (pedidoOptional.isPresent()) {
            System.out.println("Pedido encontrado: " + pedidoOptional.get());
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

}
