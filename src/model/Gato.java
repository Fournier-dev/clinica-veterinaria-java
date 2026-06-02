package model;

public class Gato extends Animal {

    public Gato(String nome, int idade, Tutor tutor) {
        super(nome, idade, tutor);
    }

    @Override
    public String emitirSom() {
        return "Miau!";
    }
}