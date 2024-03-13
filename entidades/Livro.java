package entidades;

import entidades.constantes.Genero;

/**
 * Classe que representa um livro, que é uma especialização de um produto da loja.
 * 
 * @author schuab
 */
public class Livro extends Produto {

    /**
     * Nome do livro.
     */
    private String nome;

    /**
     * Gênero do livro.
     */
    private Genero genero;

    /**
     * Obtém o nome do livro.
     * 
     * @return O nome do livro.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do livro.
     * 
     * @param nome O nome do livro a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do livro.
     * 
     * @return O gênero do livro.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Define o gênero do livro.
     * 
     * @param genero O gênero do livro a ser definido.
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Calcula o frete do livro.
     * 
     * @return O valor do frete do livro.
     */
    @Override
    public double calcularFrete() {
        return (getPreco() * (1 + genero.getFator())) * getQuantidade();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
