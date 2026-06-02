package view;

import model.Animal;
import service.AnimalService;

import javax.swing.*;
import java.awt.*;

public class TelaBuscaAnimal extends JFrame {

    private JTextField txtNome;
    private JTextArea area;

    private AnimalService animalService;

    public TelaBuscaAnimal(
            AnimalService animalService) {

        this.animalService =
                animalService;

        setTitle("Buscar Animal");

        setSize(400,300);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painel = new JPanel();

        painel.add(new JLabel("Nome:"));

        txtNome = new JTextField(15);

        painel.add(txtNome);

        JButton btnBuscar =
                new JButton("Buscar");

        painel.add(btnBuscar);

        add(painel, BorderLayout.NORTH);

        area = new JTextArea();

        area.setEditable(false);

        add(new JScrollPane(area),
                BorderLayout.CENTER);

        btnBuscar.addActionListener(
                e -> buscarAnimal());

        setVisible(true);
    }

    private void buscarAnimal() {

        String nome =
                txtNome.getText();

        Animal animal =
                animalService.buscarAnimal(nome);

        if (animal != null) {

            area.setText(
                    "Nome: "
                            + animal.getNome()
                            + "\nIdade: "
                            + animal.getIdade()
                            + "\nTutor: "
                            + animal.getTutor().getNome()
            );

        } else {

            area.setText(
                    "Animal não encontrado."
            );
        }
    }
}