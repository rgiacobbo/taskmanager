package hibernate.controllers;

import hibernate.DAOs.DAO;
import hibernate.models.Task;

public class TesteDelete {
    public static void main(String[] args) {
        
        int idTarefaParaExcluir = 1;
        DAO dao = DAO.getInstace();
        
        Task tarefaParaExcluir = (Task) dao.lerTarefa(idTarefaParaExcluir);

        if (tarefaParaExcluir != null) {
            dao.excluirTarefa(idTarefaParaExcluir);
            System.out.println("Tarefa excluída com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada para exclusão.");
        }
    }
}
