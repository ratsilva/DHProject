package br.com.doghero.dhproject.Object;

public class Hero {

    String  nome        ;
    String  bairro      ;
    String  preco       ;
    String  foto        ;
    boolean isSuperHero ;

    @Override
    public String toString() {
        return nome + " - " + bairro + " - " + preco + " - " + foto + " - " + isSuperHero;
    }
}
