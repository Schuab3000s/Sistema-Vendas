package entidades;

/**
 * Classe que representa a entidade cliente. Este pode fazer um pedido.
 * 
 * @author schuab
 */
public class Cliente {

    /**
     * Nome completo do cliente.
     */
    private String nome;

    /**
     * Número de CPF (Cadastro de Pessoa Física) do cliente.
     */
    private String cpf;

    /**
     * Construtor padrão que inicializa o cliente com nome e CPF padrão.
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente() {
        this.nome = "";
        this.cpf = "";
    }

    /**
     * Obtém o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome do cliente.
     * 
     * @param nome O nome do cliente a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CPF do cliente.
     * 
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     * 
     * @param cpf O CPF do cliente a ser definido.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Representação em string do cliente.
     * 
     * @return Uma string representando o cliente.
     */
    @Override
    public String toString() {
        return "Cliente{ nome='" + nome + "'}";
    }
}
