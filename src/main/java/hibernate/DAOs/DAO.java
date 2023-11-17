package hibernate.DAOs;

import hibernate.models.Task;

import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO {
    private static DAO instance;
    protected EntityManager entityManager;

    public static DAO getInstace() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    private DAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("jpa_exemplo");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        System.out.println("entity:" + entityManager);
        return entityManager;
    }

    public void inserirTarefa(Task task) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void atualizarTarefa(Task task) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(task);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void excluirTarefa(int id) {
        try {
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, id);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Task lerTarefa(int id) {
        return entityManager.find(Task.class, id);
    }

    public List<Task> pesquisarTarefaPorNome(String nomeTarefa) {
        try {
            String queryString = "SELECT t FROM Task t WHERE t.nome_tarefa = :nome";
            TypedQuery<Task> query = entityManager.createQuery(queryString, Task.class);
            query.setParameter("nome", nomeTarefa);

            List<Task> resultados = query.getResultList();

            return resultados;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deletarTarefaPorNome(String nomeTarefa) {
        try {
            entityManager.getTransaction().begin();
            String queryString = "DELETE FROM Task t WHERE t.nome_tarefa = :nome";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("nome", nomeTarefa);
            int rowsDeleted = query.executeUpdate();
            entityManager.getTransaction().commit();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Tarefa deletada!");
            } else {
                JOptionPane.showMessageDialog(null, "Tarefa não encontrada para deletar.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void atualizarStatusTarefaPorNome(String nomeTarefa, String novoStatus) {
        try {
            entityManager.getTransaction().begin();
            String queryString = "UPDATE Task t SET t.status_tarefa = :novoStatus WHERE t.nome_tarefa = :nome";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("novoStatus", novoStatus);
            query.setParameter("nome", nomeTarefa);
            int rowsUpdated = query.executeUpdate();
            entityManager.getTransaction().commit();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Tarefa atualizada com novo status!");
            } else {
                JOptionPane.showMessageDialog(null, "Tarefa não encontrada para atualizar.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Task pesquisaTarefa(String nomeTarefa) {
        return entityManager.find(Task.class, nomeTarefa);
    }
}
