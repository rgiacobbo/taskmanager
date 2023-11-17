package hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "taskmanager")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_tarefa")
    private int id_tarefa;
    @Column(name="nome_tarefa")
    private String nome_tarefa;
    @Column(name="status_tarefa")
    private String status_tarefa;

    public String getStatusTarefa() {
        return status_tarefa;
    }

    public void setStatusTarefa(String status_tarefa) {
        this.status_tarefa = status_tarefa;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public void setNome_tarefa(String nometarefa) {
        this.nome_tarefa = nometarefa;
    }

    

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int Id) {
        this.id_tarefa = Id;
    }
    
    
    
    
}
