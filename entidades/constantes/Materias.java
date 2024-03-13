package entidades.constantes;

/**
 * Quantidade de matérias do caderno vendido.
 * Cada quantidade de matérias tem um fator que influencia no cálculo do frete.
 * 
 * @author schuab
 */
public enum Materias {

    M_2(0.2), // O fator é 0.2
    M_5(0.5), // O fator é 0.5
    M_10(1.0); // O fator é 1.0

    private double fator;

    /**
     * Construtor.
     * 
     * @param fator Valor por tipo que influencia no cálculo do frete (em escala de 0 a 1).
     */
    Materias(double fator) {
        this.fator = fator;
    }

    /**
     * Obtém o fator que influencia no cálculo do frete.
     * 
     * @return O fator de influência no cálculo do frete (em escala de 0 a 1).
     */
    public double getFator() {
        return fator;
    }
}

