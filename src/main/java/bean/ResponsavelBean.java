package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoEstagio.dao.ResponsavelDAO;
import br.com.projetoEstagio.model.Responsavel;
import jakarta.annotation.PostConstruct;

@Named
@ViewScoped
public class ResponsavelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
    private ResponsavelDAO responsavelDAO;

    private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

    @PostConstruct
    public void init() {
        carregarResponsaveis();
    }

    public void carregarResponsaveis() {
        responsaveis = responsavelDAO.buscarTodos();
    }

    public List<Responsavel> getResponsaveis() {
    	return responsaveis;
    }
}