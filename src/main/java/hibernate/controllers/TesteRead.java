package hibernate.controllers;

import hibernate.DAOs.DAO;
import hibernate.models.Task;

public class TesteRead {
    public static void main(String[] args) {
        
        int idTarefa = 1;
        
        Task tarefaConsultada = (Task) DAO.getInstace().lerTarefa(idTarefa);

        if (tarefaConsultada != null) {
            System.out.println("Tarefa lida: " + tarefaConsultada.getNome_tarefa());
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
}
