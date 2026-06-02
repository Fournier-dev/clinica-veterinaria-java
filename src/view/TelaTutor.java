package view;

import model.Tutor;
import service.TutorService;

import javax.swing.*;
import java.awt.*;

public class TelaTutor extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;

    private TutorService tutorService;

    public TelaTutor(TutorService tutorService) {

        this.tutorService = tutorService;

        setTitle("Cadastro de Tutor");

        setSize(400,250);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,2,10,10));

        add(new JLabel("Nome:"));

        txtNome = new JTextField();

        add(txtNome);

        add(new JLabel("Telefone:"));

        txtTelefone = new JTextField();

        add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");

        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvarTutor());

        setVisible(true);
    }

    private void salvarTutor() {

        String nome = txtNome.getText();

        String telefone = txtTelefone.getText();

        Tutor tutor = new Tutor(nome, telefone);

        tutorService.cadastrarTutor(tutor);

        JOptionPane.showMessageDialog(
                this,
                "Tutor cadastrado com sucesso!"
        );

        txtNome.setText("");
        txtTelefone.setText("");
    }
}