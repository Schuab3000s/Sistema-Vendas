package console;

import java.util.List;
import java.util.Optional;

import bancoDados.Banco;
import entidades.Caderno;
import entidades.Cliente;
import entidades.Cupom;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;
import negocio.ClienteNegocio;
import negocio.PedidoNegocio;
import negocio.ProdutoNegocio;
import utilidades.LeitoraDados;

/**
 * Classe responsável por controlar a execução da aplicação.
 * 
 * @author schuab
 */

public class Start {

    private static Cliente clienteLogado = null;

    private static Banco banco = new Banco();

    private static ClienteNegocio clienteNegocio = new ClienteNegocio(banco);
    private static PedidoNegocio pedidoNegocio = new PedidoNegocio(banco);
    private static ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

    /**
     * Método utilitário para inicializar a aplicação.
     * 
     * @param args Parâmetros que podem ser passados para auxiliar na execução.
     */
    public static void main(String[] args) {

        System.out.println("Bem vindo ao e-Compras");

        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar Novo Usuário");
        System.out.println("2 - Fazer Login");
        System.out.println("3 - Sair");

        String opcao = LeitoraDados.lerDado();

        switch (opcao) {
            case "1":
                Cliente novoCliente = LeitoraDados.lerNovoCliente();
                clienteNegocio.salvar(novoCliente);
                clienteLogado = novoCliente;
                break;
            case "2":
                System.out.println("Digite o CPF:");
                String cpf = LeitoraDados.lerDado();
                identificarUsuario(cpf);
                break;
            case "3":
                System.out.println("Aplicação encerrada.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        
        System.out.println("Bem vindo ao e-Compras");

        String opcao2 = "";

        while (true) {

            if (clienteLogado == null) {

                System.out.println("Digite o cpf:");

                String cpf = "";
                cpf = LeitoraDados.lerDado();

                identificarUsuario(cpf);
            }

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            System.out.println("3 - Cadastrar Caderno");
            System.out.println("4 - Excluir Caderno");
            System.out.println("5 - Fazer pedido");
            System.out.println("6 - Excluir pedido");
            System.out.println("7 - Listar produtos");
            System.out.println("8 - Listar pedidos");
            System.out.println("9 - Deslogar");
            System.out.println("10 - Sair");
            System.out.println("11 - Consultar Livro por Nome");
            System.out.println("12 - Consultar Caderno por Matéria");
            System.out.println("13 - Consultar Pedido por código");

            opcao2 = LeitoraDados.lerDado();

            switch (opcao2) {
                case "1":
                    Livro livro = LeitoraDados.lerLivro();
                    produtoNegocio.salvar(livro);
                    break;
                case "2":
                    System.out.println("Digite o código do livro");
                    String codigoLivro = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoLivro);
                    break;
                case "3":
                    Caderno caderno = LeitoraDados.lerCaderno();
                    produtoNegocio.salvar(caderno);
                    break;
                case "4":
                    System.out.println("Digite o código do caderno");
                    String codigoCaderno = LeitoraDados.lerDado();
                    produtoNegocio.excluir(codigoCaderno);
                    break;
                case "5":
                    List<Produto> produtos = List.of(banco.getProdutos());  // Obtendo a lista de produtos do banco
                    Pedido pedido = LeitoraDados.lerPedido(produtos);       // Passando a lista de produtos para o método
                    Optional<Cupom> cupom = LeitoraDados.lerCupom(banco);   // lerPedido
                    PedidoNegocio.aplicarCupomEquivocado(banco, pedido, cupom);
                    break;

                case "6":
                    System.out.println("Digite o código do pedido");
                    String codigoPedido = LeitoraDados.lerDado();
                    pedidoNegocio.excluir(codigoPedido);
                    break;
                case "7":
                    produtoNegocio.listarTodos();
                    break;
                case "8":
                    pedidoNegocio.listarTodos();
                    break;
                case "9":
                    System.out.println(String.format("Volte sempre %s!", clienteLogado.getNome()));
                    clienteLogado = null;
                    break;
                case "10":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                case "11":
                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = LeitoraDados.lerDado();
                    produtoNegocio.consultarLivroPorNome(nomeLivro);
                    break;
                case "12":
                    System.out.println("Digite a matéria do caderno:");
                    String materiaCaderno = LeitoraDados.lerDado();
                    produtoNegocio.consultarCadernoPorMateria(materiaCaderno);
                    break;
                case "13":
                    System.out.println("Digite o código do pedido:");
                    String codigoPedido2 = LeitoraDados.lerDado();
                    pedidoNegocio.consultarPedidoPorCodigo(codigoPedido2);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    /**
     * Procura o usuário na base de dados.
     * 
     * @param cpf CPF do usuário que deseja logar na aplicação
     */
    private static void identificarUsuario(String cpf) {

        Optional<Cliente> resultado = clienteNegocio.consultar(cpf);

        if (resultado.isPresent()) {

            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.exit(0);
        }
    }
}