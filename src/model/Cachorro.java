package model;

public class Cachorro extends Animal {

    public Cachorro(String nome, int idade, Tutor tutor) {
        super(nome, idade, tutor);
    }

    @Override
    public String emitirSom() {
        return "Au Au!";
    }
}