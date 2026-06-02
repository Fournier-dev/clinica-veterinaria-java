package view;

import model.Animal;
import model.Cachorro;
import model.Gato;
import model.Tutor;
import service.AnimalService;
import service.TutorService;

import javax.swing.*;
import java.awt.*;

public class TelaAnimal extends JFrame {

    private JTextField txtNome;
    private JTextField txtIdade;

    private JComboBox<String> cbTipo;
    private JComboBox<Tutor> cbTutor;

    private AnimalService animalService;
    private TutorService tutorService;

    public TelaAnimal(
            AnimalService animalService,
            TutorService tutorService) {

        this.animalService = animalService;
        this.tutorService = tutorService;

        setTitle("Cadastro de Animal");

        setSize(450,300);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,2,10,10));

        add(new JLabel("Nome:"));

        txtNome = new JTextField();

        add(txtNome);

        add(new JLabel("Idade:"));

        txtIdade = new JTextField();

        add(txtIdade);

        add(new JLabel("Tipo:"));

        cbTipo = new JComboBox<>();

        cbTipo.addItem("Cachorro");
        cbTipo.addItem("Gato");

        add(cbTipo);

        add(new JLabel("Tutor:"));

        cbTutor = new JComboBox<>();

        for (Tutor t : tutorService.listarTutores()) {
            cbTutor.addItem(t);
        }

        add(cbTutor);

        JButton btnSalvar = new JButton("Salvar");

        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvarAnimal());

        setVisible(true);
    }

    private void salvarAnimal() {

        String nome = txtNome.getText();

        int idade = Integer.parseInt(
                txtIdade.getText());

        Tutor tutor =
                (Tutor) cbTutor.getSelectedItem();

        Animal animal;

        if (cbTipo.getSelectedItem()
                .equals("Cachorro")) {

            animal = new Cachorro(
                    nome,
                    idade,
                    tutor);

        } else {

            animal = new Gato(
                    nome,
                    idade,
                    tutor);
        }

        animalService.cadastrarAnimal(animal);

        JOptionPane.showMessageDialog(
                this,
                "Animal cadastrado com sucesso!"
        );

        txtNome.setText("");
        txtIdade.setText("");
    }
}