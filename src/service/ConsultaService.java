package service;

import model.Consulta;

import java.util.ArrayList;

public class ConsultaService {

    private ArrayList<Consulta> consultas =
            new ArrayList<>();

    public void cadastrarConsulta(
            Consulta consulta) {

        consultas.add(consulta);
    }

    public ArrayList<Consulta> listarConsultas() {
        return consultas;
    }
}