package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPaisDao;
import pe.edu.upc.entity.Pais;
import pe.edu.upc.service.IPaisService;


@Named
@RequestScoped

public class PaisServiceImpl implements IPaisService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPaisDao pD;

	@Override
	public void insertar(Pais pais) {
		pD.insertar(pais);		
	}

	@Override
	public List<Pais> listar() {
		return pD.listar();
	}

	@Override
	public void eliminar(int idPais) {
		pD.eliminar(idPais);		
	}

}
