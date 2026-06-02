package view;

import model.Animal;
import model.Consulta;
import service.AnimalService;
import service.ConsultaService;

import javax.swing.*;
import java.awt.*;

public class TelaConsulta extends JFrame {

    private JComboBox<Animal> cbAnimal;
    private JTextField txtData;
    private JComboBox<String> cbStatus;

    private JTextArea area;

    private ConsultaService consultaService;
    private AnimalService animalService;

    public TelaConsulta(
            ConsultaService consultaService,
            AnimalService animalService) {

        this.consultaService = consultaService;
        this.animalService = animalService;

        setTitle("Consultas");

        setSize(500,400);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painel = new JPanel();

        painel.setLayout(
                new GridLayout(
                        4,
                        2,
                        10,
                        10));

        painel.add(new JLabel("Animal:"));

        cbAnimal = new JComboBox<>();

        for (Animal a :
                animalService.listarAnimais()) {

            cbAnimal.addItem(a);
        }

        painel.add(cbAnimal);

        painel.add(new JLabel("Data:"));

        txtData = new JTextField();

        painel.add(txtData);

        painel.add(new JLabel("Status:"));

        cbStatus = new JComboBox<>();

        cbStatus.addItem("Agendada");
        cbStatus.addItem("Realizada");

        painel.add(cbStatus);

        JButton btnSalvar =
                new JButton("Cadastrar");

        painel.add(btnSalvar);

        add(painel, BorderLayout.NORTH);

        area = new JTextArea();

        area.setEditable(false);

        add(
                new JScrollPane(area),
                BorderLayout.CENTER
        );

        btnSalvar.addActionListener(
                e -> salvarConsulta());

        atualizarLista();

        setVisible(true);
    }

    private void salvarConsulta() {

        Animal animal =
                (Animal) cbAnimal.getSelectedItem();

        String data =
                txtData.getText();

        String status =
                (String) cbStatus.getSelectedItem();

        Consulta consulta =
                new Consulta(
                        animal,
                        data,
                        status);

        consultaService
                .cadastrarConsulta(
                        consulta);

        atualizarLista();

        txtData.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Consulta cadastrada!"
        );
    }

    private void atualizarLista() {

        StringBuilder texto =
                new StringBuilder();

        for (Consulta c :
                consultaService
                        .listarConsultas()) {

            texto.append(
                    c.getAnimal().getNome()
                            + " - "
                            + c.getData()
                            + " - "
                            + c.getStatus()
                            + "\n"
            );
        }

        area.setText(
                texto.toString());
    }
}