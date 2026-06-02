package view;

import model.Tutor;
import service.TutorService;

import javax.swing.*;
import java.awt.*;

public class TelaBuscaTutor extends JFrame {

    private JTextField txtNome;
    private JTextArea area;

    private TutorService tutorService;

    public TelaBuscaTutor(
            TutorService tutorService) {

        this.tutorService = tutorService;

        setTitle("Buscar Tutor");

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
                e -> buscarTutor());

        setVisible(true);
    }

    private void buscarTutor() {

        String nome =
                txtNome.getText();

        Tutor tutor =
                tutorService.buscarTutor(nome);

        if (tutor != null) {

            area.setText(
                    "Nome: "
                            + tutor.getNome()
                            + "\nTelefone: "
                            + tutor.getTelefone()
            );

        } else {

            area.setText(
                    "Tutor não encontrado."
            );
        }
    }
}