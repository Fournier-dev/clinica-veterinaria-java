package view;

import service.AnimalService;
import service.ConsultaService;
import service.ServicoService;
import service.TutorService;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private TutorService tutorService;
    private AnimalService animalService;
    private ServicoService servicoService;
    private ConsultaService consultaService;

    public TelaPrincipal() {

        tutorService = new TutorService();
        animalService = new AnimalService();
        servicoService = new ServicoService();
        consultaService = new ConsultaService();

        setTitle("Clínica Veterinária");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2, 10, 10));

        JButton btnTutor =
                new JButton("Tutor");

        JButton btnAnimal =
                new JButton("Animal");

        JButton btnConsulta =
                new JButton("Cadastrar Consulta");

        JButton btnServico =
                new JButton("Serviços");

        JButton btnRelatorio =
                new JButton("Relatórios");

        JButton btnSom =
                new JButton("Testar Sons");

        add(btnTutor);
        add(btnAnimal);
        add(btnConsulta);
        add(btnServico);
        add(btnRelatorio);
        add(btnSom);

        btnTutor.addActionListener(e -> {

            Object[] opcoes = {
                    "Cadastrar",
                    "Buscar"
            };

            int opcao =
                    JOptionPane.showOptionDialog(
                            this,
                            "Tutor",
                            "Tutor",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);

            if (opcao == 0) {

                new TelaTutor(tutorService);

            } else if (opcao == 1) {

                new TelaBuscaTutor(tutorService);
            }
        });

        btnAnimal.addActionListener(e -> {

            Object[] opcoes = {
                    "Cadastrar",
                    "Buscar"
            };

            int opcao =
                    JOptionPane.showOptionDialog(
                            this,
                            "Animal",
                            "Animal",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);

            if (opcao == 0) {

                new TelaAnimal(
                        animalService,
                        tutorService);

            } else if (opcao == 1) {

                new TelaBuscaAnimal(
                        animalService);
            }
        });

        btnConsulta.addActionListener(e ->
                new TelaConsulta(
                        consultaService,
                        animalService));

        btnServico.addActionListener(e ->
                new TelaServico(servicoService));

        btnRelatorio.addActionListener(e ->
                new TelaRelatorio(
                        animalService,
                        consultaService));

        btnSom.addActionListener(e ->
                new TelaSons(animalService));

        setVisible(true);
    }
}