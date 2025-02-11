package br.com.projetoEstagio.dao;

import java.util.List;

import br.com.projetoEstagio.model.Responsavel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager; 
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ResponsavelDAO {

	
    @PersistenceContext(name = "tarefas_estagio")
	private EntityManager en;
    
    public List<Responsavel> buscarTodos() {
       
        return en.createQuery("SELECT r FROM responsaveis r", Responsavel.class).getResultList();
    }
	
 
}
