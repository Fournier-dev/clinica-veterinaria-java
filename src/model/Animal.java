package model;

public abstract class Animal {

    private String nome;
    private int idade;
    private Tutor tutor;

    public Animal(
            String nome,
            int idade,
            Tutor tutor) {

        this.nome = nome;
        this.idade = idade;
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public abstract String emitirSom();

    @Override
    public String toString() {
        return nome;
    }
}