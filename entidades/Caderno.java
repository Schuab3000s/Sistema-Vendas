package entidades;

import entidades.constantes.Materias;

/**
 * Classe que representa um caderno, que é uma especialização de um produto da
 * loja.
 * 
 * @author schuab
 */
public class Caderno extends Produto {

    /**
     * Quantidade de matérias que o caderno pode ter.
     */
    private Materias tipo;
    private String materia;

    /**
     * Obtém o tipo de matérias do caderno.
     * 
     * @return O tipo de matérias do caderno.
     */
    public Materias getTipo() {
        return tipo;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * Define o tipo de matérias do caderno.
     * 
     * @param tipo O tipo de matérias do caderno a ser definido.
     */
    public void setTipo(Materias tipo) {
        this.tipo = tipo;
    }

    /**
     * Calcula o frete do caderno.
     * 
     * @return O valor do frete do caderno.
     */
    @Override
    public double calcularFrete() {
        return (getPreco() * tipo.getFator()) + getQuantidade();
    }

    @Override
    public String toString() {
        return "Caderno{" +
                " tipo=" + tipo + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
