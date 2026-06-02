package service;

import model.Servico;

import java.util.HashSet;
import java.util.Set;

public class ServicoService {

    private Set<Servico> servicos = new HashSet<>();

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
    }

    public void cadastrarServico(
            String nome,
            double valor) {

        servicos.add(
                new Servico(
                        nome,
                        valor));
    }

    public Set<Servico> listarServicos() {
        return servicos;
    }
}