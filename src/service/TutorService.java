package service;

import model.Tutor;

import java.util.ArrayList;

public class TutorService {

    private ArrayList<Tutor> tutores = new ArrayList<>();

    public void cadastrarTutor(Tutor tutor) {
        tutores.add(tutor);
    }

    public ArrayList<Tutor> listarTutores() {
        return tutores;
    }

    public Tutor buscarTutor(String nome) {

        for (Tutor t : tutores) {

            if (t.getNome().toLowerCase()
                    .contains(nome.toLowerCase())) {

                return t;
            }
        }

        return null;
    }
}