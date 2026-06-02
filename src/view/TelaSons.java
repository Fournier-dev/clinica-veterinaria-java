package view;

import model.Animal;
import service.AnimalService;

import javax.swing.*;
import java.awt.*;

public class TelaSons extends JFrame {

    public TelaSons(AnimalService animalService) {

        setTitle("Sons dos Animais");

        setSize(400,300);

        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();

        area.setEditable(false);

        StringBuilder texto = new StringBuilder();

        for (Animal animal : animalService.listarAnimais()) {

            texto.append(
                    animal.getNome()
                            + " -> "
                            + animal.emitirSom()
                            + "\n"
            );
        }

        area.setText(texto.toString());

        add(new JScrollPane(area), BorderLayout.CENTER);

        setVisible(true);
    }
}