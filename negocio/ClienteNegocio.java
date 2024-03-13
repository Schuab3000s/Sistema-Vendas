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

    public void salvar(Cliente novoCliente) {
        // Verificar se o cliente já está cadastrado
        Optional<Cliente> clienteExistente = bancoDados.consultarClientePorCPF(novoCliente.getCpf());
        if (clienteExistente.isPresent()) {
            System.out.println("Este CPF já está cadastrado.");
            return;
        }

        // Verificar se o CPF é válido
        if (!validarCPF(novoCliente.getCpf())) {
            System.out.println("CPF inválido.");
            return;
        }

        // Salvar o cliente
        bancoDados.setCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private boolean validarCPF(String cpf) {
        // Verifica se o CPF tem 11 dígitos
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
    
        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit > 9) {
            firstDigit = 0;
        }
    
        // Verifica se o primeiro dígito verificador é igual ao décimo caractere do CPF
        if ((cpf.charAt(9) - '0') != firstDigit) {
            return false;
        }
    
        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit > 9) {
            secondDigit = 0;
        }
    
        // Verifica se o segundo dígito verificador é igual ao décimo primeiro caractere do CPF
        return (cpf.charAt(10) - '0') == secondDigit;
    }
    
}
