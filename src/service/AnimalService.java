package service;

import model.Animal;

import java.util.ArrayList;

public class AnimalService {

    private ArrayList<Animal> animais = new ArrayList<>();

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public ArrayList<Animal> listarAnimais() {
        return animais;
    }

    public Animal buscarAnimal(String nome) {

        for (Animal a : animais) {

            if (a.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {

                return a;
            }
        }

        return null;
    }
}