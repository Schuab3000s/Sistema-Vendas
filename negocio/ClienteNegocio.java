package negocio;

import java.util.Optional;

import bancoDados.Banco;
import entidades.Cliente;

/**
 * Classe para manipular a entidade {@link Cliente}.
 * 
 * @author schuab
 */
public class ClienteNegocio {

    private Banco bancoDados;

    /**
     * Construtor.
     * 
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     * 
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {
        if (bancoDados.getCliente().getCpf().equals(cpf)) {
            return Optional.of(bancoDados.getCliente());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Cadastra um novo cliente.
     * 
     * @param cliente Novo cliente que terá acesso a aplicação
     */
    public void cadastrar(Cliente cliente) {
        bancoDados.setCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    /**
     * Exclui um cliente específico.
     * 
     * @param cpf CPF do cliente
     */
    public void excluir(String cpf) {
        if (bancoDados.getCliente().getCpf().equals(cpf)) {
            bancoDados.setCliente(null);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente inexistente.");
        }
    }
}
