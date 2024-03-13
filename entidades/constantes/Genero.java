package entidades.constantes;

/**
 * Gêneros dos livros vendidos.
 * Cada gênero tem um fator que influencia no cálculo do frete.
 * 
 * @author schuab
 */
public enum Genero {

    DRAMA(0.15), // O fator é 15%
    SUSPENSE(0.10), // O fator é 10%
    ROMANCE(0.05); // O fator é 5%

    private double fator;

    /**
     * Construtor.
     * 
     * @param fator Valor por tipo que influencia no cálculo do frete (em %).
     */
    Genero(double fator) {
        this.fator = fator;
    }

    /**
     * Obtém o fator que influencia no cálculo do frete.
     * 
     * @return O fator de influência no cálculo do frete (em %).
     */
    public double getFator() {
        return fator;
    }
}
