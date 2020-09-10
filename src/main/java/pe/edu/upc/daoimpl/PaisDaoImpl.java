package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPaisDao;
import pe.edu.upc.entity.Pais;

public class PaisDaoImpl implements IPaisDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Pais pais) {
		try {
			em.persist(pais);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listar() {
		List<Pais> lista = new ArrayList<Pais>();
		try {
			Query q = em.createQuery("select p from Pais p");
			lista = (List<Pais>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPais) {
		Pais pais = new Pais();
		try {
			pais = em.getReference(Pais.class,idPais);
			em.remove(pais);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}				
	}

}
