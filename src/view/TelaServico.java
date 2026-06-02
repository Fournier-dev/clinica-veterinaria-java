package view;

import model.Servico;
import service.ServicoService;

import javax.swing.*;
import java.awt.*;

public class TelaServico extends JFrame {

    private JTextField txtNome;
    private JTextField txtValor;

    private JTextArea area;

    private ServicoService servicoService;

    public TelaServico(ServicoService servicoService) {

        this.servicoService = servicoService;

        setTitle("Serviços");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(3, 2, 10, 10));

        painel.add(new JLabel("Nome:"));

        txtNome = new JTextField();

        painel.add(txtNome);

        painel.add(new JLabel("Valor:"));

        txtValor = new JTextField();

        painel.add(txtValor);

        JButton btnSalvar =
                new JButton("Cadastrar");

        painel.add(btnSalvar);

        add(painel, BorderLayout.NORTH);

        area = new JTextArea();

        area.setEditable(false);

        add(new JScrollPane(area),
                BorderLayout.CENTER);

        btnSalvar.addActionListener(e ->
                salvarServico());

        atualizarLista();

        setVisible(true);
    }

    private void salvarServico() {

        try {

            String nome = txtNome.getText();

            double valor =
                    Double.parseDouble(
                            txtValor.getText());

            servicoService.cadastrarServico(
                    nome,
                    valor);

            atualizarLista();

            txtNome.setText("");
            txtValor.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Serviço cadastrado com sucesso!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite um valor válido!"
            );
        }
    }

    private void atualizarLista() {

        StringBuilder texto =
                new StringBuilder();

        for (Servico s :
                servicoService.listarServicos()) {

            texto.append(
                    s.getNome()
                            + " - R$ "
                            + s.getValor()
                            + "\n"
            );
        }

        area.setText(texto.toString());
    }
}