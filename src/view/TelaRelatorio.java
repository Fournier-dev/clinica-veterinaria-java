package view;

import model.Animal;
import model.Consulta;
import service.AnimalService;
import service.ConsultaService;

import javax.swing.*;
import java.awt.*;

public class TelaRelatorio extends JFrame {

    public TelaRelatorio(
            AnimalService animalService,
            ConsultaService consultaService) {

        setTitle("Relatório Geral");

        setSize(600,400);

        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();

        area.setEditable(false);

        StringBuilder texto =
                new StringBuilder();

        texto.append("RELATÓRIO GERAL\n\n");

        for (Animal animal :
                animalService.listarAnimais()) {

            texto.append(
                    "Tutor: "
                            + animal.getTutor().getNome()
                            + "\n"
            );

            texto.append(
                    "Animal: "
                            + animal.getNome()
                            + "\n"
            );

            for (Consulta consulta :
                    consultaService.listarConsultas()) {

                if (consulta.getAnimal()
                        .equals(animal)) {

                    texto.append(
                            "Consulta: "
                                    + consulta.getData()
                                    + " - "
                                    + consulta.getStatus()
                                    + "\n"
                    );
                }
            }

            texto.append(
                    "----------------------------------\n"
            );
        }

        area.setText(
                texto.toString());

        add(
                new JScrollPane(area),
                BorderLayout.CENTER);

        setVisible(true);
    }
}