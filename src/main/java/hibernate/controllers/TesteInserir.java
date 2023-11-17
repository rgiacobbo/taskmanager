package hibernate.controllers;

import hibernate.DAOs.DAO;
import hibernate.models.Task;

public class TesteInserir {
    public static void main(String[] args) {
        Task tarefa = new Task();
        tarefa.setNome_tarefa("Arrumar a casa");
        tarefa.setStatusTarefa("Pendente");
        
        DAO.getInstace().inserirTarefa(tarefa);
    }
}
