package hibernate.controllers;

import hibernate.DAOs.DAO;
import hibernate.models.Task;

public class TesteUpdate {
    public static void main(String[] args) {
        
        int idTarefaParaAtualizar = 2;
        
        DAO dao = DAO.getInstace();
        
        Task tarefaParaAtualizar = (Task) dao.lerTarefa(idTarefaParaAtualizar);

        if (tarefaParaAtualizar != null) {
            tarefaParaAtualizar.setNome_tarefa("Arrumar a casa");
            tarefaParaAtualizar.setStatusTarefa("Concluída");
            dao.atualizarTarefa(tarefaParaAtualizar);
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada para atualização.");
        }
    }
}
